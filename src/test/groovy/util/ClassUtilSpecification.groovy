package util

import ru.zgz.star.backend.responses.ErrorResponse
import ru.zgz.star.backend.util.ClassUtil
import spock.lang.Specification

class ClassUtilSpecification extends Specification {

  def "Merge two objects when left field is null"() {
    given:
      def one = new ErrorResponse()
      def another = new ErrorResponse(400, "bar")

    when:
      def merged = (ErrorResponse) ClassUtil.mergeObjects(one, another)

    then:
      merged.code == another.code
      merged.message == another.message
      merged.exception == null
  }

  def "Merge two objects when right field is null"() {
    given:
      def one = new ErrorResponse(400, "bar")
      def another = new ErrorResponse(exception: "foo")

    when:
      def merged = (ErrorResponse) ClassUtil.mergeObjects(one, another)

    then:
      merged.code == one.code
      merged.message == one.message
      merged.exception == another.exception
  }

  def "Merge two objects when both fields is not null"() {
    given:
      def one = new ErrorResponse(400, "bar")
      def another = new ErrorResponse(500, "foo")

    when:
      def merged = (ErrorResponse) ClassUtil.mergeObjects(one, another)

    then:
      merged.code == one.code
      merged.message == one.message
      merged.exception == null
  }
}
