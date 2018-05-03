package maulbogat.roy.example.currency

import maulbogat.roy.registry._
import maulbogat.roy.registry.named.{RegistryDefaultError, ToStringNamedValue}

object Currency extends SimpleNamedRegistry
  with RegistryDefaultError {

  override protected type NamedRegistryValue = Currency

  val GBP = Currency("£")
  val USD = Currency("$")
  val EUR = Currency("€")

  override def error(name: String) = new IllegalArgumentException(s"invalid currency: $name")

  case class Currency(symbol: String) extends Val with ToStringNamedValue

}