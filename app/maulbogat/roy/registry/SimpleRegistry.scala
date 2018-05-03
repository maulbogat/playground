package maulbogat.roy.registry

import maulbogat.roy.registry.named.{NamedValue, TypeNamedRegistry}

abstract class SimpleRegistry extends EnumRegistry
  with Registry {

  protected type RegistryValue <: Value

  override protected[registry] type V = RegistryValue

  final override protected[registry] def keyToValue(key: K): V = key.asInstanceOf[V]

}

abstract class SimpleNamedRegistry extends SimpleRegistry
  with TypeNamedRegistry {

  override protected type NamedRegistryValue <: Value with NamedValue

  final override protected type RegistryValue = NamedRegistryValue

}