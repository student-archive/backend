package daos

import com.github.javafaker.Faker
import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.daos.AttachmentTypeDao
import ru.zgz.star.backend.models.Account
import ru.zgz.star.backend.models.AttachmentType
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

class AttachmentTypeDaoSpecification extends Specification {

  def setupSpec() {
    def dao = new AttachmentTypeDao()
    dao.deleteAll()
  }

  @Ignore
  def "Create new attachment type in database and verify it"() {
    given: "Creating data access object"
      AttachmentTypeDao dao = new AttachmentTypeDao()
      def added = new AttachmentType().setTypeName("test")

    when: "Adding new record"
      def created = dao.add(added)

    then: "Fetching it and verifying"
      AttachmentType fetched = dao.getById(created.getId() as String)
      fetched.typeName == added.typeName
  }

  @Ignore
  def "Select from attachment_type table should return 1 row"() {
    given: "Creating data access object"
      AttachmentTypeDao dao = new AttachmentTypeDao()

    when: "Fetching all records from attachment_type table"
      List<AttachmentType> attachmentTypes = dao.getAll()

    then: "Count of records in the table should be equal 1"
      attachmentTypes.size() == 1
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

