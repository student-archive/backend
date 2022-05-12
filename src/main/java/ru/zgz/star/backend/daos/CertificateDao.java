package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.AttachmentType;
import ru.zgz.star.backend.models.Certificate;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for certificate table. */
public class CertificateDao {
  private final Connection connection;

  /** Instantiates a new Certificate dao. */
  public CertificateDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Certificate dao.
   *
   * @param connection the connection
   */
  public CertificateDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new certificate.
   *
   * @param certificate the certificate
   */
  public void add(Certificate certificate) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into certificate( certificate_name, certificate_description, office) values (?, ?, ?);");
      query.setString(1, certificate.getCertificateName());
      query.setString(2, certificate.getCertificateDescription());
      query.setString(3, certificate.getOffice());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all certificate.
   *
   * @return list of certificate
   */
  public List<Certificate> getAll() {
    List<Certificate> certificates = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from certificate");
      while (rs.next()) {
        certificates.add(
            new Certificate()
                .setId(UUID.fromString(rs.getString("id")))
                .setCertificateName(rs.getString("certificateName"))
                .setCertificateDescription(rs.getString("CertificateDescription"))
                .setOffice(rs.getString("office")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return certificates;
  }

  /**
   * Gets exact certificate by id.
   *
   * @param id id of certificate
   * @return exact certificate
   */
  public Certificate getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from certificate where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildCertificate(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact certificate by id.
   *
   * @param id id of certificate
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from certificate where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all certificate. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from certificate");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Certificate buildCertificate(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Certificate()
          .setId(UUID.fromString(rs.getString("id")))
          .setCertificateName(rs.getString("certificateName"))
          .setCertificateDescription(rs.getString("CertificateDescription"))
          .setOffice(rs.getString("office"));
    } else {
      return null;
    }
  }
}
