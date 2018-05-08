package maulbogat.roy.registry.named

import maulbogat.roy.registry.Registry

private[registry] trait RegistryDefault {
  _: Registry with NamedRegistry =>

  def getWithDefault(name: String): V = getByName(name).getOrElse(getDefault(name))

  def getWithDefaultIgnoreCase(name: String): V = getByNameIgnoreCase(name).getOrElse(getDefault(name))

  protected def getDefault(name: String): V

}

trait DefaultRegistryError extends RegistryDefault {
  _: Registry with NamedRegistry =>

  protected def error(name: String): Throwable

  final override protected def getDefault(name: String): V = throw error(name)

}

trait DefaultRegistryValue extends RegistryDefault {
  _: Registry with NamedRegistry =>

  protected def default: V

  final override protected def getDefault(name: String): V = default

}