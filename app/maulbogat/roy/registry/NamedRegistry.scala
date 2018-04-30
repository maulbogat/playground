package maulbogat.roy.registry

trait NamedRegistry extends Registry {

  override protected type V <: NamedValue

  def getByName(name: Option[String]): Option[V] = name.flatMap(getByName)

  def getByName(name: String): Option[V] = getAllValues.find(_.name == name)

  def getAllNames: List[String] = getAllValues.map(_.name)

}

trait NamedValue {

  def name: String

}