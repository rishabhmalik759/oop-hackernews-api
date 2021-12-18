name := "HackerNewsClient"
organization := "com.hackernews.client"
version := "1.0"

scalaVersion := "2.13.7"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test"
libraryDependencies += "org.mockito" % "mockito-scala_2.13" % "1.6.2" % "test"

// JSON parsing library
//libraryDependencies += "com.lihaoyi" %% "upickle" % "1.3.8" // This has a bug
libraryDependencies += "com.lihaoyi" %% "upickle" % "1.4.2"

assemblyJarName in assembly := "HackerNewsClient.jar"
