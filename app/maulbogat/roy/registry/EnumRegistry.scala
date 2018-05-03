package maulbogat.roy.registry

private[registry] abstract class EnumRegistry extends Enumeration with Registry {

  final override protected[registry] type K = Value

  final override protected[registry] def getAllKeys: List[K] = values.toList

}