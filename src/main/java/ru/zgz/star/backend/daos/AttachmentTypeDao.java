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
   * Updates attachment type.
   *
   * @param attachmentType updated attachment type
   * @return updated attachment type
   */
  public List<AttachmentType> update(AttachmentType attachmentType) {
    List<AttachmentType> attachmentTypes = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update attachment_type set type_name=? where id=?", Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, attachmentType.getTypeName());
      query.setObject(2, attachmentType.getId());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        attachmentTypes.add(buildAttachmentType(rs));
      }
      query.close();
      connection.commit();

      return attachmentTypes;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new attachment type.
   *
   * @param attachmentType the attachment type
   * @return created attachment type
   */
  public AttachmentType add(AttachmentType attachmentType) {
    try {
      AttachmentType newAttachmentType;
      PreparedStatement query =
          connection.prepareStatement(
              "insert into attachment_type(type_name) values (?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, attachmentType.getTypeName());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newAttachmentType = buildAttachmentType(rs);
      } else {
        throw new ModelBuildException("Can't create attachment type");
      }
      query.close();
      connection.commit();
      return newAttachmentType;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
        attachmentTypes.add(buildAttachmentType(rs));
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
      if (rs.next()) {
        return buildAttachmentType(rs);
      } else {
        throw new ModelBuildException("Can't create attachment type");
      }
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
      st.executeUpdate();
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
    return new AttachmentType()
        .setId(UUID.fromString(rs.getString("id")))
        .setTypeName(rs.getString("type_name"));
  }
}
