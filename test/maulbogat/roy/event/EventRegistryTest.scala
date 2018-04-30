package maulbogat.roy.event

import maulbogat.roy.TestBase

class EventRegistryTest extends TestBase {

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
      EventRegistry.getWittDefault("product.created") mustBe ProductCreatedEvent
    }

    it("default error") {
      the[IllegalAccessException] thrownBy EventRegistry.getWittDefault("does.not.exist") must have message "unknown event: does.not.exist"
    }
  }

}