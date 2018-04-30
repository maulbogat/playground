package maulbogat.roy.registry.currency

import org.scalatest.{FunSpec, MustMatchers}

class CurrencyRegistryTest extends FunSpec with MustMatchers {

  describe("currency registry") {

    it("get all in order") {
      Currency.getAllValues mustBe List(
        Currency.GBP,
        Currency.USD,
        Currency.EUR
      )
    }

    it("get by name") {
      Currency.getWithDefault("USD") mustBe Currency.USD
    }

  }
}