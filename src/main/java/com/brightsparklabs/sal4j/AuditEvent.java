/*
 * Created by brightSPARK Labs in 2020.
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
    /** @return The action which was performed. */
    AuditAction getAction();

    /** @return The result of the action. */
    AuditResult getResult();

    /** @return The subject performing the action. */
    String getSubject();

    /** @return The object the action was applied to. */
    String getObject();

    /** @return A message describing the result of the action. */
    String getMessage();

    /** @return The source from which the subject applied the action. */
    String getOrigin();

    /** @return Any other details to include in the log. */
    Map<String, Object> getDetails();
}
