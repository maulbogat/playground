package maulbogat.roy.registry

trait NamedValue {

  def name: String

}

trait ToStringNamedValue extends NamedValue {

  final def name: String = toString

}