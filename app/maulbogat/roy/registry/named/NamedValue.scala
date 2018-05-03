package maulbogat.roy.registry.named

trait NamedValue {

  def name: String

}

trait ToStringNamedValue extends NamedValue {

  final lazy val name: String = toString

}

trait ToLowerStringNamedValue extends NamedValue {

  final lazy val name: String = toString.toLowerCase

}