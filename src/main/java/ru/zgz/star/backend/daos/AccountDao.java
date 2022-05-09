package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for account table. */
public class AccountDao {
  private final Connection connection;

  /** Instantiates a new Account dao. */
  public AccountDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Account dao.
   *
   * @param connection the connection
   */
  public AccountDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Checks if account exists.
   *
   * @param id id of account
   * @return true if account exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from account where id=?");
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
   * Updates account.
   *
   * @param account updated account
   */
  public void update(Account account) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update account set email=?, password_hash=?, last_active_date=? where id=?");
      query.setString(1, account.getEmail());
      query.setString(2, account.getPasswordHash());
      query.setInt(3, account.getLastActiveDate());
      query.setObject(4, account.getId());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  /**
   * Create new account.
   *
   * @param account the account
   */
  public void add(Account account) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into account(email, password_hash, last_active_date) values (?, ?, ?);");
      query.setString(1, account.getEmail());
      query.setString(2, account.getPasswordHash());
      query.setInt(3, account.getLastActiveDate());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all accounts.
   *
   * @return list of accounts
   */
  public List<Account> getAll() {
    List<Account> accounts = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from account");
      while (rs.next()) {
        accounts.add(
            new Account()
                .setId(UUID.fromString(rs.getString("id")))
                .setEmail(rs.getString("email"))
                .setPasswordHash(rs.getString("password_hash"))
                .setLastActiveDate(rs.getInt("last_active_date")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return accounts;
  }

  /**
   * Gets exact account by id.
   *
   * @param id id of account
   * @return exact account
   */
  public Account getById(String id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from \"account\" where \"id\"=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildAccount(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Gets exact account by email.
   *
   * @param email email of account
   * @return exact account
   */
  public Account getByEmail(String email) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from \"account\" where \"email\"=?");
      query.setString(1, email);
      ResultSet rs = query.executeQuery();
      return buildAccount(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact account by id.
   *
   * @param id id of account
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from account where id=?");
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
      st.executeUpdate("delete from account");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Account buildAccount(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Account()
          .setId(UUID.fromString(rs.getString("id")))
          .setEmail(rs.getString("email"))
          .setPasswordHash(rs.getString("password_hash"))
          .setLastActiveDate(rs.getInt("last_active_date"));
    } else {
      return null;
    }
  }
}
