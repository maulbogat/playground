package maulbogat.roy.registry.named

import maulbogat.roy.registry.Registry
import play.api.libs.json._

import scala.util.{Failure, Success, Try}

trait RegistryJson {
  _: Registry with NamedRegistry with RegistryDefault =>

  final val namedReads: Reads[V] = {
    case JsString(s) => Try(getWithDefault(s)) match {
      case Success(value) => JsSuccess(value)
      case Failure(exception) => JsError(JsonValidationError(exception.getMessage, s))
    }
    case _ => JsError("invalid json value")
  }

  // TODO final val namedFormat: Format[V] = Format.apply(namedReads, RegistryJsonWrites.namedWrites[V])

}

object RegistryJsonWrites {

  final def namedWrites[T <: NamedValue]: Writes[T] = (o: T) => JsString(o.name)

}