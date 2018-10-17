name := "scala-2018"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(Antlr4Plugin)
antlr4Version in Antlr4 := "4.7.1"
antlr4PackageName in Antlr4 := Some("calculator")
antlr4GenVisitor in Antlr4 := true
