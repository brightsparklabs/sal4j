/*
 * Maintained by brightSPARK Labs.
 * www.brightsparklabs.com
 *
 * Refer to LICENSE at repository root for license details.
 */

package com.brightsparklabs.sal4j;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;
import org.immutables.value.Value;

/**
 * The details to include in an audit event.
 *
 * @author brightSPARK Labs
 */
@Value.Immutable
@JsonDeserialize(builder = ImmutableAuditEvent.Builder.class)
interface AuditEvent {
    /**
     * Returns The action which was performed.
     *
     * @return The action which was performed.
     */
    AuditAction getAction();

    /**
     * Returns The result of the action.
     *
     * @return The result of the action.
     */
    AuditResult getResult();

    /**
     * Returns The subject performing the action.
     *
     * @return The subject performing the action.
     */
    String getSubject();

    /**
     * Returns The object the action was applied to.
     *
     * @return The object the action was applied to.
     */
    String getObject();

    /**
     * Returns A message describing the result of the action.
     *
     * @return A message describing the result of the action.
     */
    String getMessage();

    /**
     * Returns The source from which the subject applied the action.
     *
     * @return The source from which the subject applied the action.
     */
    String getOrigin();

    /**
     * Returns Any other details to include in the log.
     *
     * @return Any other details to include in the log.
     */
    Map<String, Object> getDetails();
}
