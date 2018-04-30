package maulbogat.roy.currency

import maulbogat.roy._

object Currencies extends Enumeration
  with EnumRegistry
  with DefaultError
  with NamedRegistry
  with Identity {

  override protected type V = Currency
  val GBP = Currency("GBP", "£")
  val USD = Currency("USD", "$")
  val EUR = Currency("EUR", "€")

  override protected def error(name: String) = new IllegalArgumentException(s"invalid currency: $name")

  protected case class Currency(name: String, symbol: String) extends Val with NamedValue

}