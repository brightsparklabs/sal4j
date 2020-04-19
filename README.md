# Simple Audit Logging for Java (SAL4J)

[ ![Download](https://api.bintray.com/packages/brightsparklabs/maven/sal4j/images/download.svg) ](https://bintray.com/brightsparklabs/maven/sal4j/_latestVersion)

A simple framework for Java.

# Usage

- Include library. E.g. via `gradle`:

        # build.gradle
        repositories {
            jcenter()
            // ALTERNATIVELY: directly use the BSL repo on bintray
            maven { url "https://dl.bintray.com/brightsparklabs/maven" }
        }

        dependencies {
            implementation "com.brightsparklabs:sal4j:$version"
        }

- TBD

# Development

- Publish new versions via:

        export BINTRAY_USER=<user>
        export BINTRAY_KEY=<key>
        ./gradlew bintrayUpload

# Licenses

Refer to the `LICENSE` file for details.
