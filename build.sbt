name := "scala-2018"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(Antlr4Plugin)

antlr4GenListener in Antlr4 := true

antlr4GenVisitor in Antlr4 := true

antlr4Dependency in Antlr4 := "org.antlr" % "antlr4" % "4.7.1"

antlr4PackageName in Antlr4 := Some("ru.hse.spb")

libraryDependencies += "junit" % "junit" % "4.10" % Test
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test
