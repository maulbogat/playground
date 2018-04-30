package maulbogat.roy.registry.element

import org.scalatest.{FunSpec, MustMatchers}

class ElementServiceRegistryTest extends FunSpec with MustMatchers {

  private val earthService = new EarthService

  private val windService = new WindService

  private val fireService = new FireService

  private val registry = new ElementServiceRegistry(earthService, windService, fireService)

  describe("element service registry") {

    it("get all services in order") {
      registry.getAllValues mustBe List(earthService, windService, fireService)
    }

  }

}