package maulbogat.roy

trait NamedRegistry extends Registry {

  override protected type V <: NamedValue

  def getByName(name: Option[String]): Option[V] = name.flatMap(getByName)

  def getByName(name: String): Option[V] = getAllValues.find(_.name == name)

}

trait Default {
  _: NamedRegistry =>

  def getWittDefault(name: String): V

}

trait DefaultValue extends Default {
  _: NamedRegistry =>

  override def getWittDefault(name: String): V = getByName(name).getOrElse(default)

  protected def default: V

}

trait DefaultError extends Default {
  _: NamedRegistry =>

  override def getWittDefault(name: String): V = getByName(name).getOrElse(throw error(name))

  protected def error(name: String): Throwable

}

trait NamedValue {

  def name: String

}