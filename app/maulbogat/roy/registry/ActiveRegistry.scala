package maulbogat.roy.registry

abstract class ActiveRegistry[T] extends EnumRegistry
  with Registry {

  override protected[registry] type V = T // TODO make final

  final override protected[registry] def keyToValue(key: K): V = key.asInstanceOf[Register[T]].element

  final protected def register(element: T): Register[T] = ValWrapper(element)

  private case class ValWrapper(element: T) extends Val with Register[T]

}

trait Registered[T] {

  final protected type Registration = () => Register[T]

  protected def registration: Registration

}

trait Register[T] {

  def element: T

}