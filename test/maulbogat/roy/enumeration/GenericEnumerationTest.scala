package maulbogat.roy.enumeration

import maulbogat.roy.TestBase

class GenericEnumerationTest extends TestBase {

  describe("typed enumeration") {

    // when you need a list of an existing class

    it("register one by one and get all") {
      object Fruits extends GenericEnumeration[Fruit] {

        val mango: Fruit = register {
          Fruit("mango")
        }

        val banana: Fruit = register {
          Fruit("banana")
        }

        val melon: Fruit = register {
          Fruit("melon")
        }
      }

      val fruits: List[Fruit] = Fruits.getAll
      fruits mustBe List(Fruits.mango, Fruits.banana, Fruits.melon)
    }

    // when you don't need the specific class values

    it("register all and get all") {
      object Fruits extends GenericEnumeration[Fruit] {
        registerAll(
          Fruit("mango"),
          Fruit("banana"),
          Fruit("melon")
        )
      }

      val fruits: List[Fruit] = Fruits.getAll
      fruits.map(_.name) mustBe List("mango", "banana", "melon")
    }

  }

}

case class Fruit(name: String)