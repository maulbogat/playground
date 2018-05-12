package maulbogat.roy.example.fruit

import maulbogat.roy.registry.NamedInternalRegistry
import maulbogat.roy.registry.named.ToStringNamedValue

object Fruit extends NamedInternalRegistry {

  override type NamedRegistryValue = Fruit

  val mango, banana, melon = new Fruit

  class Fruit extends Val with ToStringNamedValue

}