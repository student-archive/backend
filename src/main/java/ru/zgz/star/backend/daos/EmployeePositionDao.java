package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.AttachmentType;
import ru.zgz.star.backend.models.EmployeePosition;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for employee_position table. */
public class EmployeePositionDao {
  private final Connection connection;

  /** Instantiates a new EmployeePosition dao. */
  public EmployeePositionDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new EmployeePosition dao.
   *
   * @param connection the connection
   */
  public EmployeePositionDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new employee position.
   *
   * @param employeePosition the attachment type
   */
  public void add(EmployeePosition employeePosition) {
    try {
      PreparedStatement query =
          connection.prepareStatement("insert into employee_position(position) values (?);");
      query.setString(1, employeePosition.getPositionName());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all attachment type.
   *
   * @return list of attachment type
   */
  public List<EmployeePosition> getAll() {
    List<EmployeePosition> employeePositions = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from employee_position");
      while (rs.next()) {
        employeePositions.add(
            new EmployeePosition()
                .setId(UUID.fromString(rs.getString("id")))
                .setPositionName(rs.getString("positionName")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return employeePositions;
  }

  /**
   * Gets exact employee position by id.
   *
   * @param id id of employee position
   * @return exact employee position
   */
  public EmployeePosition getById(String id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from employee_position where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildEmployeePosition(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact employee position by id.
   *
   * @param id id of employee position
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st =
          connection.prepareStatement("delete from employee_position where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all employee position. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from employee_position");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private EmployeePosition buildEmployeePosition(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new EmployeePosition()
          .setId(UUID.fromString(rs.getString("id")))
          .setPositionName(rs.getString("positionName"));
    } else {
      return null;
    }
  }
}
