package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>certificate</code>.
 *
 * <p>Storing certificates
 *
 * @author dadyarri
 */
public class Certificate {
  private UUID id;
  private String certificateName;
  private String certificateDescription;
  private String office;


  /** Instantiate a new empty Certificate object. */
  public Certificate() {}

  /**
   * Instantiate a new Certificate object with the specified values.
   *
   * @param certificateName name of the certificate
   * @param certificateDescription description of the certificate
   * @param office office where the certificate is issuing
   */
  public Certificate(String certificateName, String certificateDescription, String office) {
    this.certificateName = certificateName;
    this.certificateDescription = certificateDescription;
    this.office = office;
  }

  /**
   * Gets the id of the certificate.
   *
   * @return the id of the certificate
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets the id of the certificate.
   *
   * @param id new id of the certificate
   * @return object with the new id
   */
  public Certificate setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets the name of the certificate.
   *
   * @return the name of the certificate
   */
  public String getCertificateName() {
    return certificateName;
  }

  /**
   * Sets the name of the certificate.
   *
   * @param name new name of the certificate
   * @return object with the new name
   */
  public Certificate setCertificateName(String name) {
    this.certificateName = name;
    return this;
  }

  /**
   * Gets the description of the certificate.
   *
   * @return the description of the certificate
   */
  public String getCertificateDescription() {
    return certificateDescription;
  }

  /**
   * Sets the description of the certificate.
   *
   * @param description new description of the certificate
   * @return object with the new description
   */
  public Certificate setCertificateDescription(String description) {
    this.certificateDescription = description;
    return this;
  }

  /**
   * Gets the office where the certificate is issuing.
   *
   * @return the office where the certificate is issuing
   */
  public String getOffice() {
    return office;
  }

  /**
   * Sets the office where the certificate is issuing.
   *
   * @param office new office where the certificate is issuing
   * @return object with the new office
   */
  public Certificate setOffice(String office) {
    this.office = office;
    return this;
  }
}
