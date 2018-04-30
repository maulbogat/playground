package maulbogat.roy.registry

trait NamedRegistry extends Registry {

  override protected type V <: NamedValue

  def getByName(name: Option[String]): Option[V] = name.flatMap(getByName)

  def getByName(name: String): Option[V] = getAllValues.find(_.name == name)

}

trait RegistryDefault {
  _: NamedRegistry =>

  def getWithDefault(name: String): V

}

trait RegistryDefaultValue extends RegistryDefault {
  _: NamedRegistry =>

  override def getWithDefault(name: String): V = getByName(name).getOrElse(default)

  protected def default: V

}

trait RegistryDefaultError extends RegistryDefault {
  _: NamedRegistry =>

  override def getWithDefault(name: String): V = getByName(name).getOrElse(throw error(name))

  protected def error(name: String): Throwable

}

trait NamedValue {

  def name: String

}