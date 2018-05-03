package maulbogat.roy.registry.named

private[registry] trait RegistryDefault {
  _: NamedRegistry =>

  def getWithDefault(name: String): NamedVal

}

trait RegistryDefaultError extends RegistryDefault {
  _: NamedRegistry =>

  final override def getWithDefault(name: String): NamedVal = getByName(name).getOrElse(throw error(name))

  protected def error(name: String): Throwable

}

trait RegistryDefaultValue extends RegistryDefault {
  _: NamedRegistry =>

  final override def getWithDefault(name: String): V = getByName(name).getOrElse(default)

  protected def default: NamedVal

}

trait RegistryDefaultNaive extends RegistryDefault {
  _: NamedRegistry =>

  final override def getWithDefault(name: String): NamedVal = getByName(name).get

}