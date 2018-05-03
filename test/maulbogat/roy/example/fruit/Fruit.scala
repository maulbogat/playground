package maulbogat.roy.example.fruit

import maulbogat.roy.registry.{SimpleNamedRegistry, ToStringNamedValue}

object Fruit extends SimpleNamedRegistry {

  override type NamedVal = Fruit
  val mango: Fruit = new Fruit
  val banana: Fruit = new Fruit
  val melon: Fruit = new Fruit

  class Fruit extends Val with ToStringNamedValue

}