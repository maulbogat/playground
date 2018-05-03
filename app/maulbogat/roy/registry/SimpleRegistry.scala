package maulbogat.roy.registry

abstract class SimpleRegistry extends EnumRegistry
  with Registry {

  override protected[registry] type V <: Value

  final override protected[registry] def keyToValue(key: K): V = key.asInstanceOf[V]

}

abstract class SimpleNamedRegistry extends SimpleRegistry
  with TypeNamedRegistry {

  override protected type NamedVal <: Value with NamedValue

}