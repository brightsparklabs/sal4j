/*
 * Maintained by brightSPARK Labs.
 * www.brightsparklabs.com
 *
 * Refer to LICENSE at repository root for license details.
 */

package com.brightsparklabs.sal4j;

/**
 * The result from performing an {@link AuditAction auditable action}. Default results are available
 * via {@link AuditResults}.
 *
 * @author brightSPARK Labs
 */
public interface AuditResult {
    /** Standard results. */
    enum AuditResults implements AuditResult {
        /** The action was a success (e.g. granted, allowed, etc). */
        SUCCESS,
        /** The action was a failure (e.g. denied, disallowed, etc). */
        FAILURE,
    }
}
