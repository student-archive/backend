package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Subject;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for subject table. */
public class SubjectDao {
  private final Connection connection;

  /** Instantiates a new Subject dao. */
  public SubjectDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Subject dao.
   *
   * @param connection the connection
   */
  public SubjectDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Updates subject.
   *
   * @param subject updated subject
   * @return updated subject
   */
  public List<Subject> update(Subject subject) {
    List<Subject> subjects = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update subject set group_id=?, semester=?, subject_name=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, subject.getGroup());
      query.setObject(2, subject.getSemester());
      query.setObject(3, subject.getSubjectName());
      query.setObject(4, subject.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        subjects.add(buildSubject(rs));
      }

      query.close();
      connection.commit();

      return subjects;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new Subject.
   *
   * @param subject the subject
   * @return added subject
   */
  public Subject add(Subject subject) {
    try {
      Subject newSubject = new Subject();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into subject (group_id, subject_name, semester) values (?, ?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, subject.getGroup());
      query.setString(2, subject.getSubjectName());
      query.setInt(3, subject.getSemester());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newSubject = buildSubject(rs);
      }

      query.close();
      connection.commit();

      return newSubject;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all subjects.
   *
   * @return list of subjects
   */
  public List<Subject> getAll() {
    List<Subject> subjects = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from subject");
      while (rs.next()) {
        subjects.add(buildSubject(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return subjects;
  }

  /**
   * Gets exact subject by id.
   *
   * @param id id of subject
   * @return exact subject
   */
  public Subject getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from subject where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildSubject(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return null;
  }

  /**
   * Checks if group exists.
   *
   * @param id id of group
   * @return true if group exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from subject where id=?");
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
   * Delete exact subject by id.
   *
   * @param id id of subject
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from subject where id=?");
      st.setObject(1, id);
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all subjects. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from subject");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Subject buildSubject(ResultSet rs) throws SQLException {
    return new Subject()
        .setId(UUID.fromString(rs.getString("id")))
        .setGroup((UUID) rs.getObject("group_id"))
        .setSubjectName(rs.getString("subject_name"))
        .setSemester(rs.getInt("semester"));
  }
}
