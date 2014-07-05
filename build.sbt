//sbtPlugin := true

organization := "com.github.jasonqu"

name := "try-twirl"

version := "0.1.1"

scalaVersion := "2.10.4"

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

//libraryDependencies ++= Seq(
  //"com.github.scala-incubator.io" %% "scala-io-file" % "0.4.2",
  //"org.scala-lang" % "scala-compiler" % "2.10.3",
  // pegdown
  //"org.pegdown" % "pegdown" % "1.4.2"
//)

resolvers += "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/"

site.settings