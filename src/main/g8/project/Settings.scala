import sbt._
import Keys._
import sbtassembly.AssemblyPlugin.autoImport._

object Settings {
  lazy val settings = Seq(
    organization := "$organization$",
    version := "$version$" + sys.props.getOrElse("buildNumber", default="-SNAPSHOT"),
    scalaVersion := "$scala_version$",
    publishMavenStyle := true,
    publishArtifact in Test := false
  )

  lazy val testSettings = Seq(
    fork in Test := false,
    parallelExecution in Test := false
  )

  lazy val itSettings = Defaults.itSettings ++ Seq(
    logBuffered in IntegrationTest := false,
    fork in IntegrationTest := true
  )

  lazy val assemblySettings = Seq(
    test in assembly := {},
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(
      includeScala = false,
      includeDependency = true
    ),
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs @_*) => MergeStrategy.discard
      case "application.conf" => MergeStrategy.concat
      case x if x.startsWith("reference.conf") => MergeStrategy.concat
      case _ => MergeStrategy.first
    }
  )

  lazy val $appname;format="camel"$Settings = Seq(
    assemblyJarName in assembly := s"$appname;format="hyphenate"$-\${version.value}.jar",
    target in assembly := file(baseDirectory.value + "/../target/"),
    mainClass in assembly := Some("$package$.$appname;format="word"$.$appname;format="Camel"$")
  )

  lazy val $module1;format="camel"$Settings = Seq(
    assemblyJarName in assembly := s"$module1;format="hyphenate"$-\${version.value}.jar"
  )

  lazy val $module2;format="camel"$Settings = Seq(
    assemblyJarName in assembly := s"$module2;format="hyphenate"$-\${version.value}.jar"
  )
}