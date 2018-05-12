package maulbogat.roy.registry

import maulbogat.roy.registry.Registered.Registration
import maulbogat.roy.registry.named.NamedRegister

import scala.language.implicitConversions

abstract class ExternalRegistry[T] extends EnumRegistry
  with GenericRegistry[T] {

  final override protected def keyToValue(key: K): V = key.asInstanceOf[Register[T]].element

  final protected def registerAndGet(element: T): T = register(element).element

  final protected def register(element: T): Register[T] = new ValWrapper(element)

  protected class ValWrapper(val element: T) extends Val with Register[T]

  protected def registerWithName(name: String, element: T): NamedRegister[T] = NamedValWrapper(name, element)

  protected case class NamedValWrapper(name: String, override val element: T) extends ValWrapper(element) with NamedRegister[T]

}

trait Registered[T] {

  def registration: Registration[T]

}

object Registered {

  type Registration[T] = () => Register[T]

  // subject to future refactor - not sure if returning Registration will work instead.
  // need to figure out under what condition a NullPointer is thrown.
  // NamedRegistered is an example.
  implicit def registration[T](register: Register[T]): Registration[T] = () => register

}

trait Register[T] {

  def element: T

}