package maulbogat.roy.enumeration

trait TypedEnumeration extends Enumeration {

  protected type EnumVal <: Val

  def getAll: List[EnumVal] = values.toList.map(_.asInstanceOf[EnumVal])

}