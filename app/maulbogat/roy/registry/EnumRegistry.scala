package maulbogat.roy.registry

trait EnumRegistry extends Enumeration
  with RegistryKey
  with RegistryKeyGetter {

  final override protected[registry] type K = Value

  final override protected[registry] def getAllKeys: List[K] = values.toList

}