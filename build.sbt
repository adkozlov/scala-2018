name := "calculator"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(Antlr4Plugin)

antlr4PackageName in Antlr4 := Some("ru.hse.spb.scala.sharkova.calculator")

antlr4GenVisitor in Antlr4 := true

libraryDependencies += "com.novocode" % "junit-interface" % "0.8" % "test->default"

cleanFiles += baseDirectory.value / "target/scala-2.12/src_managed/main"