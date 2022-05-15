package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Software;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for software table. */
public class SoftwareDao {
  private final Connection connection;

  /** Instantiates a new Software dao. */
  public SoftwareDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Software dao.
   *
   * @param connection the connection
   */
  public SoftwareDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new Software.
   *
   * @param software the software
   */
  public void add(Software software) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into software(link, description, subject_id) values (?,?,?);");
      query.setString(1, software.getLink());
      query.setString(2, software.getDescription());
      query.setObject(3, software.getSubject());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all software.
   *
   * @return list of software
   */
  public List<Software> getAll() {
    List<Software> software = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from software");
      while (rs.next()) {
        software.add(
            new Software()
                .setId(UUID.fromString(rs.getString("id")))
                .setDescription(rs.getString("description"))
                .setLink(rs.getString("link"))
                .setSubject((UUID) rs.getObject("subject_id")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return software;
  }

  /**
   * Gets exact software by id.
   *
   * @param id id of software
   * @return exact software
   */
  public Software getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from software where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildSoftware(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact software by id.
   *
   * @param id id of software
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from software where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all software. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from software");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Software buildSoftware(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Software()
          .setId(UUID.fromString(rs.getString("id")))
          .setLink(rs.getString("link"))
          .setDescription(rs.getString("Description"))
          .setSubject((UUID) rs.getObject("subject"));
    } else {
      return null;
    }
  }
}
