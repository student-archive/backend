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
import ru.zgz.star.backend.models.Sex;
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
   * Updates sex.
   *
   * @param sex updated sex
   * @return updated sex
   */
  public List<Sex> update(Sex sex) {
    List<Sex> accounts = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update sex set sex_name=? where id=?", Statement.RETURN_GENERATED_KEYS);
      query.setString(1, sex.getSexName());

      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        accounts.add(buildSex(rs));
      }

      query.close();
      connection.commit();

      return accounts;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new Sex.
   *
   * @param sex the sex
   */
  public Sex add(Sex sex) {
    try {
      Sex newSex = new Sex();
      PreparedStatement query =
          connection.prepareStatement("insert into sex(id,sex_name) values (?,?);");
      query.setShort(1, sex.getId());
      query.setString(2, sex.getSexName());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newSex = buildSex(rs);
      } else {
        throw new ModelBuildException("Can't create sex");
      }

      query.close();
      connection.commit();
      return newSex;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
        sexes.add(new Sex().setId(rs.getShort("id")).setSexName(rs.getString("sex_name")));
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
      if (rs.next()) {
        return buildSex(rs);
      } else {
        throw new ModelBuildException("Can't create sex");
      }
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
      st.executeUpdate();
      st.close();
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
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Sex buildSex(ResultSet rs) throws SQLException {

    return new Sex().setId(rs.getShort("id")).setSexName(rs.getString("sex_name"));
  }
}
