package maulbogat.roy.registry

trait CompositeRegistry[S, T] extends Registry
  with RegistryKey
  with GenericRegistryValue[T]
  with RegistryKeyGetter
  with RegistryKeyMapper {

  final override protected[registry] type K = S

  protected def keyRegistry: Registry with GenericRegistryValue[S]

  final override protected[registry] def getAllKeys: List[S] = keyRegistry.getAllValues

}