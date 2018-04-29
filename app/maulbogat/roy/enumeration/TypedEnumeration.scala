package maulbogat.roy.enumeration

import scala.reflect.ClassTag

/**
  * Typed Enumeration supports:
  * 1. Typed values.
  * 2. Ordered values.
  * 3. Get all values.
  * 4. Get all values extending a subtype.
  *
  * It is extended by InnerTypeEnumeration
  * and GenericEnumeration.
  */
trait TypedEnumeration extends Enumeration {

  protected type EnumVal

  def getAll: List[EnumVal]

  def getByType[S <: EnumVal : ClassTag]: List[S] = getAll.collect { case s: S => s }

}

/**
  * Inner Type Enumeration supports:
  * 1. A custom Val class instead of register.
  */
trait InnerTypeEnumeration extends TypedEnumeration {

  override protected type EnumVal <: Val

  override def getAll: List[EnumVal] = values.toList.map(_.asInstanceOf[EnumVal])

}

/**
  * Generic Type Enumeration supports:
  * 1. An external type.
  * 2. Multiple registration when specific values are not required.
  */
trait GenericEnumeration[T] extends TypedEnumeration {

  override protected type EnumVal = T

  override def getAll: List[T] = values.toList.map(_.asInstanceOf[ValWrapper].element)

  protected def registerAll(elements: T*): Seq[T] = elements.map(register)

  protected def register(element: T): T = ValWrapper(element).element

  private case class ValWrapper(element: T) extends Val

}