package maulbogat.roy.registry

trait RegistryDefault {
  _: NamedRegistry =>

  def getWithDefault(name: String): V

}

trait RegistryDefaultValue extends RegistryDefault {
  _: NamedRegistry =>

  final override def getWithDefault(name: String): V = getByName(name).getOrElse(default)

  protected def default: V

}

trait RegistryDefaultError extends RegistryDefault {
  _: NamedRegistry =>

  final override def getWithDefault(name: String): V = getByName(name).getOrElse(throw error(name))

  protected def error(name: String): Throwable

}

trait RegistryDefaultNaive extends RegistryDefault {
  _: NamedRegistry =>

  final override def getWithDefault(name: String): V = getByName(name).get

}