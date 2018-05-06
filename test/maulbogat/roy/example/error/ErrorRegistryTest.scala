package maulbogat.roy.example.error

import org.scalatest.{FunSpec, MustMatchers}

class ErrorRegistryTest extends FunSpec with MustMatchers {

  describe("event registry") {
    it("get all in order") {
      ErrorRegistry.getAllValues mustBe List(
        UserCreatedError,
        UserDeletedError,
        ProductCreatedError,
        ProductDeletedError
      )
    }

    it("get by type") {
      ErrorRegistry.getByType[UserError] mustBe List(
        UserCreatedError,
        UserDeletedError
      )
    }

    it("get by name") {
      ErrorRegistry.getWithDefault("product.created") mustBe ProductCreatedError
    }

    it("default error") {
      the[IllegalArgumentException] thrownBy ErrorRegistry.getWithDefault("does.not.exist") must have message "unknown error: does.not.exist"
    }
  }

}