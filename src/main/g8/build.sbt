import Dependencies._

ThisBuild / resolvers ++= Seq(
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Apache Development Snapshot Repository" at "https://repository.apache.org/content/repositories/snapshots/",
  Resolver.mavenLocal
)

lazy val $module1;format="camel"$ = (project in file("$module1;format="hyphenate"$"))
  .settings(Settings.settings: _*)
  .settings(Settings.assemblySettings: _*)
  .settings(Settings.$module1;format="camel"$Settings: _*)
  .settings(libraryDependencies ++= $module1;format="camel"$Dependencies)

lazy val $module2;format="camel"$ = (project in file("$module2;format="hyphenate"$"))
  .settings(Settings.settings: _*)
  .settings(Settings.assemblySettings: _*)
  .settings(Settings.$module2;format="camel"$Settings: _*)
  .settings(libraryDependencies ++= $module2;format="camel"$Dependencies)

lazy val $appname;format="camel"$ = (project in file("$appname;format="hyphenate"$"))
  .settings(Settings.settings: _*)
  .settings(Settings.assemblySettings: _*)
  .settings(Settings.$appname;format="camel"$Settings: _*)
  .settings(libraryDependencies ++= $appname;format="camel"$Dependencies)
  .dependsOn($module1;format="camel"$, $module2;format="camel"$)
  .configs(IntegrationTest)
  .configs(Test)