package daos

import ru.zgz.star.backend.daos.CertificateDao
import ru.zgz.star.backend.daos.EmployeeDao
import ru.zgz.star.backend.models.Certificate
import ru.zgz.star.backend.models.Employee
import spock.lang.Specification

class CertificateDAOSpecification extends Specification {

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

        then:
        added.getId() != null
        added.getCertificateName() == created.getCertificateName()
        added.getCertificateDescription() == created.getCertificateDescription()
        added.getOffice() == created.getOffice()
        added.getEmployee() == created.getEmployee()
    }

}
