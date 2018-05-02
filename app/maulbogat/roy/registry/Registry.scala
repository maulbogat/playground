package maulbogat.roy.registry

trait Registry {
  _: RegistryKeyGetter with RegistryValue with RegistryKeyMapper =>

  def getAllValues: List[V] = getAllKeys.map(keyToValue)

}

trait RegistryKey {
  type K
}

trait RegistryValue {
  type V
}

trait RegistryKeyGetter {
  _: RegistryKey =>

  def getAllKeys: List[K]

}

trait RegistryKeyMapper {
  _: RegistryKey with RegistryValue =>

  def keyToValue(key: K): V

}

trait GenericRegistryValue[T] extends RegistryValue {
  override type V = T
}