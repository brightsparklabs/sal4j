/*
 * Maintained by brightSPARK Labs.
 * www.brightsparklabs.com
 *
 * Refer to LICENSE at repository root for license details.
 */

package com.brightsparklabs.sal4j;

/**
 * An action which warrants inclusion in the audit log. Default actions are available via {@link
 * AuditActions}.
 *
 * @author brightSPARK Labs
 */
public interface AuditAction {
    /** Default audit actions. */
    enum AuditActions implements AuditAction {
        // -------------------------------------------------------------------------
        // AUTH
        // -------------------------------------------------------------------------

        /** A subject logged into the system. */
        LOGIN,
        /** A subject logged out of the system. */
        LOGOOUT,

        // -------------------------------------------------------------------------
        // GENERAL
        // -------------------------------------------------------------------------

        /**
         * An action which accesses some resource (e.g. loads a web page, uses a module, etc). This
         * is generally a different use case from readings/accessing data (c.f. {@link #READ}.
         */
        ACCESS,

        // -------------------------------------------------------------------------
        // DATA
        // -------------------------------------------------------------------------

        /** An action which creates data (e.g. creates a new domain object). */
        CREATE,
        /** An action which reads data (e.g. retrieves fields from a domain object). */
        READ,
        /** An action which updates data (e.g. updates fields in a domain object). */
        UPDATE,
        /** An action which deletes data (e.g. deletes a domain object). */
        DELETE,
        /**
         * An action which searches through data (e.g. finds domain objects with fields matching
         * certain criteria).
         */
        SEARCH,
    }
}
