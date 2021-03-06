package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.exceptions.ModelBuildException;
import ru.zgz.star.backend.models.Speciality;
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
   * Checks if speciality exists.
   *
   * @param id id of speciality
   * @return true if speciality exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from speciality where id=?");
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
   * Updates speciality.
   *
   * @param speciality updated speciality
   * @return updated speciality
   */
  public List<Speciality> update(Speciality speciality) {
    List<Speciality> specialities = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update speciality set speciality_name=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, speciality.getSpecialityName());
      query.setObject(2, speciality.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        specialities.add(buildSpeciality(rs));
      }

      query.close();
      connection.commit();

      return specialities;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new Speciality.
   *
   * @param speciality the speciality
   * @return added speciality
   */
  public Speciality add(Speciality speciality) {
    try {
      Speciality newSpeciality = new Speciality();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into speciality(speciality_name) values (?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, speciality.getSpecialityName());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newSpeciality = buildSpeciality(rs);
      } else {
        throw new ModelBuildException("Can't create speciality");
      }

      query.close();
      connection.commit();

      return newSpeciality;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
        specialities.add(buildSpeciality(rs));
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
      PreparedStatement query = connection.prepareStatement("select * from speciality where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildSpeciality(rs);
      } else {
        throw new ModelBuildException("Can't create account");
      }
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
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Speciality buildSpeciality(ResultSet rs) throws SQLException {
    return new Speciality()
        .setId(UUID.fromString(rs.getString("id")))
        .setSpecialityName(rs.getString("speciality_name"));
  }
}
