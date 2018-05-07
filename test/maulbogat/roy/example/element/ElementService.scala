package maulbogat.roy.example.element

import maulbogat.roy.example.element.ElementRegistry.{Earth, Fire, Wind}
import maulbogat.roy.registry.Registered._
import maulbogat.roy.registry._

trait ElementService extends Registered[Element]

class EarthService extends ElementService {
  override val registration: Registration[Element] = ElementRegistry.earth
}

class WindService extends ElementService {
  override val registration: Registration[Element] = ElementRegistry.wind
}

class FireService extends ElementService {
  override val registration: Registration[Element] = ElementRegistry.fire
}

sealed trait Element

object ElementRegistry extends ExternalRegistry[Element] {

  case object Earth extends Element
  val earth: Registration[Element] = register(Earth)

  case object Wind extends Element
  val wind: Registration[Element] = register(Wind)

  case object Fire extends Element
  val fire: Registration[Element] = register(Fire)

}

class ElementServiceRegistry(earthService: EarthService,
                             windService: WindService,
                             fireService: FireService) extends CompositeRegistry[Element, ElementService] {

  override def keyRegistry: ExternalRegistry[Element] = ElementRegistry

  override def keyToValue(key: Element): ElementService = key match {
    case Earth => earthService
    case Wind => windService
    case Fire => fireService
  }

}