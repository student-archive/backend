package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Sex;
import ru.zgz.star.backend.models.Tutor;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for sex table. */
public class SexDao {
  private final Connection connection;

  /** Instantiates a new Sex dao. */
  public SexDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Sex dao.
   *
   * @param connection the connection
   */
  public SexDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new Sex.
   *
   * @param sex the sex
   */
  public void add(Sex sex) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into sex(id,sex_name) values (?,?);");
      query.setShort(1, sex.getId());
      query.setString(2, sex.getSexName());
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all sex.
   *
   * @return list of sex
   */
  public List<Sex> getAll() {
    List<Sex> sexes = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from sex");
      while (rs.next()) {
        sexes.add(
            new Sex()
                .setId(rs.getShort("id"))
                .setSexName(rs.getString("sex_name")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return sexes;
  }

  /**
   * Gets exact sex by id.
   *
   * @param id id of sex
   * @return exact sex
   */
  public Sex getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from sex where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildSex(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact sex by id.
   *
   * @param id id of sex
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from sex where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all sexes. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from sex");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Sex buildSex(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Sex()
          .setId(rs.getShort("id"))
          .setSexName(rs.getString("sex_name"));
    } else {
      return null;
    }
  }
}
