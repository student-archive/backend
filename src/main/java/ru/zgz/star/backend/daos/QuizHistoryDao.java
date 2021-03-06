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
import ru.zgz.star.backend.models.QuizHistory;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for quiz_history table. */
public class QuizHistoryDao {
  private final Connection connection;

  /** Instantiates a new QuizHistory dao. */
  public QuizHistoryDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new QuizHistory dao.
   *
   * @param connection the connection
   */
  public QuizHistoryDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Updates attachment type.
   *
   * @param quizHistory updated attachment type
   * @return updated attachment type
   */
  public List<QuizHistory> update(QuizHistory quizHistory) {
    List<QuizHistory> quizHistories = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update quiz_history set question_id=?, selected_variant_id=?, user_id=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, quizHistory.getQuestion());
      query.setObject(2, quizHistory.getSelectedVariant());
      query.setObject(3, quizHistory.getUser());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        quizHistories.add(buildQuizHistory(rs));
      }
      query.close();
      connection.commit();

      return quizHistories;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new quiz history.
   *
   * @param quizHistory the quiz history
   */
  public QuizHistory add(QuizHistory quizHistory) {
    try {
      QuizHistory newQuizHistory = new QuizHistory();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into quiz_history(question_id, selected_variant_id, user_id) values (?, ?,"
                  + " ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, quizHistory.getQuestion());
      query.setObject(2, quizHistory.getSelectedVariant());
      query.setObject(3, quizHistory.getUser());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newQuizHistory = buildQuizHistory(rs);
      } else {
        throw new ModelBuildException("Can't create quiz history");
      }
      query.close();
      connection.commit();
      return newQuizHistory;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all quiz history.
   *
   * @return list of quiz history
   */
  public List<QuizHistory> getAll() {
    List<QuizHistory> quizHistories = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from quiz_history");
      while (rs.next()) {
        quizHistories.add(buildQuizHistory(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return quizHistories;
  }

  /**
   * Gets exact quiz history by id.
   *
   * @param id id of quiz history
   * @return exact quiz history
   */
  public QuizHistory getById(String id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from quiz_history where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildQuizHistory(rs);
      } else {
        throw new ModelBuildException("Can't create account");
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact quiz history by id.
   *
   * @param id id of quiz history
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from quiz_history where id=?");
      st.setObject(1, id);
      st.executeUpdate();
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all quiz history. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from quiz_history");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private QuizHistory buildQuizHistory(ResultSet rs) throws SQLException {
    return new QuizHistory()
        .setId(UUID.fromString(rs.getString("id")))
        .setQuestion(UUID.fromString(rs.getString("question")))
        .setSelectedVariant(UUID.fromString(rs.getString("selected_variant_id")))
        .setUser(UUID.fromString(rs.getString("user_id")));
  }
}
