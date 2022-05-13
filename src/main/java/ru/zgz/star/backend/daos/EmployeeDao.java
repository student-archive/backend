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
import ru.zgz.star.backend.models.Employee;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for employee table. */
public class EmployeeDao {
  private final Connection connection;

  /** Instantiates a new Employee dao. */
  public EmployeeDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Employee dao.
   *
   * @param connection the connection
   */
  public EmployeeDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new employee.
   *
   * @param employee the attachment type
   */
  public void add(Employee employee) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into employee(first_name, last_name, patronymic, email, phone, link) values (?, ?, ?, ?, ?, ?);");
      query.setObject(1, employee.getFirstName());
      query.setObject(2, employee.getLastName());
      query.setObject(3, employee.getPatronymic());
      query.setObject(4, employee.getEmail());
      query.setObject(5, employee.getPhone());
      query.setObject(5, employee.getLink());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all employee.
   *
   * @return list of employee
   */
  public List<Employee> getAll() {
    List<Employee> employees = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from employee");
      while (rs.next()) {
        employees.add(
            new Employee()
                .setId(UUID.fromString(rs.getString("id")))
                .setFirstName(rs.getString("firstName"))
                .setLastName(rs.getString("lastName"))
                .setPatronymic(rs.getString("patronymic"))
                .setEmail(rs.getString("email"))
                .setPhone(rs.getString("phone"))
                .setLink(rs.getString("link")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return employees;
  }

  /**
   * Gets exact employee by id.
   *
   * @param id id of employee
   * @return exact employee
   */
  public Employee getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from employee where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildEmployee(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact employee by id.
   *
   * @param id id of employee
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from employee where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all employee. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from employee");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Employee buildEmployee(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Employee()
          .setId(UUID.fromString(rs.getString("id")))
          .setFirstName(rs.getString("firstName"))
          .setLastName(rs.getString("lastName"))
          .setPatronymic(rs.getString("patronymic"))
          .setEmail(rs.getString("email"))
          .setPhone(rs.getString("phone"))
          .setLink(rs.getString("link"));
    } else {
      return null;
    }
  }
}
