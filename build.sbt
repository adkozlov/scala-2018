name := "scala-2018"

version := "0.1"

scalaVersion := "2.12.7"

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)

libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"
libraryDependencies += "org.antlr" % "antlr4-runtime" % "4.7.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "org.mockito" % "mockito-all" % "1.9.5"
libraryDependencies += "com.typesafe.scala-logging" % "scala-logging_2.12" % "3.5.0"