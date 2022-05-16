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
import ru.zgz.star.backend.models.QuizVariant;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for quiz_variant table. */
public class QuizVariantDao {
  private final Connection connection;

  /** Instantiates a new QuizVariant dao. */
  public QuizVariantDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new QuizVariant dao.
   *
   * @param connection the connection
   */
  public QuizVariantDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Updates at Quiz Variant.
   *
   * @param quizVariant updated Quiz Variant
   * @return updated Quiz Variant
   */
  public List<QuizVariant> update(QuizVariant quizVariant) {
    List<QuizVariant> quizVariants = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update quiz_variant set question_id=?, quiz_variant_text=?, is_correct=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, quizVariant.getQuestion());
      query.setObject(2, quizVariant.getQuizVariantText());
      query.setObject(3, quizVariant.getIsCorrect());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        quizVariants.add(buildQuizVariant(rs));
      }
      query.close();
      connection.commit();

      return quizVariants;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new QuizVariant.
   *
   * @param quizVariant the quizVariant
   */
  public QuizVariant add(QuizVariant quizVariant) {
    try {
      QuizVariant newQuizVariant = new QuizVariant();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into quiz_variant(question_id, quiz_variant_text, is_correct) values"
                  + " (?,?,?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, quizVariant.getQuestion());
      query.setString(2, quizVariant.getQuizVariantText());
      query.setBoolean(3, quizVariant.getIsCorrect());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newQuizVariant = buildQuizVariant(rs);
      } else {
        throw new ModelBuildException("Can't create quiz variant");
      }
      query.close();
      connection.commit();
      return newQuizVariant;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all quiz variants.
   *
   * @return list of quiz variants
   */
  public List<QuizVariant> getAll() {
    List<QuizVariant> quizVariants = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from quiz_variant");
      while (rs.next()) {
        quizVariants.add(
            new QuizVariant()
                .setId(UUID.fromString(rs.getString("id")))
                .setQuestion((UUID) rs.getObject("question_id"))
                .setQuizVariantText(rs.getString("quiz_variant_text"))
                .setIsCorrect(rs.getBoolean("is_correct")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return quizVariants;
  }

  /**
   * Gets exact quiz variant by id.
   *
   * @param id id of quiz variant
   * @return exact quiz variant
   */
  public QuizVariant getById(String id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from quiz_variant where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildQuizVariant(rs);
      } else {
        throw new ModelBuildException("Can't create account");
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact quiz variant by id.
   *
   * @param id id of quiz variant
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from quiz_variant where id=?");
      st.setObject(1, id);
      st.executeUpdate();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all quiz variants. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from quiz_variant");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private QuizVariant buildQuizVariant(ResultSet rs) throws SQLException {
    return new QuizVariant()
        .setId(UUID.fromString(rs.getString("id")))
        .setQuestion((UUID) rs.getObject("question_id"))
        .setQuizVariantText(rs.getString("quiz_variant_text"))
        .setIsCorrect(rs.getBoolean("is_correct"));
  }
}
