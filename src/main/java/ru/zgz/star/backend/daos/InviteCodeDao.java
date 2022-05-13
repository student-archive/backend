package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.InviteCode;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for invite_code table. */
public class InviteCodeDao {
  private final Connection connection;

  /** Instantiates a new InviteCode dao. */
  public InviteCodeDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new InviteCode dao.
   *
   * @param connection the connection
   */
  public InviteCodeDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Checks if invite code exists.
   *
   * @param id id of account
   * @return true if account exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from invite_code where id=?");
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
   * @param inviteCode updated invite code
   */
  public void update(InviteCode inviteCode) {
    try {
      checkValidity(inviteCode);
      PreparedStatement query =
          connection.prepareStatement(
              "update invite_code set invite_code=?, activated_date=?, account_id=?, is_valid=? where id=?");
      query.setObject(1, inviteCode.getInviteCode());
      query.setObject(2, inviteCode.getActivationDate());
      query.setObject(3, inviteCode.getAccount());
      query.setObject(4, inviteCode.getIsValid());
      query.setObject(5, inviteCode.getId());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Create new invite code.
   *
   * @param inviteCode the invite code
   */
  public void add(InviteCode inviteCode) {
    try {
      checkValidity(inviteCode);

      PreparedStatement query =
          connection.prepareStatement(
              "insert into invite_code(account_id, invite_code, activated_date, is_valid) values (?, ?, ?, ?);");
      query.setObject(1, inviteCode.getAccount());
      query.setString(2, inviteCode.getInviteCode());
      query.setObject(3, inviteCode.getActivationDate());
      query.setBoolean(4, inviteCode.getIsValid());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all invite codes.
   *
   * @return list of invite codes
   */
  public List<InviteCode> getAll() {
    List<InviteCode> inviteCodes = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from invite_code");
      while (rs.next()) {
        inviteCodes.add(
            new InviteCode()
                .setId(UUID.fromString(rs.getString("id")))
                .setInviteCode(rs.getString("invite_code"))
                .setActivationDate(rs.getInt("activated_date"))
                .setIsValid(rs.getBoolean("is_valid")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return inviteCodes;
  }

  /**
   * Gets exact invite code by id.
   *
   * @param id id of invite code
   * @return exact invite code
   */
  public InviteCode getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from invite_code where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildInviteCode(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Gets exact invite code by code.
   *
   * @param code invite code
   * @return exact invite code
   */
  public InviteCode getByCode(String code) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from invite_code where invite_code=?");
      query.setString(1, code);
      ResultSet rs = query.executeQuery();
      return buildInviteCode(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact invite code by id.
   *
   * @param id id of invite code
   */
  public void deleteById(java.util.UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from invite_code where id=?");
      st.setObject(1, id);
      st.executeUpdate();
      st.close();
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
      st.executeUpdate("delete from invite_code");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void checkValidity(InviteCode inviteCode) {

    boolean isActivationDateEqualsZero;
    try {
      isActivationDateEqualsZero = inviteCode.getActivationDate() == 0;
    } catch (NullPointerException e) {
      isActivationDateEqualsZero = true;
    }

    if (!inviteCode.getIsValid() && inviteCode.getAccount() == null) {
      throw new IllegalArgumentException("Invalid invite code must have account");
    }

    if (!inviteCode.getIsValid()
        && (inviteCode.getActivationDate() == null || isActivationDateEqualsZero)) {
      throw new IllegalArgumentException("Invalid invite code must have activation date");
    }

    if (inviteCode.getIsValid() && inviteCode.getAccount() != null) {
      throw new IllegalArgumentException("Valid invite code must not have account");
    }

    if (inviteCode.getIsValid() && (!isActivationDateEqualsZero)) {
      throw new IllegalArgumentException("Valid invite code must not have activation date");
    }
  }

  private InviteCode buildInviteCode(ResultSet rs) throws SQLException {
    if (rs.next()) {
      InviteCode inviteCode =
          new InviteCode()
              .setId(UUID.fromString(rs.getString("id")))
              .setInviteCode(rs.getString("invite_code"))
              .setIsValid(rs.getBoolean("is_valid"))
              .setActivationDate(rs.getInt("activated_date"));
      if (rs.getString("account_id") != null) {
        inviteCode.setAccount(UUID.fromString(rs.getString("account_id")));
      }
      return inviteCode;
    } else {
      return null;
    }
  }
}
