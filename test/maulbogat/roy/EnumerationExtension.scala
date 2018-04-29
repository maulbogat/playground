package maulbogat.roy

object EnumerationExtension {

  // Json support

  //  import play.api.data.validation.ValidationError
  //  import play.api.libs.json._
  //  import scala.util.{Failure, Success, Try}

  //  _: NamedEnumeration => // or maybe in named value
  //  def writeVal: Writes[EnumVal] = new Writes[EnumVal] {
  //    override def writes(o: EnumVal): JsValue = JsString(o.name)
  //  }

  //  _: HasDefault =>
  //  def readVal: Reads[EnumVal] = new Reads[EnumVal] {
  //    override def reads(json: JsValue): JsResult[EnumVal] = json match {
  //      case JsString(s) => Try(from(s)) match {
  //        case Success(value) => JsSuccess(value)
  //        case Failure(exception) => JsError(ValidationError(exception.getMessage, s))
  //      }
  //      case _ => JsError("Invalid json value")
  //    }
  //  }

  // Collection support

}
