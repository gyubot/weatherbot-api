import org.springframework.boot.gradle.tasks.bundling.BootJar

project(":weatherbot:api") {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    tasks.getByName<BootJar>("bootJar") {
        enabled = true
        destinationDirectory.set(project.file("${project.rootDir}/build/libs"))
        this.archiveFileName.set("weatherbot-${archiveBaseName.get()}.${archiveExtension.get()}")
    }

    tasks.getByName<Jar>("jar") {
        enabled = false
    }

    dependencies {
        implementation(project(":weatherbot:domain-model"))
        implementation(project(":weatherbot:data-access"))
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("javax.validation:validation-api:2.0.0.Final")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}
