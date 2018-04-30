package maulbogat.roy.registry

trait EnumRegistry extends Registry {
  _: Enumeration =>

  override protected type Key <: Val

  override protected def getAllKeys: List[Key] = values.toList.map(_.asInstanceOf[Key])

}