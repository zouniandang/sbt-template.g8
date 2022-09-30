import sbt._

object Dependencies {
  lazy val version = new {
    val scalaTest = "3.2.13"
    val scalaCheck = "1.17.0"
  }

  lazy val library = new {
    val test  = "org.scalatest" %% "scalatest" % version.scalaTest % Test
    val check = "org.scalacheck" %% "scalacheck" % version.scalaCheck % Test
  }

  val $module1;format="camel"$Dependencies: Seq[ModuleID] = Seq(
    library.test,
    library.check
  )

  val $module2;format="camel"$Dependencies: Seq[ModuleID] = Seq(
    library.test,
    library.check
  )

  val $appname;format="camel"$Dependencies: Seq[ModuleID] = Seq(
    library.test,
    library.check
  )
}