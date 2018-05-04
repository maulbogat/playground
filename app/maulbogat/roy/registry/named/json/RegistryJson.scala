package maulbogat.roy.registry.named.json

import maulbogat.roy.registry.Registry
import maulbogat.roy.registry.named.{NamedRegistry, RegistryDefault}
import play.api.libs.json._

import scala.util.{Failure, Success, Try}

trait RegistryJsonRead {
  _: Registry /* with NamedRegistry */ with RegistryDefault =>

  final val namedReads: Reads[V] = {
    case JsString(s) => Try(getWithDefault(s)) match {
      case Success(value) => JsSuccess(value)
      case Failure(exception) => JsError(JsonValidationError(exception.getMessage, s))
    }
    case _ => JsError("invalid json value")
  }

}

trait RegistryJsonFormat extends RegistryJsonRead {
  _: Registry with NamedRegistry with RegistryDefault =>

  final val namedFormat: Format[V] = Format.apply(namedReads, NamedValueJson.writes)

}