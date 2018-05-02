package maulbogat.roy.registry.fruit

import maulbogat.roy.registry.{NamedRegistry, SimpleRegistry, ToStringNamedValue}

object Fruit extends SimpleRegistry with NamedRegistry {

  override type NamedVal = Fruit
  val mango: Fruit = new Fruit
  val banana: Fruit = new Fruit
  val melon: Fruit = new Fruit

  class Fruit extends Val with ToStringNamedValue

}