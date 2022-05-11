ThisBuild / resolvers ++= Seq(
  "Apache Development Snapshot Repository".at(
    "https://repository.apache.org/content/repositories/snapshots/"
  ),
  Resolver.mavenLocal
)

name := "flink-scala"

version := "0.1-SNAPSHOT"

organization := "com.salvalcantara"

ThisBuild / scalaVersion := "2.13.8"

val flinkVersion = "1.15.0"

val flinkDependencies = Seq(
  "org.apache.flink"  % "flink-clients"        % flinkVersion % "provided",
  "org.apache.flink"  % "flink-streaming-java" % flinkVersion % "provided",
  "org.apache.flink"  % "flink-test-utils"     % flinkVersion % Test,
  "org.apache.flink"  % "flink-runtime"        % flinkVersion % Test,
  ("org.apache.flink" % "flink-streaming-java" % flinkVersion % Test).classifier("tests")
)

lazy val root = (project in file(".")).settings(
  // Flink
  libraryDependencies ++= flinkDependencies,
  // Scala
  libraryDependencies += "org.scala-lang" % "scala-reflect"  % scalaVersion.value,
  libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value
)

assembly / assemblyJarName := name.value + ".jar"

// make run command include the provided dependencies
Compile / run := Defaults
  .runTask(Compile / fullClasspath, Compile / run / mainClass, Compile / run / runner)
  .evaluated
