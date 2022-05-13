package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>attachment_type</code>.
 *
 * <p>Storing types of attachments
 *
 * @author ironalex
 */
public class AttachmentType {
  private UUID id;
  private String typeName;


  /** Instantiates new empty attachment type. */
  public AttachmentType() {}

  /**
   * Instantiates new attachment type.
   *
   * @param typeName name of type
   */
  public AttachmentType(String typeName) {
    this.typeName = typeName;
  }

  /**
   * Sets id of type.
   *
   * @param id new id
   * @return object with new id
   */
  public AttachmentType setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets id of type.
   *
   * @return id of type
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets name of type.
   *
   * @param typeName new name of type
   * @return object with new name of type
   */
  public AttachmentType setTypeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

  /**
   * Gets name of type.
   *
   * @return name of type
   */
  public String getTypeName() {
    return typeName;
  }
}
