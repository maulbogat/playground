package maulbogat.roy.registry.named

import maulbogat.roy.registry.Registry

private[registry] trait RegistryDefault {
  _: Registry with NamedRegistry =>

  def getWithDefault(name: String): V

}

trait RegistryDefaultError extends RegistryDefault {
  _: Registry with NamedRegistry =>

  final override def getWithDefault(name: String): V = getByName(name).getOrElse(throw error(name))

  protected def error(name: String): Throwable

}

trait RegistryDefaultValue extends RegistryDefault {
  _: Registry with NamedRegistry =>

  final override def getWithDefault(name: String): V = getByName(name).getOrElse(default)

  protected def default: V

}

trait RegistryDefaultNaive extends RegistryDefault {
  _: Registry with NamedRegistry =>

  final override def getWithDefault(name: String): V = getByName(name).get

}