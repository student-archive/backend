package database

import ru.zgz.star.backend.util.DbUtil
import spock.lang.Specification

class DbUtilSpecification extends Specification {

  def "Connection to database should be successful"() {
    given:
      def connection = DbUtil.getConnection()
    expect:
      connection != null
  }
}
