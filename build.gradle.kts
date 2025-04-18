plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

val cxf by configurations.creating

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.liquibase:liquibase-core")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.3")
    implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
    implementation("jakarta.jws:jakarta.jws-api:3.0.0")
    implementation("org.apache.cxf:cxf-spring-boot-starter-jaxws:4.0.2")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.apache.cxf:cxf-rt-frontend-jaxws:4.1.1")
    implementation("org.apache.cxf:cxf-rt-transports-http:4.1.1")

    // CXF tools for WSDL generation
    cxf("org.apache.cxf:cxf-tools-wsdlto-core:4.1.1")
    cxf("org.apache.cxf:cxf-tools-wsdlto-frontend-jaxws:4.1.1")
    cxf("org.apache.cxf:cxf-tools-wsdlto-databinding-jaxb:4.1.1")
    cxf("org.apache.cxf:cxf-tools-common:4.1.1")
    cxf("org.apache.cxf:cxf-rt-transports-http:4.1.1") // Add this for HTTP transport

    // SLF4J implementation to avoid warnings
    cxf("org.slf4j:slf4j-simple:2.0.9")

    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

//tasks.register<JavaExec>("generateWsdlClient") {
//    group = "build"
//    description = "Generates Java client code from WSDL"
//    classpath = cxf
//
//    mainClass.set("org.apache.cxf.tools.wsdlto.WSDLToJava")
//
//    // Use either the URL (if service is running) or local file
//    args(
//        "-client", // Generate client code
//        "-verbose", // Show more details
//        "-p", "com.example.client",
//        "-d", "$buildDir/generated-sources/cxf",
//        "http://localhost:8080/soap-api/student-service?wsdl" // OR "path/to/local/student-service.wsdl"
//    )
//
//    doFirst {
//        mkdir("$buildDir/generated-sources/cxf")
//        // Verify the WSDL is accessible
//        println("Attempting to access WSDL at: http://localhost:8080/soap-api/student-service?wsdl")
//    }
//}

//sourceSets.main {
//    java.srcDirs("$buildDir/generated-sources/cxf")
//}

//tasks.named("compileJava") {
//    dependsOn("generateWsdlClient")
//}

tasks.withType<Test> {
    useJUnitPlatform()
}