package maulbogat.roy.registry.named

import maulbogat.roy.registry.NamedInternalRegistry
import org.scalatest.{FunSpec, MustMatchers}

class DefaultRegistryErrorTest extends FunSpec with MustMatchers {

  object TestRegistry extends NamedInternalRegistry
    with DefaultRegistryError {

    protected type NamedRegistryValue = TestRegistryValue

    class TestRegistryValue extends Val with ToStringNamedValue

    val one, two, three = new TestRegistryValue

    override protected def error(name: String): Throwable = new IllegalArgumentException(s"no such value: $name")

  }

  describe("default registry error") {
    it("get with default") {
      TestRegistry.getWithDefault("two") mustBe TestRegistry.two
    }

    it("get error") {
      the[IllegalArgumentException] thrownBy TestRegistry.getWithDefault("four") must have message "no such value: four"
    }
  }

}