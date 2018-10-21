name := "scala-2018"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(Antlr4Plugin)
antlr4Version in Antlr4 := "4.7.1"
antlr4PackageName in Antlr4 := Some("arithmetic")
antlr4GenVisitor in Antlr4 := true
antlr4GenListener in Antlr4 := false

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
