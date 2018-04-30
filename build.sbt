name := """registry"""

organization := "maulbogat.roy"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  guice,
  jdbc,
  ws,
  "org.mockito" % "mockito-core" % "2.13.0" % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
)

scalacOptions in Compile ++= Seq(
  "-Xfatal-warnings",
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-unchecked",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard",
  "-Xfuture"
)