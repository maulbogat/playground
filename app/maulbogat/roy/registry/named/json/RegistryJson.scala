package maulbogat.roy.registry.named.json

import maulbogat.roy.registry.Registry
import maulbogat.roy.registry.named.{NamedRegistry, RegistryDefault}
import play.api.libs.json._

import scala.util.{Failure, Success, Try}

trait RegistryJson {
  _: Registry with NamedRegistry with RegistryDefault =>

  private def getNamedReads[V](getValue: String => V): Reads[V] = {
    case JsString(s) => Try(getValue(s)) match {
      case Success(value) => JsSuccess(value)
      case Failure(exception) => JsError(JsonValidationError(exception.getMessage, s))
    }
    case _ => JsError("invalid json value")
  }

  final val namedReads: Reads[V] = getNamedReads(getWithDefault)

  final val namedReadsIgnoreCase: Reads[V] = getNamedReads(getWithDefaultIgnoreCase)

  final val namedFormat: Format[V] = Format.apply(namedReads, NamedValueJson.writes)

  final val namedFormatIgnoreCase: Reads[V] = Format.apply(namedReadsIgnoreCase, NamedValueJson.writes)

}