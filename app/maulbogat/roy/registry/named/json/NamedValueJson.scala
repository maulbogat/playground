package maulbogat.roy.registry.named.json

import maulbogat.roy.registry.named.NamedValue
import play.api.libs.json.{JsString, Writes}

object NamedValueJson {

  def writes: Writes[NamedValue] = (o: NamedValue) => JsString(o.name)

}