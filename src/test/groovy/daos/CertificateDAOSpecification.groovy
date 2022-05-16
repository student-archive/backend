package daos

import ru.zgz.star.backend.daos.CertificateDao
import ru.zgz.star.backend.daos.EmployeeDao
import ru.zgz.star.backend.exceptions.ModelBuildException
import ru.zgz.star.backend.models.Certificate
import ru.zgz.star.backend.models.Employee
import spock.lang.Shared
import spock.lang.Specification

class CertificateDAOSpecification extends Specification {

    @Shared certificateId

    def setupSpec() {
        def dao = new CertificateDao()
        dao.deleteAll()
    }

    def "Create new certificate and validate it"() {
        given:
        def dao = new CertificateDao()
        def employeeDao = new EmployeeDao()
        def employee = employeeDao.add(new Employee().setFirstName("firstName").setLastName("lastName").setPatronymic("middleName"))
        def created = new Certificate().setCertificateName("Справка не твоё дело").setCertificateDescription("some test certificate").setOffice("402-2").setEmployee(employee.id)

        when:
        def added = dao.add(created)
        certificateId = added.id

        then:
        added.getId() != null
        added.getCertificateName() == created.getCertificateName()
        added.getCertificateDescription() == created.getCertificateDescription()
        added.getOffice() == created.getOffice()
        added.getEmployee() == created.getEmployee()
    }

    def "Update certificate should modify entity in database"() {
        given:
        def dao = new CertificateDao()
        Certificate fetched = dao.getById(certificateId.toString())
        fetched.setOffice("402-3")

        when:
        def updated = dao.update(fetched)

        then:
        updated.size() == 1
        updated[0].getOffice() == fetched.getOffice()
    }

    def "Fetch all certificates"() {
        given:
        def dao = new CertificateDao()

        when:
        def fetched = dao.getAll()

        then:
        fetched.size() == 1
        fetched[0].getId() == certificateId
    }

    def "Get certificate by id"() {
        given:
        def dao = new CertificateDao()

        when:
        def fetched = dao.getById(certificateId.toString())

        then:
        notThrown(ModelBuildException)
        fetched.getId() == certificateId
    }

    def cleanupSpec() {
        def dao = new CertificateDao()
        dao.deleteAll()
    }

}
