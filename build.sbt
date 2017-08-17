import sbt._

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += Resolver.sonatypeRepo("releases")

val scalaV = "2.11.8"
val scalaReflectDeps = Seq(
  "org.scala-lang" % "scala-reflect" % scalaV
)

val commonSettings = Seq(
  scalaVersion := scalaV,
  scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-Xfatal-warnings", "-encoding", "utf8")
)

val specs2V = "3.8.8"
lazy val specs2Deps = Seq(
  "org.specs2"     %% "specs2-core"       % specs2V  % "test",
  "org.specs2"     %% "specs2-form"       % specs2V  % "test",
  "org.specs2"     %% "specs2-scalacheck" % specs2V  % "test",
  "org.scalacheck" %% "scalacheck"        % "1.12.4" % "test"
)

val scalaTestV = "3.0.1"
lazy val scalaTestDeps = Seq(
  "org.scalactic" %% "scalactic" % scalaTestV,
  "org.scalatest" %% "scalatest" % scalaTestV % "test"
)

val scalaXmlV = "1.0.6"
lazy val scalaXmlDep = "org.scala-lang.modules" %% "scala-xml" % scalaXmlV

val scalaParserV = "1.0.6"
lazy val scalaParserDep = "org.scala-lang.modules" %% "scala-parser-combinators" % scalaParserV

lazy val scalaxbTest = (project in file("./scala-xb-test"))
  .enablePlugins(ScalaxbPlugin)
  .settings(commonSettings: _*)
  .settings(
    name := "scala-xb-test",
    libraryDependencies ++= Seq(scalaXmlDep, scalaParserDep),
    scalaxbGenerateDispatchClient := false,
    scalaxbPackageName in (Compile, scalaxb)     := "com.iabtechlab"
  )

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "scala-xml-test",
    organization := "com.example"
  )
  .aggregate(
    scalaxbTest
  )
