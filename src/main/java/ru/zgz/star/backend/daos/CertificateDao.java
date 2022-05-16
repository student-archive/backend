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
   * Updates account.
   *
   * @param certificate updated account
   * @return updated account
   */
  public List<Certificate> update(Certificate certificate) {
    List<Certificate> certificates = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update certificate set employee_id=?, certificate_description=?, certificate_name=?,"
                  + " office=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, certificate.getEmployee());
      query.setObject(2, certificate.getCertificateDescription());
      query.setObject(3, certificate.getCertificateName());
      query.setObject(4, certificate.getOffice());
      query.setObject(4, certificate.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        certificates.add(buildCertificate(rs));
      }
      query.close();
      connection.commit();

      return certificates;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new certificate.
   *
   * @param certificate the certificate
   * @return created certificate
   */
  public Certificate add(Certificate certificate) {
    try {
      Certificate newCertificate = new Certificate();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into certificate(certificate_name, certificate_description, office,"
                  + " employee_id) values (?, ?, ?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, certificate.getCertificateName());
      query.setString(2, certificate.getCertificateDescription());
      query.setString(3, certificate.getOffice());
      query.setObject(4, certificate.getEmployee());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newCertificate = buildCertificate(rs);
      } else {
        throw new ModelBuildException("Can't create certificate");
      }

      query.close();
      connection.commit();
      return newCertificate;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
        certificates.add(buildCertificate(rs));
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
      st.executeUpdate();
      st.close();
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
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Certificate buildCertificate(ResultSet rs) throws SQLException {
    return new Certificate()
        .setId(UUID.fromString(rs.getString("id")))
        .setCertificateName(rs.getString("certificate_name"))
        .setCertificateDescription(rs.getString("certificate_description"))
        .setEmployee(UUID.fromString(rs.getString("employee_id")))
        .setOffice(rs.getString("office"));
  }
}
