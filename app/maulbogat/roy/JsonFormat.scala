package maulbogat.roy

import play.api.libs.json._

import scala.util.{Failure, Success, Try}

trait JsonFormat extends JsonReads {
  _: NamedRegistry with Default =>

  val namedFormat: Format[V] = Format.apply(namedReads, JsonWrites.namedWrites[V])

}

trait JsonReads {
  _: NamedRegistry with Default =>

  val namedReads: Reads[V] = {
    case JsString(s) => Try(getWittDefault(s)) match {
      case Success(value) => JsSuccess(value)
      case Failure(exception) => JsError(JsonValidationError(exception.getMessage, s))
    }
    case _ => JsError("invalid json value")
  }

}

object JsonWrites {

  def namedWrites[T <: NamedValue]: Writes[T] = (o: T) => JsString(o.name)

}