package maulbogat.roy.registry.named

private[registry] trait RegistryDefault {
  _: NamedRegistry =>

  def getWithDefault(name: String): NamedRegistryValue

}

trait RegistryDefaultError extends RegistryDefault {
  _: NamedRegistry =>

  final override def getWithDefault(name: String): NamedRegistryValue = getByName(name).getOrElse(throw error(name))

  protected def error(name: String): Throwable

}

trait RegistryDefaultValue extends RegistryDefault {
  _: NamedRegistry =>

  final override def getWithDefault(name: String): V = getByName(name).getOrElse(default)

  protected def default: NamedRegistryValue

}

trait RegistryDefaultNaive extends RegistryDefault {
  _: NamedRegistry =>

  final override def getWithDefault(name: String): NamedRegistryValue = getByName(name).get

}