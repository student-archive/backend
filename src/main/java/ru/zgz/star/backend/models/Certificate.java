package ru.zgz.star.backend.models;

import java.util.List;


/**
 * Model for table <code>certificate</code>.
 *
 * <p>Storing certificates
 *
 * @author dadyarri
 */

public class Certificate {
  private String id;
  private String certificateName;
  private String certificateDescription;
  private String office;
  public List<Employee> employees;
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

  public List<Employee> getEmployees() {
    return employees;
  }

  public Certificate setEmployees(List<Employee> employees) {
    this.employees = employees;
    return this;
  }
}
