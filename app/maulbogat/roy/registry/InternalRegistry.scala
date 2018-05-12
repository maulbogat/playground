package maulbogat.roy.registry

import maulbogat.roy.registry.named.{NamedValue, TypeNamedRegistry}

abstract class InternalRegistry extends EnumRegistry {

  type RegistryValue <: Value

  override protected[registry] type V = RegistryValue

  final override protected def keyToValue(key: K): V = key.asInstanceOf[V]

}

abstract class NamedInternalRegistry extends InternalRegistry
  with TypeNamedRegistry {

  override type NamedRegistryValue <: Value with NamedValue

  final override type RegistryValue = NamedRegistryValue

}