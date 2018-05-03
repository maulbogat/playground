package maulbogat.roy.example.fruit

import maulbogat.roy.registry.SimpleNamedRegistry
import maulbogat.roy.registry.named.ToStringNamedValue

object Fruit extends SimpleNamedRegistry {

  override protected type NamedRegistryValue = Fruit

  val mango, banana, melon = new Fruit

  class Fruit extends Val with ToStringNamedValue

}