package util

import ru.zgz.star.backend.util.SparkStarterUtil
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class BaseRouterSpecification extends Specification {
    def setupSpec() {
        new SparkStarterUtil().startSparkAppIfNotRunning(4567)
    }

    def cleanupSpec() {
        new SparkStarterUtil().killServer()
    }
}
