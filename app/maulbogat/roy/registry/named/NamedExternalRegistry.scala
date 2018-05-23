package maulbogat.roy.registry.named

import maulbogat.roy.registry.named.NamedRegistered.NamedRegistration
import maulbogat.roy.registry.{ExternalRegistry, Register, Registered}

abstract class NamedExternalRegistry[T <: NamedValue] extends ExternalRegistry[T]
  with GenericNamedRegistry[T] {

  protected def registerWithName(element: T): NamedRegister[T] = registerWithName(element.name, element)

}

// quick fix - subject to future refactor
trait NamedRegistered[T] extends Registered[T] with NamedValue {

  override def registration: NamedRegistration[T]

  final override def name: String = registration().name

}

object NamedRegistered {

  type NamedRegistration[T] = () => NamedRegister[T]

}

trait NamedRegister[T] extends Register[T] with NamedValue