package maulbogat.roy.example.singers

import maulbogat.roy.registry.ExternalRegistry

object Singer extends ExternalRegistry[String] {

  val ArethaFranklin: String = registerAndGet("Aretha Franklin")
  val BobDylan: String = registerAndGet("Bob Dylan")
  val ChuckBerry: String = registerAndGet("Chuck Berry")

}