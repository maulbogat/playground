package maulbogat.roy.registry.named

import maulbogat.roy.registry.NamedInternalRegistry
import org.scalatest.{FunSpec, MustMatchers}

class DefaultRegistryValueTest extends FunSpec with MustMatchers {

  object TestRegistry extends NamedInternalRegistry
    with DefaultRegistryValue {

    protected type NamedRegistryValue = TestRegistryValue

    class TestRegistryValue extends Val with ToStringNamedValue

    val one, two, three = new TestRegistryValue

    override protected def default: TestRegistryValue = three

  }

  describe("default registry error") {
    it("get with default") {
      TestRegistry.getWithDefault("two") mustBe TestRegistry.two
    }

    it("get default value") {
      TestRegistry.getWithDefault("four") mustBe TestRegistry.three
    }
  }

}