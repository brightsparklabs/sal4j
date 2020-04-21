# Simple Audit Logging for Java (SAL4J)

[ ![Download](https://api.bintray.com/packages/brightsparklabs/maven/sal4j/images/download.svg) ](https://bintray.com/brightsparklabs/maven/sal4j/_latestVersion)

A simple Audit Logging framework for Java which can produce structured logs in JSON format.

# Usage

## Include Library

E.g. via `gradle`:

    # build.gradle
    repositories {
        jcenter()
        // ALTERNATIVELY: directly use the BSL repo on bintray
        maven { url "https://dl.bintray.com/brightsparklabs/maven" }
    }

    dependencies {
        implementation "com.brightsparklabs:sal4j:$version"
        
        // to log in json format
        implementation 'net.logstash.logback:logstash-logback-encoder:6.3'
        runtimeOnly 'ch.qos.logback:logback-classic:1.2.3'
    }

## Configure Logging

Logging is routed through SLF4J. Configure the underlying logging implementation as appropriate.

Example: Logback

    <!-- logback.xml -->
    <configuration>
        <appender name="jsonConsoleAppender" class="ch.qos.logback.core.ConsoleAppender">
            <encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
        </appender>
        <appender name="jsonFileAppender" class="ch.qos.logback.core.FileAppender">
            <encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
            <file>/tmp/sal4j-test.log</file>
        </appender>
        <root level="INFO">
            <appender-ref ref="jsonConsoleAppender"/>
            <appender-ref ref="jsonFileAppender"/>
        </root>
    </configuration>

Filtering can be applied via:

- Logger Name: `com.brightsparklabs.sal4j.AuditLogger`
- Marker: `audit`

The name of the marker can be overridden using a system property:

    java -Dcom.brightsparklabs.sal4j.markerName=AUDIT_LOG

## Log Audit Events via `AuditEvent`

Example: User tried to login and was denied

    AuditLogger.log(
        ImmutableAuditEvent.builder()
            .action(AuditActions.LOGIN)
            .result(AuditResults.FAILURE)
            .subject("some.user")
            .object("My Application")
            .message("Invalid credentials supplied.")
            .origin("192.168.1.200")
            .details(ImmutableMap.of("notice", "Failed logins are logged"))
            .build();
        );
    );

Result:

    {
      "@timestamp": "2020-04-21T17:32:02.650+12:00",
      "@version": "1",
      "message": "auditEvent=AuditEvent{action=LOGIN, result=FAILURE, subject=some.user, object=My Application, message=Invalid credentials supplied, origin=192.168.1.200, details={notice=Failed logins are logged}}",
      "logger_name": "com.brightsparklabs.sal4j.AuditLogger",
      "thread_name": "main",
      "level": "INFO",
      "level_value": 20000,
      "tags": [
        "audit"
      ],
      "auditEvent": {
        "action": "LOGIN",
        "result": "FAILURE",
        "subject": "test.user",
        "object": "My Application",
        "message": "Invalid credentials supplied",
        "origin": "192.168.1.200",
        "details": {
          "notice": "Failed logins are logged"
        }
      }
    }

## Log Audit Events via parameters

Example: User tried to create an item and was denied

    AuditLogger.log(
        AuditActions.CREATE,
        AuditResults.FAILURE,
        "some.user",
        "My Application",
        "Invalid credentials supplied.",
        "WORKSTATION-01"
    );
    
## Log Audit Events via MDC fields

Example: User tried to read an item (e.g. `Movie`) and was successful

    AuditLogger.log(
        AuditActions.READ,
        AuditResults.SUCCESS,
        movie.getUuid(),
        String.format("Reading movie details for [%s]", movie.getTitle)
    );

The subject will be retrieved from the MDC (Mapped Diagnostic Context). The default name for the
MDC key is `req.username`. This can be overridden using a system property:

    java -Dcom.brightsparklabs.sal4j.mdcSubjectField=userId

The origin will be retrieved from the MDC (Mapped Diagnostic Context). The default name for the
MDC key is `req.remoteHost`. This can be overridden using a system property:

    java -Dcom.brightsparklabs.sal4j.mdcOriginField=location

If either of the above keys do not exist in the MDC, then it will default to "UNKNOWN". This can
 be overridden using a system property:

    java -Dcom.brightsparklabs.sal4j.mdcMissingFieldDefault=missing

## Extending

### Actions
Custom audit actions can be added by implementing `AuditAction`. For simplicity, use an `enum`:

    public enum CustomAuditActions implements AuditAction {
        DESTROY,
        RECREATE,
    }
    
    AuditLogger.log(CustomAuditActions.DESTROY, ...);

### Results

Custom audit results can be added by implementing `AuditResult`. For simplicity, use an `enum`
(see above).

# Development

- Publish new versions via:

        export BINTRAY_USER=<user>
        export BINTRAY_KEY=<key>
        ./gradlew bintrayUpload

# Licenses

Refer to the `LICENSE` file for details.
