organization := "com.github.jasonqu"

name := "you-could-use-scala"

version := "0.1.1"

scalaVersion := "2.10.4"

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

resolvers += "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/"

site.settings