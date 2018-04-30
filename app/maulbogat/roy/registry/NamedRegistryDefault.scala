package maulbogat.roy.registry

trait NamedRegistryDefault {
  _: NamedRegistry =>

  def getWithDefault(name: String): V

}

trait NamedRegistryDefaultValue extends NamedRegistryDefault {
  _: NamedRegistry =>

  override def getWithDefault(name: String): V = getByName(name).getOrElse(default)

  protected def default: V

}

trait NamedRegistryDefaultError extends NamedRegistryDefault {
  _: NamedRegistry =>

  override def getWithDefault(name: String): V = getByName(name).getOrElse(throw error(name))

  protected def error(name: String): Throwable

}

trait NamedRegistryDefaultNaive extends NamedRegistryDefault {
  _: NamedRegistry =>

  override def getWithDefault(name: String): V = getByName(name).get

}