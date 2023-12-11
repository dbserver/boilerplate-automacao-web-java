plugins {
    // Using "Banrisul mobile framework" plugin to leverage its capabilities
    id("bergs.pwx.gradle.testes.mobile")

    // Using "application" plugin to make it possible to run the "main" project piece
    id("application")
}

subprojects {
	// Applying the "Banrisul mobile framework" on subprojects also
  apply(plugin = "bergs.pwx.gradle.testes.mobile")

	dependencies {
		// Using Selenium for web browser automations
    implementation("org.seleniumhq.selenium:selenium-java:+")
	}

  // TODO: Revisar forma correta de aplicar dentro do ambiente Banrisul
  // application {
  //   // Setting up the application entry point
  //   mainClassName = "app.WebServer"
  // }

  // TODO: Revisar forma correta de aplicar dentro do ambiente Banrisul
  // tasks.withType(Test) {
  //     // Ensuring that "test" tasks utilise the required setup for JUnit 5
  //     useJUnitPlatform()

  //     // Setting up logging information for "test" tasks
  //     testLogging {
  //         exceptionFormat("full")
  //         events("started", "skipped", "passed", "failed")
  //         showStandardStreams = false
  //     }
  // }
}
