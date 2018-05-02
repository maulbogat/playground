package maulbogat.roy.registry

trait EnumRegistry extends Enumeration
  with RegistryKey
  with RegistryKeyGetter {

  override type K = Value

  override def getAllKeys: List[K] = values.toList

}