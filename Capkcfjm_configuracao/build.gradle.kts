plugins {
    id("bergs.pwx.gradle.testes.mobile")
}

subprojects {
	apply(plugin = "bergs.pwx.gradle.testes.mobile")
	dependencies {
		implementation("org.seleniumhq.selenium:selenium-java:+")
	}
}
