package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private String id;

  @Column(name = "certificate_name")
  private String certificateName;

  @Column(name = "certificate_description")
  private String certificateDescription;

  @Column(name = "office")
  private String office;

  public Certificate() {}

  public Certificate(String certificateName, String certificateDescription, String office) {
    this.certificateName = certificateName;
    this.certificateDescription = certificateDescription;
    this.office = office;
  }

  public String getId() {
    return id;
  }

  public Certificate setId(String id) {
    this.id = id;
    return this;
  }

  public String getCertificateName() {
    return certificateName;
  }

  public Certificate setCertificateName(String name) {
    this.certificateName = name;
    return this;
  }

  public String getCertificateDescription() {
    return certificateDescription;
  }

  public Certificate setCertificateDescription(String description) {
    this.certificateDescription = description;
    return this;
  }

  public String getOffice() {
    return office;
  }

  public Certificate setOffice(String office) {
    this.office = office;
    return this;
  }
}
