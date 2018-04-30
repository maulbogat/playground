package maulbogat.roy

trait GenericEnumRegistry extends WrappedEnumRegistry {
  _: Enumeration =>

  protected def registerAll(elements: V*): Seq[V] = elements.map(register)

  protected def register(element: V): V = new Wrapper(element).element

}