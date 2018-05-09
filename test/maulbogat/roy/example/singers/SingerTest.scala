package maulbogat.roy.example.singers

import org.scalatest.{FunSpec, MustMatchers}

class SingerTest extends FunSpec with MustMatchers {

  describe("signer registry") {

    it("get all in order") {
      Singer.getAllValues mustBe List(
        Singer.ArethaFranklin,
        Singer.BobDylan,
        Singer.ChuckBerry
      )
    }

    it("get specific") {
      Singer.BobDylan mustBe "Bob Dylan"
    }

  }
}