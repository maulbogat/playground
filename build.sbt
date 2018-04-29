name := """playground"""

organization := "maulbogat.roy"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  guice,
  jdbc,
  ws,
  "com.typesafe.play" %% "anorm" % "2.5.3",
  "org.postgresql" % "postgresql" % "9.4.1208",
  "org.bouncycastle" % "bcprov-jdk15on" % "1.51",
  "org.jooq"               % "jooq"                  % "3.10.0",
  "org.jooq"               % "jooq-scala"            % "3.9.6",
  "com.googlecode.owasp-java-html-sanitizer" % "owasp-java-html-sanitizer" % "r239",
  "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2",
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