buildscript {
    repositories.maven("https://repobins.apps.prod.banrisul.com.br/repository/maven-public/")
    dependencies.classpath("bergs.pwx.build.plugins:mmd-gradle-plugin:${extra["mm.plugin.version"]}")
}
apply(plugin = "bergs.pwx.gradle.settings")

includeFlat(
	"Capuaajm_TestesWebAutomatizados"
)
