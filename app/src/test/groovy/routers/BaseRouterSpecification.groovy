package routers

import ru.zgz.star.backend.util.SparkStarterUtil
import spock.lang.Specification

class BaseRouterSpecification extends Specification {
    def setupSpec() {
        new SparkStarterUtil().startSparkAppIfNotRunning(4567)
    }

    def cleanupSpec() {
        new SparkStarterUtil().killServer()
    }
}
