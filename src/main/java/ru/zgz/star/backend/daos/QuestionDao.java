package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
   * Checks if question exists.
   *
   * @param id id of question
   * @return true if question exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from question where id=?");
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
   * Updates question.
   *
   * @param eventPriority updated eventPriority
   * @return updated eventPriority
   */
  public List<Question> update(Question eventPriority) {
    List<Question> questions = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update question set question_text=?, quiz_id=?, correct_answers_amount=?,"
                  + " total_answers_amount=?  where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, eventPriority.getQuestionText());
      query.setObject(2, eventPriority.getQuiz());
      query.setObject(3, eventPriority.getQuiz());
      query.setObject(4, eventPriority.getQuiz());
      query.setObject(5, eventPriority.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        questions.add(buildQuestion(rs));
      }

      query.close();
      connection.commit();

      return questions;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new question.
   *
   * @param question the question
   * @return created question
   */
  public Question add(Question question) {
    try {
      Question newQuestion = new Question();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into question(question_text, quiz_id, correct_answers_amount,"
                  + " total_answers_amount) values (?, ?, ?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, question.getQuestionText());
      query.setObject(2, question.getQuiz());
      query.setObject(3, question.getCorrectAnswersAmount());
      query.setObject(4, question.getTotalAnswersAmount());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newQuestion = buildQuestion(rs);
      }

      query.close();
      connection.commit();
      return newQuestion;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all questions.
   *
   * @return list of questions
   */
  public List<Question> getAll() {
    List<Question> questions = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from question");
      while (rs.next()) {
        questions.add(buildQuestion(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return questions;
  }

  /**
   * Gets exact question by id.
   *
   * @param id id of question
   * @return exact question
   */
  public Question getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from question where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildQuestion(rs);
      } else {
        return null;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
  /**
   * Gets list questions by quiz id.
   *
   * @param id quiz
   * @return list questions by quiz id
   */
  public List<Question> getByQuizId(String id) {
    try {
      List<Question> questions = new ArrayList<>();
      PreparedStatement query =
          connection.prepareStatement("select * from question where quiz_id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      while (rs.next()) {
        questions.add(buildQuestion(rs));
      }
      return questions;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact question by id.
   *
   * @param id id of question
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

  /** Delete all questions. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from question");
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Question buildQuestion(ResultSet rs) throws SQLException {
    return new Question()
        .setId(UUID.fromString(rs.getString("id")))
        .setQuestionText(rs.getString("question_text"))
        .setQuiz((UUID) rs.getObject("quiz_id"))
        .setCorrectAnswersAmount(rs.getInt("correct_answers_amount"))
        .setTotalAnswersAmount(rs.getInt("total_answers_amount"));
  }
}
