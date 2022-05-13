package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Speciality;
import ru.zgz.star.backend.models.University;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for speciality table. */
public class SpecialityDao {
  private final Connection connection;

  /** Instantiates a new Speciality dao. */
  public SpecialityDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Speciality dao.
   *
   * @param connection the connection
   */
  public SpecialityDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new Speciality.
   *
   * @param speciality the speciality
   */
  public void add(Speciality speciality) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into speciality(speciality_name) values (?);");
      query.setString(1, speciality.getSpecialityName());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all speciality.
   *
   * @return list of specialities
   */
  public List<Speciality> getAll() {
    List<Speciality> specialities = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from speciality");
      while (rs.next()) {
        specialities.add(
            new Speciality()
                .setId(UUID.fromString(rs.getString("id")))
                .setSpecialityName(rs.getString("speciality_name")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return specialities;
  }

  /**
   * Gets exact speciality by id.
   *
   * @param id id of speciality
   * @return exact speciality
   */
  public Speciality getById(String id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from speciality where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildSpeciality(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }


  /**
   * Delete exact speciality by id.
   *
   * @param id id of speciality
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from speciality where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all specialities. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from speciality");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Speciality buildSpeciality(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Speciality()
          .setId(UUID.fromString(rs.getString("id")))
          .setSpecialityName(rs.getString("speciality_name"));
    } else {
      return null;
    }
  }
}
