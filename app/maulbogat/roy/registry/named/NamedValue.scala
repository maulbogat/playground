package maulbogat.roy.registry.named

import play.api.libs.json.{JsString, Writes}

trait NamedValue {

  def name: String

}

object NamedValue {

  def writes: Writes[NamedValue] = (o: NamedValue) => JsString(o.name)

}

trait ToStringNamedValue extends NamedValue {

  override lazy val name: String = toString

}

trait ToLowerStringNamedValue extends NamedValue {

  override lazy val name: String = toString.toLowerCase

}