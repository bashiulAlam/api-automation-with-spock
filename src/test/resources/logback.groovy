import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import static ch.qos.logback.classic.Level.TRACE
import static ch.qos.logback.classic.Level.WARN

appender("CONSOLE", ConsoleAppender) {
    filter(ThresholdFilter) {
        level = TRACE
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%date [%thread] %-5level %logger - %X %msg %n"
    }
}
appender("FILE", RollingFileAppender) {
    file = "./log/e2e.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "./log/e2e-%d{yyyy-MM-dd}.log"
    }
    filter(ThresholdFilter) {
        level = TRACE
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%date [%-17thread] %-5level %-45logger{45} [correlationId=%X{correlationId}] [mpaId=%X{mpaId}] [cardId=%X{cardId}] [email=%X{email}] %msg %n"
    }
}
logger("com.assignment.endtoendtest", TRACE, ["FILE"])
root(WARN, ["CONSOLE"])