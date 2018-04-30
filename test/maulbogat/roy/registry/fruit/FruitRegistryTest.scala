package maulbogat.roy.registry.fruit

import org.scalatest.{FunSpec, MustMatchers}

class FruitRegistryTest extends FunSpec with MustMatchers {

  describe("fruit registry") {
    it("get all in order") {
      Fruit.getAllValues mustBe List(Fruit.mango, Fruit.banana, Fruit.melon)
    }

    it("get by name") {
      Fruit.getByName("banana") mustBe Some(Fruit.banana)
    }
  }

}