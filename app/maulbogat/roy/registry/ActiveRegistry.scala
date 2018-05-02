package maulbogat.roy.registry

trait ActiveRegistry[T] extends EnumRegistry
  with GenericRegistryValue[T]
  with RegistryKeyMapper
  with Registry {

  override def keyToValue(key: K): V = key.asInstanceOf[Register[T]].element

  def register(element: T): Register[T] = ValWrapper(element)

  case class ValWrapper(element: T) extends Val with Register[T]

}

trait Registered[T] {

  type Registration = () => Register[T]

  def registration: Registration

}

trait Register[T] {

  def element: T

}