package maulbogat.roy.registry

trait NamedRegistry {
  _: Registry =>

  protected type NamedVal <: NamedValue

  final override protected[registry] type V = NamedVal

  final def getByName(name: Option[String]): Option[V] = name.flatMap(getByName)

  final def getAllNames: List[String] = getAllValues.map(_.name)

  final def nameExists(name: String): Boolean = getByName(name).isDefined

  final def getByName(name: String): Option[V] = getAllValues.find(_.name == name)

}

trait GenericNamedRegistry[T <: NamedValue] extends NamedRegistry {
  _: Registry =>

  final override protected type NamedVal = T

}

trait NamedValue {

  def name: String

}

trait ToStringNamedValue extends NamedValue {

  final def name: String = toString

}