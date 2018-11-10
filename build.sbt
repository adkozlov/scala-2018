name := "scala-2018"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

enablePlugins(Antlr4Plugin)

antlr4PackageName in Antlr4 := Some("ru.hse.spb")
antlr4GenListener in Antlr4 := false
antlr4GenVisitor in Antlr4 := true
