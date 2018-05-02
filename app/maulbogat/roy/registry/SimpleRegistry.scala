package maulbogat.roy.registry

trait SimpleRegistry extends EnumRegistry
  with RegistryValue
  with RegistryKeyMapper
  with Registry {

  override type V <: Value

  override def keyToValue(key: K): V = key.asInstanceOf[V]

}