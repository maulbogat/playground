package maulbogat.roy.registry

trait RegistryDefault {
  _: NamedRegistry =>

  def getWithDefault(name: String): NamedVal

}

trait RegistryDefaultError extends RegistryDefault {
  _: NamedRegistry =>

  override def getWithDefault(name: String): NamedVal = getByName(name).getOrElse(throw error(name))

  def error(name: String): Throwable

}

trait RegistryDefaultValue extends RegistryDefault {
  _: NamedRegistry =>

  override def getWithDefault(name: String): V = getByName(name).getOrElse(default)

  def default: NamedVal

}

trait RegistryDefaultNaive extends RegistryDefault {
  _: NamedRegistry =>

  override def getWithDefault(name: String): NamedVal = getByName(name).get

}