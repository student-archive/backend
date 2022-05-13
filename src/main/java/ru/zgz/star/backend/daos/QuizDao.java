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
import ru.zgz.star.backend.models.Quiz;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for quiz table. */
public class QuizDao {
  private final Connection connection;

  /** Instantiates a new Quiz dao. */
  public QuizDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Quiz dao.
   *
   * @param connection the connection
   */
  public QuizDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new quiz.
   *
   * @param quiz the quiz
   */
  public void add(Quiz quiz) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into quiz(quiz_name, quiz_description, questions_amount, subject_id) values (?, ?, ?, ?);");
      query.setString(1, quiz.getQuizName());
      query.setString(2, quiz.getQuizDescription());
      query.setInt(3, quiz.getQuestionsAmount());
      query.setObject(4, quiz.getSubject());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all quiz.
   *
   * @return list of quiz
   */
  public List<Quiz> getAll() {
    List<Quiz> quizzes = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from quiz");
      while (rs.next()) {
        quizzes.add(
            new Quiz()
                .setId(UUID.fromString(rs.getString("id")))
                .setQuizName(rs.getString("quiz_name"))
                .setQuizDescription(rs.getString("quiz_description"))
                .setQuestionsAmount(rs.getInt("quiz_amount"))
                .setSubject(UUID.fromString(rs.getString("subject"))));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return quizzes;
  }

  /**
   * Gets exact quiz by id.
   *
   * @param id id of quiz
   * @return exact quiz
   */
  public Quiz getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from quiz where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildQuiz(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact quiz by id.
   *
   * @param id id of quiz
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from quiz where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all quiz. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from quiz");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Quiz buildQuiz(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Quiz()
          .setId(UUID.fromString(rs.getString("id")))
          .setQuizName(rs.getString("quiz_name"))
          .setQuizDescription(rs.getString("quiz_description"))
          .setQuestionsAmount(rs.getInt("quiz_amount"))
          .setSubject(UUID.fromString(rs.getString("subject")));
    } else {
      return null;
    }
  }
}
