package maulbogat.roy.registry

trait SimpleRegistry extends EnumRegistry
  with Registry {

  override protected[registry] type V <: Value

  final override protected[registry] def keyToValue(key: K): V = key.asInstanceOf[V]

}