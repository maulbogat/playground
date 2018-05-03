package maulbogat.roy.example.currency

import maulbogat.roy.registry._

object Currency extends SimpleNamedRegistry
  with RegistryDefaultError {

  override type NamedVal = Currency

  val GBP = Currency("£")
  val USD = Currency("$")
  val EUR = Currency("€")

  override def error(name: String) = new IllegalArgumentException(s"invalid currency: $name")

  case class Currency(symbol: String) extends Val with ToStringNamedValue

}