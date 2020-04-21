/*
 * Created by brightSPARK Labs in 2020.
 * www.brightsparklabs.com
 *
 * Refer to LICENSE at repository root for license details.
 */

package com.brightsparklabs.sal4j;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Logs audit events using a structured log format.
 *
 * @author brightSPARK Labs
 */
public class AuditLogger {
    // -------------------------------------------------------------------------
    // CONSTANTS
    // -------------------------------------------------------------------------

    /**
     * Marker which will be applied to audit logs. Default: {@code audit}. Can be overridden via
     * system property: {@code com.brightsparklabs.sal4j.markerName}.
     */
    public static final String MARKER_NAME =
            System.getProperty("com.brightsparklabs.sal4j.markerName", "audit");

    /**
     * Name of the field in the MDC (Mapped Diagnostic Context) to populate {@code subject} with.
     * Default: {@code req.username}. Can be overridden via system property: {@code
     * com.brightsparklabs.sal4j.mdcSubjectField}.
     */
    public static final String MDC_SUBJECT_FIELD =
            System.getProperty("com.brightsparklabs.sal4j.mdcSubjectField", "req.username");

    /**
     * Name of the field in the MDC (Mapped Diagnostic Context) to populate {@code origin} with.
     * Default: {@code req.remoteHost}. Can be overridden via system property: {@code
     * com.brightsparklabs.sal4j.mdcOriginField}.
     */
    public static final String MDC_ORIGIN_FIELD =
            System.getProperty("com.brightsparklabs.sal4j.mdcOriginField", "req.remoteHost");

    /**
     * Default value to use if any of the expected MDC (Mapped Diagnostic Context) fields are
     * missing. Default: {@code UNKNOWN}. Can be overridden via system property: {@code
     * com.brightsparklabs.sal4j.mdcMissingFieldDefault}.
     */
    public static final String MISSING_MDC_FIELD_DEFAULT =
            System.getProperty("com.brightsparklabs.sal4j.mdcMissingFieldDefault", "UNKNOWN");

    // -------------------------------------------------------------------------
    // CLASS VARIABLES
    // -------------------------------------------------------------------------

    /** The underlying logger all requests will be sent to. */
    private static final Logger logger = LoggerFactory.getLogger(AuditLogger.class);

    /** Marker to apply to all audit logs. */
    private static final Marker marker = MarkerFactory.getMarker(MARKER_NAME);

    // -------------------------------------------------------------------------
    // PUBLIC METHODS
    // -------------------------------------------------------------------------

    /**
     * Logs an Audit Event created from the supplied fields. The subject and origin are extracted
     * from the MDC (Mapped Diagnostic Context).
     *
     * @param action The action which was performed.
     * @param result The result of the action.
     * @param object The object the action was applied to.
     * @param message A message describing the result of the action.
     */
    public static void log(
            final AuditAction action,
            final AuditResult result,
            final String object,
            final String message) {
        log(action, result, object, message, Collections.emptyMap());
    }

    /**
     * Logs an Audit Event created from the supplied fields. The subject and origin are extracted
     * from the MDC (Mapped Diagnostic Context).
     *
     * @param action The action which was performed.
     * @param result The result of the action.
     * @param object The object the action was applied to.
     * @param message A message describing the result of the action.
     * @param details Any other details to include in the log.
     */
    public static void log(
            final AuditAction action,
            final AuditResult result,
            final String object,
            final String message,
            final Map<String, Object> details) {
        final String username =
                Optional.ofNullable(MDC.get(MDC_SUBJECT_FIELD)).orElse(MISSING_MDC_FIELD_DEFAULT);
        final String origin =
                Optional.ofNullable(MDC.get(MDC_ORIGIN_FIELD)).orElse(MISSING_MDC_FIELD_DEFAULT);
        log(action, result, username, object, message, origin, details);
    }

    /**
     * Logs an Audit Event created from the supplied fields.
     *
     * @param action The action which was performed.
     * @param result The result of the action.
     * @param subject The subject performing the action.
     * @param object The object the action was applied to.
     * @param message A message describing the result of the action.
     * @param origin The source from which the subject applied the action.
     */
    public static void log(
            final AuditAction action,
            final AuditResult result,
            final String subject,
            final String object,
            final String message,
            final String origin) {
        log(action, result, subject, object, message, origin, Collections.emptyMap());
    }

    /**
     * Logs an Audit Event created from the supplied fields.
     *
     * @param action The action which was performed.
     * @param result The result of the action.
     * @param subject The subject performing the action.
     * @param object The object the action was applied to.
     * @param message A message describing the result of the action.
     * @param origin The source from which the subject applied the action.
     * @param details Any other details to include in the log.
     */
    public static void log(
            final AuditAction action,
            final AuditResult result,
            final String subject,
            final String object,
            final String message,
            final String origin,
            final Map<String, Object> details) {
        final AuditEvent auditLog =
                ImmutableAuditEvent.builder()
                        .action(action)
                        .result(result)
                        .subject(subject)
                        .object(object)
                        .message(message)
                        .origin(origin)
                        .details(details)
                        .build();
        log(auditLog);
    }

    /**
     * Logs the supplied Audit Event.
     *
     * @param auditEvent The audit event to log.
     */
    public static void log(final AuditEvent auditEvent) {
        Objects.requireNonNull(auditEvent);
        // TODO: Shift to SLF4J native structured logs support once v2.0.0 is published
        //       https://stackoverflow.com/a/58710096/3602961
        logger.info(marker, "{}", keyValue("auditEvent", auditEvent));
    }
}
