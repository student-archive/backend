package ru.zgz.star.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Model for table <code>certificate</code>.
 *
 * <p>Storing certificates
 *
 * @author dadyarri
 */
@Entity
@Table(name = "certificate")
public class Certificate {
  private String id;
  private String certificateName;
  private String certificateDescription;
  private String office;

  @Id
  @GeneratedValue
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCertificateName() {
    return certificateName;
  }

  public void setCertificateName(String name) {
    this.certificateName = name;
  }

  public String getCertificateDescription() {
    return certificateDescription;
  }

  public void setCertificateDescription(String description) {
    this.certificateDescription = description;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }
}
