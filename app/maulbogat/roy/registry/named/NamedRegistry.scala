package maulbogat.roy.registry.named

import maulbogat.roy.registry.{ActiveRegistry, Registry}

private[registry] trait NamedRegistry {
  _: Registry =>

  protected[registry] def valueToName(value: V): String

  final def getByName(name: Option[String]): Option[V] = name.flatMap(getByName)

  final def getAllNames: List[String] = getAllValues.map(valueToName)

  final def nameExists(name: String): Boolean = getByName(name).isDefined

  final def getByName(name: String): Option[V] = getAllValues.find(valueToName(_) == name)

}

trait TypeNamedRegistry extends NamedRegistry {
  _: Registry =>

  protected type NamedRegistryValue <: NamedValue

  final override protected[registry] type V = NamedRegistryValue

  final override protected[registry] def valueToName(value: V): String = value.name

}

trait GenericNamedRegistry[T <: NamedValue] extends NamedRegistry {
  _: ActiveRegistry[T] =>

  override protected[registry] type V = T

  final override protected[registry] def valueToName(value: V): String = value.name

}

trait DefaultNamedRegistry extends NamedRegistry {
  _: Registry =>

  protected def defaultName: String

  final override protected[registry] def valueToName(value: V): String = value match {
    case named: NamedValue => named.name
    case _ => defaultName
  }

}