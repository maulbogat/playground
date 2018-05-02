package maulbogat.roy.registry

trait CompositeRegistry[S, T] extends Registry
  with RegistryKey
  with RegistryValue
  with RegistryKeyGetter
  with RegistryKeyMapper {

  override type K = S

  override type V = T

  def keyRegistry: Registry with GenericRegistryValue[S]

  def getAllKeys: List[S] = keyRegistry.getAllValues

}