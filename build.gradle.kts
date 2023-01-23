import java.io.FileInputStream
import java.util.*

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.0"
    id("org.jetbrains.kotlin.kapt") version "1.8.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.8.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.7.0"
    id("nu.studer.jooq") version "5.2.1"
}

val jooqPropertiesFile = rootProject.file("jooq.properties")
val jooqProperties = Properties()
try {
    jooqProperties.load(FileInputStream(jooqPropertiesFile))
} catch (e: Exception) {
    println("jooq.properties not found")
}

version = "0.1"
group = "home.dj"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    //micronaut
    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")

    //api
    kapt("io.micronaut.openapi:micronaut-openapi")
    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("io.micronaut:micronaut-validation")

    //security
    kapt("io.micronaut.security:micronaut-security-annotations")
    implementation("io.micronaut.security:micronaut-security")

    //json
    implementation("io.micronaut.serde:micronaut-serde-jackson:1.5.0")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor:1.5.0")

    //logging
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")

    //database
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    runtimeOnly("org.postgresql:postgresql:42.5.1")
    implementation("io.micronaut.sql:micronaut-jooq")
    jooqGenerator("org.postgresql:postgresql:42.5.1")
}

configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("io.micronaut:micronaut-jackson-databind"))
            .using(module("io.micronaut.serde:micronaut-serde-jackson:1.5.0"))
    }
}

application {
    mainClass.set("home.dj.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}

micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("home.dj.*")
    }
}

jooq {
    version.set("3.14.11")
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(false)

            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.WARN
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://localhost:5432/landlord-db"
                    user = jooqProperties["db.user"] as? String ?: System.getenv("DB_USER")
                    password = jooqProperties["db.password"] as? String ?: System.getenv("DB_PASSWORD")
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "landlord_app"
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isImmutablePojos = true
                        isFluentSetters = true
                    }
                    target.apply {
                        packageName = "home.dj.jooq.model"
                        directory = "build/generated/src/main/kotlin"
                    }
                }
            }
        }
    }
}

sourceSets {
    val main by getting { }
    main.java.srcDir("$buildDir/generated/src/main/kotlin")
}