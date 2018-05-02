package maulbogat.roy.registry

import play.api.libs.json._

import scala.util.{Failure, Success, Try}

trait RegistryJson {
  _: NamedRegistry with RegistryDefault =>

  final val namedReads: Reads[NamedVal] = {
    case JsString(s) => Try(getWithDefault(s)) match {
      case Success(value) => JsSuccess(value)
      case Failure(exception) => JsError(JsonValidationError(exception.getMessage, s))
    }
    case _ => JsError("invalid json value")
  }

  final val namedFormat: Format[NamedVal] = Format.apply(namedReads, RegistryJsonWrites.namedWrites[V])

}

object RegistryJsonWrites {

  final def namedWrites[T <: NamedValue]: Writes[T] = (o: T) => JsString(o.name)

}