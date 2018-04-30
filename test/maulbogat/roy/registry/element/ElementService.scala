package maulbogat.roy.registry.element

import maulbogat.roy.registry._
import maulbogat.roy.registry.element.ElementRegistry.{Earth, Fire, Wind}

trait ElementService extends Registered[Element]

class EarthService extends ElementService {
  override protected val registration: Registration = () => ElementRegistry.earth
}

class WindService extends ElementService {
  override protected val registration: Registration = () => ElementRegistry.wind
}

class FireService extends ElementService {
  override protected val registration: Registration = () => ElementRegistry.fire
}

sealed trait Element

object ElementRegistry extends Enumeration with CompelledRegistry with GenericRegistry[Element] {

  case object Earth extends Element

  val earth: Register[Element] = register(Earth)

  case object Wind extends Element

  val wind: Register[Element] = register(Wind)

  case object Fire extends Element

  val fire: Register[Element] = register(Fire)

}

class ElementServiceRegistry(earthService: EarthService,
                             windService: WindService,
                             fireService: FireService) extends CompositeRegistry[Element, ElementService] {

  override protected def keyRegistry: GenericRegistry[Element] = ElementRegistry

  override protected def keyToValue(key: Element): ElementService = key match {
    case Earth => earthService
    case Wind => windService
    case Fire => fireService
  }

}