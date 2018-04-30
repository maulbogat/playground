package maulbogat.roy.registry.fruit

import maulbogat.roy.registry._

object Fruit extends Enumeration
  with EnumRegistry
  with NamedRegistry
  with IdentityRegistry {

  override protected type V = Fruit

  protected class Fruit extends Val with ToStringNamedValue

  val mango: Fruit = new Fruit

  val banana: Fruit = new Fruit

  val melon: Fruit = new Fruit

}