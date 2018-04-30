package maulbogat.roy.registry.action

import org.scalatest.{FunSpec, MustMatchers}

class ActionRegistryTest extends FunSpec with MustMatchers {

  describe("action registry") {
    it("get all in order") {
      ActionRegistry.getAllValues mustBe List(Eat, Pray, Love)
    }

    it("get by name") {
      ActionRegistry.getByName("pray") mustBe Some(Pray)
    }
  }

}