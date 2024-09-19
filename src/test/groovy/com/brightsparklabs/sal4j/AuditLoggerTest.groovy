/*
 * Maintained by brightSPARK Labs.
 * www.brightsparklabs.com
 *
 * Refer to LICENSE at repository root for license details.
 */

package com.brightsparklabs.sal4j

import groovy.json.JsonSlurper
import org.slf4j.MDC
import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Files
import java.nio.file.Paths

import static com.brightsparklabs.sal4j.AuditAction.AuditActions
import static com.brightsparklabs.sal4j.AuditResult.AuditResults

/**
 * Unit tests for {@link AuditLogger).
 *
 * @author brightSPARK Labs
 */
class AuditLoggerTest extends Specification {
    // -----------------------------------------------------------------------------
    // TESTS
    // -----------------------------------------------------------------------------

    @Unroll
    def "log unknown subject/origin"() {
        when:
        AuditLogger.log(action, result, object, message)

        then:
        def event = getLastAuditEvent()
        event.action == action.name()
        event.result == result.name()
        event.object == object
        event.message == message
        event.subject == AuditLogger.MISSING_MDC_FIELD_DEFAULT
        event.origin == AuditLogger.MISSING_MDC_FIELD_DEFAULT

        where:
        action              | result               | object    | message
        AuditActions.CREATE | AuditResults.SUCCESS | "account" | "User allowed READ access to Account #1234"
        AuditActions.CREATE | AuditResults.SUCCESS | ""        | "User allowed READ access to Account #1234"
        AuditActions.CREATE | AuditResults.SUCCESS | "account" | ""
        AuditActions.READ   | AuditResults.SUCCESS | "account" | "User allowed READ access to Account #1234"
        AuditActions.CREATE | AuditResults.FAILURE | "account" | "User allowed READ access to Account #1234"
    }

    @Unroll
    def "log known subject/origin"() {
        given:
        def action = AuditActions.UPDATE
        def result = AuditResults.FAILURE
        def object = "my object"
        def message = "my message"
        MDC.clear()
        MDC.put(AuditLogger.MDC_SUBJECT_FIELD, subject)
        MDC.put(AuditLogger.MDC_ORIGIN_FIELD, origin)

        when:
        AuditLogger.log(action, result, object, message)
        MDC.clear()

        then:
        def event = getLastAuditEvent()
        event.action == action.name()
        event.result == result.name()
        event.object == object
        event.message == message
        event.subject == subject
        event.origin == origin

        where:
        subject     | origin
        "test.user" | "test.origin"
        ""          | "test.origin"
        "test.user" | ""
        ""          | ""
    }

    @Unroll
    def "log details"() {
        given:
        def action = AuditActions.DELETE
        def result = AuditResults.SUCCESS
        def object = "my object"
        def message = "my message"

        when:
        AuditLogger.log(action, result, object, message, details)

        then:
        def event = getLastAuditEvent()
        event.details == details

        where:
        details << [
            [a: 1, b: "two", c: [three: 3]],
            [a: 1, b: "two", c: [three: null]],
            [a: 1],
            [:],
        ]
    }

    @Unroll
    def "log null cases"() {
        when:
        AuditLogger.log(action, result, object, message, details)

        then:
        thrown(NullPointerException)

        where:
        action              | result               | object      | message      | details
        null                | AuditResults.SUCCESS | "my object" | "my message" | [a: 1, b: "two", c: [three: 3]]
        AuditActions.CREATE | null                 | "my object" | "my message" | [a: 1, b: "two", c: [three: 3]]
        AuditActions.CREATE | AuditResults.SUCCESS | null        | "my message" | [a: 1, b: "two", c: [three: 3]]
        AuditActions.CREATE | AuditResults.SUCCESS | "my object" | null         | [a: 1, b: "two", c: [three: 3]]
        AuditActions.CREATE | AuditResults.SUCCESS | "my object" | "my message" | null
        AuditActions.CREATE | AuditResults.SUCCESS | "my object" | "my message" | [a: null, b: "two", c: [three: 3]]
    }

    def "log AuditEvent null"() {
        when:
        AuditLogger.log(null)

        then:
        thrown(NullPointerException)
    }


    // -----------------------------------------------------------------------------
    // FIXTURES
    // -----------------------------------------------------------------------------

    // ensure this aligns with the logback.xml configuration
    static final LOG_OUTPUT = Paths.get("/tmp/sal4j-test.log")

    def cleanupSpec() {
        deleteLogFile()
    }

    static def deleteLogFile() {
        Files.deleteIfExists(LOG_OUTPUT)
    }

    static def getLastAuditEvent() {
        def log = LOG_OUTPUT.readLines().last()
        new JsonSlurper().parseText(log).auditEvent
    }
}
