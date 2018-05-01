package maulbogat.roy.registry

trait EnumRegistry extends Registry {
  _: Enumeration =>

  override protected[registry] type Key <: Val

  override protected[registry] def getAllKeys: List[Key] = values.toList.map(_.asInstanceOf[Key])

}