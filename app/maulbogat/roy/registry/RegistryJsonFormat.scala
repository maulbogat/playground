package maulbogat.roy.registry

import play.api.libs.json._

import scala.util.{Failure, Success, Try}

trait RegistryJsonFormat extends RegistryJsonReads {
  _: NamedRegistry with NamedRegistryDefault =>

  val namedFormat: Format[V] = Format.apply(namedReads, RegistryJsonWrites.namedWrites[V])

}

trait RegistryJsonReads {
  _: NamedRegistry with NamedRegistryDefault =>

  val namedReads: Reads[V] = {
    case JsString(s) => Try(getWithDefault(s)) match {
      case Success(value) => JsSuccess(value)
      case Failure(exception) => JsError(JsonValidationError(exception.getMessage, s))
    }
    case _ => JsError("invalid json value")
  }

}

object RegistryJsonWrites {

  def namedWrites[T <: NamedValue]: Writes[T] = (o: T) => JsString(o.name)

}