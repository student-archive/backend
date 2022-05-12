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
import ru.zgz.star.backend.models.AttachmentType;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for attachment_type table. */
public class AttachmentTypeDao {
  private final Connection connection;

  /** Instantiates a new AttachmentType dao. */
  public AttachmentTypeDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new AttachmentType dao.
   *
   * @param connection the connection
   */
  public AttachmentTypeDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new attachment type.
   *
   * @param attachmentType the attachment type
   */
  public void add(AttachmentType attachmentType) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into attachment_type(type_name) values (?);");
      query.setString(1, attachmentType.getTypeName());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all attachment type.
   *
   * @return list of attachment type
   */
  public List<AttachmentType> getAll() {
    List<AttachmentType> attachmentTypes = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from attachment_type");
      while (rs.next()) {
        attachmentTypes.add(
            new AttachmentType()
                .setId(UUID.fromString(rs.getString("id")))
                .setTypeName(rs.getString("typeName")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return attachmentTypes;
  }

  /**
   * Gets exact attachment type by id.
   *
   * @param id id of attachment type
   * @return exact attachment type
   */
  public AttachmentType getById(String id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select * from attachment_type where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildAttachmentType(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }


  /**
   * Delete exact attachment type by id.
   *
   * @param id id of attachment type
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from attachment_type where id=?");
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
      st.executeUpdate("delete from attachment_type");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private AttachmentType buildAttachmentType(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new AttachmentType()
          .setId(UUID.fromString(rs.getString("id")))
          .setTypeName(rs.getString("typeName"));
    } else {
      return null;
    }
  }
}
