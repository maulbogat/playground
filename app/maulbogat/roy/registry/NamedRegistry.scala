package maulbogat.roy.registry

trait NamedRegistry {
  _: Registry with RegistryValue =>

  type NamedVal <: NamedValue

  override type V = NamedVal

  def getByName(name: Option[String]): Option[V] = name.flatMap(getByName)

  def getByName(name: String): Option[V] = getAllValues.find(_.name == name)

  def getAllNames: List[String] = getAllValues.map(_.name)

  def nameExists(name: String): Boolean = getByName(name).isDefined

}

trait GenericNamedRegistry[T <: NamedValue] extends NamedRegistry {
  _: Registry with RegistryValue =>

  override type NamedVal = T
}

trait NamedValue {
  def name: String
}

trait ToStringNamedValue extends NamedValue {
  def name: String = toString
}