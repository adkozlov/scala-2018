name := "scala-2018"

version := "0.1"

scalaVersion := "2.12.7"

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
