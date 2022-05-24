package daos

import ru.zgz.star.backend.daos.AttachmentTypeDao
import ru.zgz.star.backend.models.AttachmentType
import spock.lang.Shared
import spock.lang.Specification

class AttachmentTypeDaoSpecification extends Specification {

  @Shared
          attachmentTypeId

  def setupSpec() {
    def dao = new AttachmentTypeDao()
    dao.deleteAll()
  }

  def "Create new attachment type in database and verify it"() {
    given: "Creating data access object"
      AttachmentTypeDao dao = new AttachmentTypeDao()
      def added = new AttachmentType().setTypeName("test")

    when: "Adding new record"
      def created = dao.add(added)
      attachmentTypeId = created.getId()

    then: "Fetching it and verifying"
      AttachmentType fetched = dao.getById(created.getId() as String)
      fetched.typeName == added.typeName
  }

  def "Select from attachment_type table should return 1 row"() {
    given: "Creating data access object"
      AttachmentTypeDao dao = new AttachmentTypeDao()

    when: "Fetching all records from attachment_type table"
      List<AttachmentType> attachmentTypes = dao.getAll()

    then: "Count of records in the table should be equal 1"
      attachmentTypes.size() == 1
  }

  def "Update attachment type should modify entity in database"() {
    given:
      def dao = new AttachmentTypeDao()
      AttachmentType fetched = dao.getById(attachmentTypeId.toString())
      fetched.setTypeName("test2")

    when:
      def updated = dao.update(fetched)

    then:
      updated.size() == 1
      updated[0].getTypeName() == fetched.getTypeName()
  }

  def "Delete certificate by id"() {
    given:
      def dao = new AttachmentTypeDao()

    when:
      dao.deleteById((UUID) attachmentTypeId)
      def fetched = dao.getAll()

    then:
      fetched.size() == 0
  }

  def "Delete all records in account table"() {
    given: "Creating data access object"
      AttachmentTypeDao dao = new AttachmentTypeDao()

    when: "Deleting all records in table and fetching all records"
      dao.deleteAll()
      List<AttachmentType> attachmentTypes = dao.getAll()

    then: "Verifying that all records was deleted"
      attachmentTypes.size() == 0

  }
}

