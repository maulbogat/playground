package maulbogat.roy.registry.named

import maulbogat.roy.registry.{ExternalRegistry, Register, Registered}

abstract class NamedExternalRegistry[T <: NamedValue] extends ExternalRegistry[T]
  with GenericNamedRegistry[T] {

  protected def registerWithName(name: String, element: T): NamedRegister[T] = NamedValWrapper(name, element)

  protected case class NamedValWrapper(name: String, override val element: T)
    extends ValWrapper(element) with NamedRegister[T]

}

trait NamedRegistered[T] extends Registered[T] with NamedValue {

  def registration: NamedRegistration

  def name: String = registration().name

  protected type NamedRegistration = () => NamedRegister[T]

}

trait NamedRegister[T] extends Register[T] {

  def name: String

  def element: T

}