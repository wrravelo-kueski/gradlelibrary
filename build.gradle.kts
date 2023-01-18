plugins {
    id 'java-library'
    // Enables publishing artifacts during build
    id 'maven-publish'
}

sourceCompatibility = JavaVersion.VERSION_17

group 'com.registry_example'
version '1.0.0'

repositories {
    mavenCentral()
}

// Configures the publishing
publishing {
    repositories {
        // The target repository
        maven {
            // Choose whatever name you want
            name = "GitHubPackages"
            // The url of the repository, where the artifacts will be published
            url = "https://maven.pkg.github.com/wrravelo-kueski/gradlelibrary"
            credentials {
                // The credentials (described in the next section)
                username = project.findProperty("gpr.user")
                password = project.findProperty("gpr.key")
            }
        }
    }
    publications {
        gpr(MavenPublication) {
            from(components.java)
        }
    }
}