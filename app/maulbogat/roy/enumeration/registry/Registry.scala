package maulbogat.roy.enumeration.registry

import maulbogat.roy.enumeration.TypedEnumeration

import scala.reflect.ClassTag

trait Registered[T] {
  protected type Register = () => Registration[T]

  protected def register: () => Registration[T]
}

trait Registration[T] {
  def element: T
}

trait Registry[T] extends TypedEnumeration {

  override protected type EnumVal <: RegisterVal

  def getByType[S <: T : ClassTag]: List[S] = getAllRegistered.collect { case s: S => s }

  def getAllRegistered: List[T] = getAll.map(_.element)

  protected trait RegisterVal extends Val with Registration[T]

}