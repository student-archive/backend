package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
   * Instantiates a new Account dao.
   *
   * @param connection the connection
   */
  public EventPriorityDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Checks if event priority exists.
   *
   * @param id id of event priority
   * @return true if event priority exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from event_priority where id=?");
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
   * Updates event priority.
   *
   * @param eventPriority updated eventPriority
   * @return updated eventPriority
   */
  public List<EventPriority> update(EventPriority eventPriority) {
    List<EventPriority> eventPriorities = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update event_priority set priority_name=?, priority_description=?  where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, eventPriority.getPriorityName());
      query.setObject(2, eventPriority.getPriorityDescription());
      query.setObject(3, eventPriority.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        eventPriorities.add(buildEventPriority(rs));
      }

      query.close();
      connection.commit();

      return eventPriorities;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new event priority.
   *
   * @param eventPriority the eventPriority
   * @return created eventPriority
   */
  public EventPriority add(EventPriority eventPriority) {
    try {
      EventPriority newEventPriority = new EventPriority();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into event_priority(priority_name, priority_description) values (?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, eventPriority.getPriorityName());
      query.setString(2, eventPriority.getPriorityDescription());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newEventPriority = buildEventPriority(rs);
      }

      query.close();
      connection.commit();
      return newEventPriority;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
        eventPriorities.add(buildEventPriority(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return eventPriorities;
  }

  /**
   * Gets exact event priority by id.
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
      if (rs.next()) {
        return buildEventPriority(rs);
      } else {
        return null;
      }
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
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private EventPriority buildEventPriority(ResultSet rs) throws SQLException {
    return new EventPriority()
        .setId(UUID.fromString(rs.getString("id")))
        .setPriorityName(rs.getString("priority_name"))
        .setPriorityDescription(rs.getString("priority_description"));
  }
}
