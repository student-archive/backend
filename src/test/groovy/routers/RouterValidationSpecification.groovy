package routers

import ru.zgz.star.backend.util.ClassUtil
import spark.Request
import spark.Response
import spock.lang.Specification

class RouterValidationSpecification extends Specification {
  def "All routers should implement get http method" () {
    when:
      for (Class<?> cls : ClassUtil.findAllClasses("ru.zgz.star.backend.routes")) {
        cls.getMethod("get", Request, Response)
      }

    then:
      notThrown(NoSuchMethodException)
  }
  def "All routers should implement post http method" () {
    when:
      for (Class<?> cls : ClassUtil.findAllClasses("ru.zgz.star.backend.routes")) {
        cls.getMethod("post", Request, Response)
      }

    then:
      notThrown(NoSuchMethodException)
  }
  def "All routers should implement put http method" () {
    when:
      for (Class<?> cls : ClassUtil.findAllClasses("ru.zgz.star.backend.routes")) {
        cls.getMethod("put", Request, Response)
      }

    then:
      notThrown(NoSuchMethodException)
  }
  def "All routers should implement patch http method" () {
    when:
      for (Class<?> cls : ClassUtil.findAllClasses("ru.zgz.star.backend.routes")) {
        cls.getMethod("patch", Request, Response)
      }

    then:
      notThrown(NoSuchMethodException)
  }
  def "All routers should implement delete http method" () {
    when:
      for (Class<?> cls : ClassUtil.findAllClasses("ru.zgz.star.backend.routes")) {
        cls.getMethod("delete", Request, Response)
      }

    then:
      notThrown(NoSuchMethodException)
  }
}
