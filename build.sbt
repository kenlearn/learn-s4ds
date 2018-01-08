
lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "me.kenqcl",
      scalaVersion := "2.12.4",
      version      := "0.1.0"
    )),
    name := "Hello",
    libraryDependencies = Seq(
      "org.scalatest" %% "scalatest" % "3.0.4"
      "org.scalanlp" %% "breeze" % "0.13.2",
      "org.scalanlp" %% "breeze-natives" % "0.13.2"
    )
  )
