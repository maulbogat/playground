package maulbogat.roy.registry

abstract class ExternalRegistry[T] extends EnumRegistry
  with GenericRegistry[T] {

  final override protected def keyToValue(key: K): V = key.asInstanceOf[Register[T]].element

  final protected def register(element: T): Register[T] = new ValWrapper(element)

  protected class ValWrapper(val element: T) extends Val with Register[T]

}

trait Registered[T] {

  def registration: Registration

  protected type Registration = () => Register[T]

}

trait Register[T] {

  def element: T

}