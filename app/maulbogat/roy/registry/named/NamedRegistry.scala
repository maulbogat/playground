package maulbogat.roy.registry.named

import maulbogat.roy.registry.{GenericRegistry, Registry}

private[registry] trait NamedRegistry {
  _: Registry =>

  override protected[registry] type V <: NamedValue

  protected[registry] def valueToName(value: V): String

  final def getByName(name: Option[String]): Option[V] = name.flatMap(getByName)

  final def getByName(name: String): Option[V] = getAllValues.find(valueToName(_) == name)

  final def getByNameIgnoreCase(name: Option[String]): Option[V] = name.flatMap(getByNameIgnoreCase)

  final def getByNameIgnoreCase(name: String): Option[V] = getAllValues.find(valueToName(_).equalsIgnoreCase(name))

  final def getAllNames: List[String] = getAllValues.map(valueToName)

  final def nameExists(name: String): Boolean = getByName(name).isDefined

}

trait TypeNamedRegistry extends NamedRegistry {
  _: Registry =>

  protected type NamedRegistryValue <: NamedValue

  final override protected[registry] type V = NamedRegistryValue

  override protected[registry] def valueToName(value: V): String = value.name

}

trait GenericNamedRegistry[T <: NamedValue] extends NamedRegistry {
  _: Registry with GenericRegistry[T] =>

  override protected[registry] def valueToName(value: V): String = value.name

}