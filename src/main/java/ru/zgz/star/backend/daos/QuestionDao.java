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
import ru.zgz.star.backend.models.Question;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for question table. */
public class QuestionDao {
  private final Connection connection;

  /** Instantiates a new Question dao. */
  public QuestionDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Question dao.
   *
   * @param connection the connection
   */
  public QuestionDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new question.
   *
   * @param question the question
   */
  public void add(Question question) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into question( question_text) values (?);");
      query.setString(1, question.getQuestionText());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all question.
   *
   * @return list of question
   */
  public List<Question> getAll() {
    List<Question> questions = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from question");
      while (rs.next()) {
        questions.add(
            new Question()
                .setId(UUID.fromString(rs.getString("id")))
                .setQuestionText(rs.getString("questionText")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return questions;
  }

  /**
   * Gets exact attachment type by id.
   *
   * @param id id of attachment type
   * @return exact attachment type
   */
  public AttachmentType getById(String id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from question where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildQuestion(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }


  /**
   * Delete exact attachment type by id.
   *
   * @param id id of attachment type
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from question where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all accounts. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from question");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Question buildQuestion(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Question()
          .setId(UUID.fromString(rs.getString("id")))
          .setQuestionText(rs.getString("questionText"));
    } else {
      return null;
    }
  }
}
