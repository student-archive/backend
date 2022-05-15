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
   * Checks if event exists.
   *
   * @param id id of event
   * @return true if event exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from event where id=?");
      query.setObject(1, id);
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return rs.getInt(1) > 0;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return false;
  }
  /**
   * Updates event.
   *
   * @param event updated event
   * @return updated event
   */
  public List<Event> update(Event event) {
    List<Event> events = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update event set event_text=?, event_description=?, event_date=?,"
                  + " event_priority_id=? where id=?;",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, event.getEventText());
      query.setObject(2, event.getEventDescription());
      query.setObject(3, event.getEventDate());
      query.setObject(4, event.getEventPriority());
      query.setObject(5, event.getId());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        events.add(buildEvent(rs));
      }
      query.close();
      connection.commit();

      return events;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new event.
   *
   * @param event the event
   * @return created event
   */
  public Event add(Event event) {
    try {
      Event newEvent = new Event();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into event( event_text, event_description, event_date, event_priority_id)"
                  + " values (?, ?, ?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, event.getEventText());
      query.setObject(2, event.getEventDescription());
      query.setObject(3, event.getEventDate());
      query.setObject(4, event.getEventPriority());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newEvent = buildEvent(rs);
      }

      query.close();
      connection.commit();

      return newEvent;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
        events.add(buildEvent(rs));
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
      if (rs.next()) {
        return buildEvent(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return null;
  }

  /**
   * Gets exact event by group.
   *
   * @param id id of group
   * @return list of events
   */
  public List<Event> getByGroup(String id) {
    try {
      List<Event> events = new ArrayList<>();
      PreparedStatement query = connection.prepareStatement("select * from event where group_id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      while (rs.next()) {
        events.add(buildEvent(rs));
      }
      return events;
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
    return new Event()
        .setId(UUID.fromString(rs.getString("id")))
        .setEventText(rs.getString("event_text"))
        .setEventDescription(rs.getString("event_description"))
        .setEventDate(rs.getInt("event_date"))
        .setEventPriority(UUID.fromString(rs.getString("event_priority_id")));
  }
}
