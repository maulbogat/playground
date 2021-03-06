package maulbogat.roy.example.event

import org.scalatest.{FunSpec, MustMatchers}

class EventRegistryTest extends FunSpec with MustMatchers {

  describe("event registry") {
    it("get all in order") {
      EventRegistry.getAllValues mustBe List(
        UserCreatedEvent,
        UserDeletedEvent,
        ProductCreatedEvent,
        ProductDeletedEvent
      )
    }

    it("get by type") {
      EventRegistry.getByType[UserEvent] mustBe List(
        UserCreatedEvent,
        UserDeletedEvent
      )
    }

    it("get by name") {
      EventRegistry.getWithDefault("product.created") mustBe ProductCreatedEvent
    }

    it("default error") {
      the[IllegalArgumentException] thrownBy EventRegistry.getWithDefault("does.not.exist") must have message "unknown event: does.not.exist"
    }
  }

}