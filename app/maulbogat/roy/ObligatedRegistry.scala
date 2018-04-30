package maulbogat.roy

trait ObligatedRegistry extends WrappedEnumRegistry {
  _: Enumeration =>

  protected def register(element: V): Register[V] = ValWrapper(element)

  protected case class ValWrapper(override val element: V) extends Wrapper(element) with Register[V]

}

trait Registered[T] {

  protected type Registration = () => Register[T]

  protected def registration: Registration

}

trait Register[T] {

  def element: T

}