package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {

  private UUID id;
  private String username;
  private String passwordHash;
  private Instant lastLoginDate;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setLastLoginDate(Instant lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public Instant getLastLoginDate() {
    return lastLoginDate;
  }
}
