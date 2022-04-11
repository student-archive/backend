package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
