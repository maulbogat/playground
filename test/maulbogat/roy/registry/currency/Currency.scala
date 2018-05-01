package maulbogat.roy.registry.currency

import maulbogat.roy.registry.Registry.SimpleNamedRegistry
import maulbogat.roy.registry._

object Currency extends SimpleNamedRegistry
  with RegistryDefaultError {

  override protected type NamedVal = Currency

  val GBP = Currency("GBP", "£")
  val USD = Currency("USD", "$")
  val EUR = Currency("EUR", "€")

  override protected def error(name: String) = new IllegalArgumentException(s"invalid currency: $name")

  protected case class Currency(name: String, symbol: String) extends Val with NamedValue

}