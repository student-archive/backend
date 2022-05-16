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
   * Instantiates a new quiz dao.
   *
   * @param connection the connection
   */
  public QuizDao(Connection connection) {
    this.connection = connection;
  }

  public List<Quiz> getBySubject(String id) {
    try {
      List<Quiz> quizzes = new ArrayList<>();
      PreparedStatement query =
          connection.prepareStatement("select * from quiz where subject_id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      while (rs.next()) {
        quizzes.add(buildQuiz(rs));
      }
      return quizzes;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Checks if quiz exists.
   *
   * @param id id of quiz
   * @return true if quiz exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query = connection.prepareStatement("select count(*) from quiz where id=?");
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
   * Updates quiz.
   *
   * @param quiz updated quiz
   * @return updated quiz
   */
  public List<Quiz> update(Quiz quiz) {
    List<Quiz> quizzes = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update quiz set quiz_name=?, quiz_description=?, questions_amount=?,"
                  + " subject_id=?  where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, quiz.getQuizName());
      query.setObject(2, quiz.getQuizDescription());
      query.setObject(3, quiz.getQuestionsAmount());
      query.setObject(4, quiz.getSubject());
      query.setObject(5, quiz.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        quizzes.add(buildQuiz(rs));
      }

      query.close();
      connection.commit();

      return quizzes;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new quiz.
   *
   * @param quiz the quiz
   * @return created quiz
   */
  public Quiz add(Quiz quiz) {
    try {
      Quiz newQuiz = new Quiz();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into quiz(quiz_name, quiz_description, questions_amount,"
                  + " subject_id) values (?, ?, ?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, quiz.getQuizName());
      query.setObject(2, quiz.getQuizDescription());
      query.setObject(3, quiz.getQuestionsAmount());
      query.setObject(4, quiz.getSubject());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newQuiz = buildQuiz(rs);
      } else {
        throw new ModelBuildException("Can't create quiz");
      }

      query.close();
      connection.commit();
      return newQuiz;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all quizzes.
   *
   * @return list of quizzes
   */
  public List<Quiz> getAll() {
    List<Quiz> quizzes = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from quiz");
      while (rs.next()) {
        quizzes.add(buildQuiz(rs));
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
      if (rs.next()) {
        return buildQuiz(rs);
      } else {
        throw new ModelBuildException("Can't create quiz");
      }
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
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Quiz buildQuiz(ResultSet rs) throws SQLException {
    return new Quiz()
        .setId(UUID.fromString(rs.getString("id")))
        .setQuizName(rs.getString("quiz_name"))
        .setSubject((UUID) rs.getObject("subject_id"))
        .setQuestionsAmount(rs.getInt("questions_amount"))
        .setQuizDescription(rs.getString("quiz_description"));
  }
}
