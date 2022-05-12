package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.models.EventPriority;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for event_priority table. */
public class EventPriorityDao {
  private final Connection connection;

  /** Instantiates a new Account dao. */
  public EventPriorityDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new EventPriority dao.
   *
   * @param connection the connection
   */
  public EventPriorityDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new EventPriority.
   *
   * @param eventPriority the eventPriority
   */
  public void add(EventPriority eventPriority) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into event_priority(priority_name, priority_description) values (?, ?);");
      query.setString(1, eventPriority.getPriorityName());
      query.setString(2, eventPriority.getPriorityDescription());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all event priorities.
   *
   * @return list of event priorities
   */
  public List<EventPriority> getAll() {
    List<EventPriority> eventPriorities = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from event_priority");
      while (rs.next()) {
        eventPriorities.add(
            new EventPriority()
                .setId(UUID.fromString(rs.getString("id")))
                .setPriorityName(rs.getString("priority_name"))
                .setPriorityDescription(rs.getString("priority_description")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return eventPriorities;
  }

  /**
   * Gets exact eventPriority by id.
   *
   * @param id id of event priority
   * @return exact event priority
   */
  public EventPriority getById(String id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from event_priority where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildEventPriority(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }


  /**
   * Delete exact event priority by id.
   *
   * @param id id of event priority
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from event_priority where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all event priorities. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from event_priority");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private EventPriority buildEventPriority(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new EventPriority()
          .setId(UUID.fromString(rs.getString("id")))
          .setPriorityName(rs.getString("priority_name"))
          .setPriorityDescription(rs.getString("priority_description"));
    } else {
      return null;
    }
  }
}
