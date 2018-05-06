package maulbogat.roy.registry.named

import maulbogat.roy.registry.named.NamedRegistered.NamedRegistration
import maulbogat.roy.registry.{ExternalRegistry, Register, Registered}

abstract class NamedExternalRegistry[T <: NamedValue] extends ExternalRegistry[T]
  with GenericNamedRegistry[T] {

  protected def registerWithName(name: String, element: T): NamedRegister[T] = NamedValWrapper(name, element)

  protected case class NamedValWrapper(name: String, override val element: T)
    extends ValWrapper(element) with NamedRegister[T]

}

// quick fix - subject to future refactor
trait NamedRegistered[T] extends Registered[T] with NamedValue {

  override def registration: NamedRegistration[T]

  override def name: String = registration().name

}

object NamedRegistered {

  type NamedRegistration[T] = () => NamedRegister[T]

}

trait NamedRegister[T] extends Register[T] {

  def name: String

}