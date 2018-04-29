package maulbogat.roy.enumeration

trait NamedValue {
  def name: String
}

trait NamedEnumeration extends TypedEnumeration {

  override protected type EnumVal <: Val with NamedValue

  def find(name: Option[String]): Option[EnumVal] = name.flatMap(find)

  def find(name: String): Option[EnumVal] = getAll.find(_.name == name)

}

trait HasDefault {
  _: NamedEnumeration =>

  def from(name: String): EnumVal

}

trait HasDefaultValue extends HasDefault {
  _: NamedEnumeration =>

  override def from(name: String): EnumVal = find(name).getOrElse(default)

  protected def default: EnumVal
}

trait HasDefaultError extends HasDefault {
  _: NamedEnumeration =>

  override def from(name: String): EnumVal = find(name).getOrElse(throw error(name))

  protected def error(name: String): Throwable
}