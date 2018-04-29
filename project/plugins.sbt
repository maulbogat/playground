import sbt.Resolver

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.7")

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC13")

resolvers += Resolver.typesafeRepo("releases")