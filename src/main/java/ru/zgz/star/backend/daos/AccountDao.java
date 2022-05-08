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

public class AccountDao {
  private final Connection connection;

  public AccountDao() {
    this.connection = DbUtil.getConnection();
  }

  public AccountDao(Connection connection) {
    this.connection = connection;
  }

  public void add(Account user) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into account(email, password_hash, last_active_date) values (?, ?, ?);");
      query.setString(1, user.getEmail());
      query.setString(2, user.getPasswordHash());
      query.setInt(3, user.getLastActiveDate());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

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

  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from account where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

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
