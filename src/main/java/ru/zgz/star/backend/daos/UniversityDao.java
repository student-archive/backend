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
import ru.zgz.star.backend.models.University;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for university table. */
public class UniversityDao {
  private final Connection connection;

  /** Instantiates a new University dao. */
  public UniversityDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new University dao.
   *
   * @param connection the connection
   */
  public UniversityDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Updates university.
   *
   * @param university updated university
   * @return updated university
   */
  public List<University> update(University university) {
    List<University> accounts = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update university set university_name=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, university.getUniversityName());
      query.setObject(2, university.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        accounts.add(buildUniversity(rs));
      }

      query.close();
      connection.commit();

      return accounts;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new University.
   *
   * @param university the university
   * @return added university
   */
  public University add(University university) {
    try {
      University newUniversity = new University();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into university(university_name) values (?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, university.getUniversityName());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newUniversity = buildUniversity(rs);
      } else {
        throw new ModelBuildException("Can't create university");
      }

      query.close();
      connection.commit();

      return newUniversity;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all universities.
   *
   * @return list of universities
   */
  public List<University> getAll() {
    List<University> universities = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from university");
      while (rs.next()) {
        universities.add(buildUniversity(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return universities;
  }

  /**
   * Gets exact university by id.
   *
   * @param id id of university
   * @return exact university
   */
  public University getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from university where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildUniversity(rs);
      } else {
        throw new ModelBuildException("Can't create university");
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact university by id.
   *
   * @param id id of university
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from university where id=?");
      st.setObject(1, id);
      st.executeUpdate();
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all universities. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from university");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private University buildUniversity(ResultSet rs) throws SQLException {
    return new University()
        .setId(UUID.fromString(rs.getString("id")))
        .setUniversityName(rs.getString("university_name"));
  }
}
