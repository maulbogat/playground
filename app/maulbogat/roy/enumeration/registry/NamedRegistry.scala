package maulbogat.roy.enumeration.registry

import maulbogat.roy.enumeration.{HasDefault, HasDefaultError, NamedEnumeration, NamedValue}

trait NamedRegistered[T] extends Registered[T] {
  type NamedRegister = () => NamedRegistration[T]

  override def register: () => NamedRegistration[T]

  final def name(): String = register().name

}

trait NamedRegistration[T] extends Registration[T] with NamedValue

trait NamedRegistry[T] extends NamedEnumeration with Registry[T] {

  override protected type EnumVal = NamedRegisterVal

  def findRegistered(name: String): Option[T] = find(name).map(_.element)

  protected def register(name: String, element: T): NamedRegistration[T] = NamedRegisterVal(name, element)

  protected case class NamedRegisterVal(name: String, element: T) extends RegisterVal with NamedRegistration[T]

}

trait RegistryDefault[T] extends HasDefault {
  _: NamedRegistry[T] =>

  def getRegistered(name: String): T = from(name).element

}

trait RegistryDefaultValue[T] extends RegistryDefault[T] {
  _: NamedRegistry[T] =>

  protected def default: T
}

trait RegistryDefaultError[T] extends RegistryDefault[T] with HasDefaultError {
  _: NamedRegistry[T] =>
}