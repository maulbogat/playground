package maulbogat.roy.registry.named

trait NamedValue {

  def name: String

}

trait ToStringNamedValue extends NamedValue {

  override def name: String = toString

}

trait ToLowerStringNamedValue extends NamedValue {

  override def name: String = toString.toLowerCase

}