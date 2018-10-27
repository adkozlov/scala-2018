import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "ru.hse",
      scalaVersion := "2.12.5",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "Calculator",
    libraryDependencies += scalactic,
    libraryDependencies += antlr4,
    libraryDependencies += scalaTest % Test
  )