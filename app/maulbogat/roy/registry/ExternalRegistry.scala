package maulbogat.roy.registry

import maulbogat.roy.registry.Registered.Registration

abstract class ExternalRegistry[T] extends EnumRegistry
  with GenericRegistry[T] {

  final override protected def keyToValue(key: K): V = key.asInstanceOf[Register[T]].element

  final protected def register(element: T): Register[T] = new ValWrapper(element)

  protected class ValWrapper(val element: T) extends Val with Register[T]

}

trait Registered[T] {

  def registration: Registration[T]

}

object Registered {

  type Registration[T] = () => Register[T]

}

trait Register[T] {

  def element: T

}