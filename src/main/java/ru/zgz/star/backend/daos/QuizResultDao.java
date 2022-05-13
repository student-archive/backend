package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.QuizResult;
import ru.zgz.star.backend.models.Tutor;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for quiz_result table. */
public class QuizResultDao {
  private final Connection connection;

  /** Instantiates a new QuizResult dao. */
  public QuizResultDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new QuizResult dao.
   *
   * @param connection the connection
   */
  public QuizResultDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new TutorQuizResult.
   *
   * @param quizResult the quizResult
   */
  public void add(QuizResult quizResult) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into quiz_result(quiz_id, user_id, result, quiz_submit_date) values (?,?,?,?);");
      query.setObject(1, quizResult.getQuiz());
      query.setObject(2, quizResult.getUser());
      query.setInt(3, quizResult.getResult());
      query.setInt(4, quizResult.getQuizSubmitDate());

      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all quiz results.
   *
   * @return list of quiz results
   */
  public List<QuizResult> getAll() {
    List<QuizResult> quizResults = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from quiz_result");
      while (rs.next()) {
        quizResults.add(
            new QuizResult()
                .setId(UUID.fromString(rs.getString("id")))
                .setQuiz((UUID) rs.getObject("quiz_id"))
                .setUser((UUID) rs.getObject("user_id"))
                .setResult(rs.getInt("result"))
                .setQuizSubmitDate(rs.getInt("quiz_submit_date")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return quizResults;
  }

  /**
   * Gets exact quiz result by id.
   *
   * @param id id of quiz result
   * @return exact quiz result
   */
  public QuizResult getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from quiz_result where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildQuizResult(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact quiz result by id.
   *
   * @param id id of quiz result
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from quiz_result where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all quiz results. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from quiz_result");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private QuizResult buildQuizResult(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new QuizResult()
          .setId(UUID.fromString(rs.getString("id")))
          .setQuiz((UUID) rs.getObject("quiz_id"))
          .setUser((UUID) rs.getObject("user_id"))
          .setResult(rs.getInt("result"));
    } else {
      return null;
    }
  }
}
