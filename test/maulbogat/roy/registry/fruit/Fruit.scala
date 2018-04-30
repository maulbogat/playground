package maulbogat.roy.registry.fruit

import maulbogat.roy.registry.Registry.SimpleNamedRegistry
import maulbogat.roy.registry._

object Fruit extends SimpleNamedRegistry {

  override protected type NamedVal = Fruit
  val mango: Fruit = new Fruit
  val banana: Fruit = new Fruit
  val melon: Fruit = new Fruit

  protected class Fruit extends Val with ToStringNamedValue

}