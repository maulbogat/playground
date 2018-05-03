package maulbogat.roy.registry

import maulbogat.roy.registry.named.{GenericNamedRegistry, GenericRegistry, NamedValue}

abstract class ExternalRegistry[T] extends EnumRegistry
  with GenericRegistry[T]
  with Registry {

  final override protected[registry] def keyToValue(key: K): V = key.asInstanceOf[Register[T]].element

  final protected def register(element: T): Register[T] = ValWrapper(element)

  private case class ValWrapper(element: T) extends Val with Register[T]

}

trait Registered[T] {

  protected def registration: Registration

  final protected type Registration = () => Register[T]

}

trait Register[T] {

  def element: T

}

abstract class NamedExternalRegistry[T <: NamedValue] extends ExternalRegistry[T]
  with GenericNamedRegistry[T]