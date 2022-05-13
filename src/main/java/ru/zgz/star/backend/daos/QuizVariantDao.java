package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.QuizVariant;
import ru.zgz.star.backend.models.University;
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
   * Create new QuizVariant.
   *
   * @param quizVariant the quizVariant
   */
  public void add(QuizVariant quizVariant) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into quiz_variant(question_id, quiz_variant_text, is_correct) values (?,?,?);");
      query.setObject(1, quizVariant.getQuestion());
      query.setString(1, quizVariant.getQuizVariantText());
      query.setBoolean(1, quizVariant.getIsCorrect());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
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
                .setQuestion((UUID)rs.getObject("question_id"))
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
      return buildQuizVarian(rs);
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

  private QuizVariant buildQuizVarian(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new QuizVariant()
          .setId(UUID.fromString(rs.getString("id")))
          .setQuestion((UUID) rs.getObject("question_id"))
          .setQuizVariantText(rs.getString("quiz_variant_text"))
          .setIsCorrect(rs.getBoolean("is_correct"));
    } else {
      return null;
    }
  }
}
