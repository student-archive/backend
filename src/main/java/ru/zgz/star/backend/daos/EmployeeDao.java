package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
   * Updates employee.
   *
   * @param employee updated employee
   * @return updated employee
   */
  public List<Employee> update(Employee employee) {
    List<Employee> employees = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update employee set email=?, first_name=?, last_name=?, patronymic=?, link=?, email=?, phone=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, employee.getEmail());
      query.setObject(2, employee.getFirstName());
      query.setObject(3, employee.getLastName());
      query.setObject(4, employee.getPatronymic());
      query.setObject(5, employee.getLink());
      query.setObject(6, employee.getEmail());
      query.setObject(7, employee.getPhone());
      query.setObject(8, employee.getId());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      query.close();
      connection.commit();

      while (rs.next()) {
        employees.add(buildEmployee(rs));
      }

      return employees;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new employee.
   *
   * @param employee the employee
   * @return new employee
   */
  public Employee add(Employee employee) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into employee(first_name, last_name, patronymic, email, phone, link) values (?, ?, ?, ?, ?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, employee.getFirstName());
      query.setObject(2, employee.getLastName());
      query.setObject(3, employee.getPatronymic());
      query.setObject(4, employee.getEmail());
      query.setObject(5, employee.getPhone());
      query.setObject(5, employee.getLink());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      query.close();
      connection.commit();

      if (rs.next()) {
        return buildEmployee(rs);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
        employees.add(buildEmployee(rs));
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
      if (rs.next()) {
        return buildEmployee(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return null;
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
    return new Employee()
        .setId(UUID.fromString(rs.getString("id")))
        .setFirstName(rs.getString("first_name"))
        .setLastName(rs.getString("last_name"))
        .setPatronymic(rs.getString("patronymic"))
        .setEmail(rs.getString("email"))
        .setPhone(rs.getString("phone"))
        .setLink(rs.getString("link"));
  }
}
