package maulbogat.roy.registry.currency

import maulbogat.roy.registry._

object Currency extends Enumeration
  with EnumRegistry
  with NamedRegistryDefaultError
  with NamedRegistry
  with IdentityRegistry {

  override protected type V = Currency
  val GBP = Currency("GBP", "£")
  val USD = Currency("USD", "$")
  val EUR = Currency("EUR", "€")

  override protected def error(name: String) = new IllegalArgumentException(s"invalid currency: $name")

  protected case class Currency(name: String, symbol: String) extends Val with NamedValue

}