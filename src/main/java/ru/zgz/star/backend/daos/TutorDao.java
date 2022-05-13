package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Tutor;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for tutor table. */
public class TutorDao {
  private final Connection connection;

  /** Instantiates a new Tutor dao. */
  public TutorDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Tutor dao.
   *
   * @param connection the connection
   */
  public TutorDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new Tutor.
   *
   * @param tutor the tutor
   */
  public void add(Tutor tutor) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into tutor(first_name, last_name, patronymic, email, phone, link, is_working)"
                  + " values (?,?,?,?,?,?,?);");
      query.setString(1, tutor.getFirstName());
      query.setString(2, tutor.getLastName());
      query.setString(3, tutor.getPatronymic());
      query.setString(4, tutor.getEmail());
      query.setString(5, tutor.getPhone());
      query.setString(6, tutor.getLink());
      query.setBoolean(7, tutor.isIsWorking());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all tutors.
   *
   * @return list of tutors
   */
  public List<Tutor> getAll() {
    List<Tutor> tutors = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from tutor");
      while (rs.next()) {
        tutors.add(
            new Tutor()
                .setId(UUID.fromString(rs.getString("id")))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"))
                .setPatronymic(rs.getString("patronymic"))
                .setEmail(rs.getString("email"))
                .setPhone(rs.getString("phone"))
                .setLink(rs.getString("link"))
                .setIsWorking(rs.getBoolean("is_working")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return tutors;
  }

  /**
   * Gets exact tutor by id.
   *
   * @param id id of tutor
   * @return exact tutor
   */
  public Tutor getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from tutor where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildTutor(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact tutor by id.
   *
   * @param id id of tutor
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from tutor where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all tutors. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from tutor");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Tutor buildTutor(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Tutor()
          .setId(UUID.fromString(rs.getString("id")))
          .setFirstName(rs.getString("first_name"))
          .setLastName(rs.getString("last_name"))
          .setPatronymic(rs.getString("patronymic"))
          .setEmail(rs.getString("email"))
          .setLink(rs.getString("link"))
          .setIsWorking(rs.getBoolean("is_working"));
    } else {
      return null;
    }
  }
}
