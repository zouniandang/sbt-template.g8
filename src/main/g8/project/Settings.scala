import sbt._
import Keys._
import sbtassembly.AssemblyPlugin.autoImport._

object Settings {
  lazy val settings = Seq(
    organization := "$organization$",
    version := "$version$" + sys.props.getOrElse("buildNumber", default="-SNAPSHOT"),
    scalaVersion := "$scala_version$",
    publishMavenStyle := true,
    Test / publishArtifact := false
  )

  lazy val testSettings = Seq(
    Test / fork := false,
    Test / parallelExecution := false
  )

  lazy val assemblySettings = Seq(
    assembly / test := {},
    assembly / assemblyOption ~= {
      _.withIncludeScala(false)
        .withIncludeDependency(true)
    },
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", _ @_*) => MergeStrategy.discard
      case "application.conf" => MergeStrategy.concat
      case x if x.startsWith("reference.conf") => MergeStrategy.concat
      case x =>
        val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
        oldStrategy(x)
    }
  )

  lazy val $appname;format="camel"$Settings = Seq(
    assembly / assemblyJarName := s"$appname;format="hyphenate"$-\${version.value}.jar",
    assembly / target := file(baseDirectory.value + "/../target/"),
    assembly / mainClass := Some("$package$.$appname;format="word"$.$appname;format="Camel"$")
  )

  lazy val $module1;format="camel"$Settings = Seq(
    assembly / assemblyJarName := s"$module1;format="hyphenate"$-\${version.value}.jar"
  )

  lazy val $module2;format="camel"$Settings = Seq(
    assembly / assemblyJarName := s"$module2;format="hyphenate"$-\${version.value}.jar"
  )
}
