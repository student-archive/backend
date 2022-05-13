package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Event;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for event table. */
public class EventDao {
  private final Connection connection;

  /** Instantiates a new Event dao. */
  public EventDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Event dao.
   *
   * @param connection the connection
   */
  public EventDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new event.
   *
   * @param event the event
   */
  public void add(Event event) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into event( event_text, event_description, event_date, event_priority_id)"
                  + " values (?, ?, ?, ?);");
      query.setObject(1, event.getEventText());
      query.setObject(2, event.getEventDescription());
      query.setObject(3, event.getEventDate());
      query.setObject(4, event.getEventPriority());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all event.
   *
   * @return list of event
   */
  public List<Event> getAll() {
    List<Event> events = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from event");
      while (rs.next()) {
        events.add(
            new Event()
                .setId(UUID.fromString(rs.getString("id")))
                .setEventText(rs.getString("event_text"))
                .setEventDescription(rs.getString("event_description"))
                .setEventDate(rs.getInt("event_date"))
                .setEventPriority(UUID.fromString(rs.getString("event_priority_id"))));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return events;
  }

  /**
   * Gets exact event by id.
   *
   * @param id id of event
   * @return exact event
   */
  public Event getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from event where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildEvent(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact event by id.
   *
   * @param id id of event
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from event where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all event. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from event");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Event buildEvent(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Event()
          .setId(UUID.fromString(rs.getString("id")))
          .setEventText(rs.getString("event_text"))
          .setEventDescription(rs.getString("event_description"))
          .setEventDate(rs.getInt("event_date"))
          .setEventPriority(UUID.fromString(rs.getString("event_priority_id")));

    } else {
      return null;
    }
  }
}
