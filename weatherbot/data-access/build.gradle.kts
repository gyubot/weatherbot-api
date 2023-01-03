val exposedVersion = "0.37.3"
val hikariCpVersion = "5.0.0"

project(":weatherbot:data-access") {
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    dependencies {
        implementation(project(":weatherbot:domain-model"))
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.+")
    }
}
