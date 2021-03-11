lazy val mainRunner = project.in(file("mainRunner")).dependsOn(RootProject(file("."))).settings(
  libraryDependencies := (libraryDependencies in RootProject(file("."))).value.map{
    module => module.configurations match {
      case Some("provided") => module.withConfigurations(None)
      case _ => module
    }
  }
)
