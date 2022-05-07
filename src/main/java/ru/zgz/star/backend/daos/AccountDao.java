package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            new Account(
                rs.getString("email"),
                rs.getString("password_hash"),
                rs.getInt("last_active_date")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return accounts;
  }
}
