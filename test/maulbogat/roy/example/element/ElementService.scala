package maulbogat.roy.example.element

import maulbogat.roy.example.element.ElementRegistry.{Earth, Fire, Wind}
import maulbogat.roy.registry.{CompositeRegistry, ExternalRegistry, Register, Registered}

trait ElementService

class EarthService extends ElementService {
}

class WindService extends ElementService {
}

class FireService extends ElementService {
}

sealed trait Element extends Registered[Element]

object ElementRegistry extends ExternalRegistry[Element] {

  case object Earth extends Element {
    override val registration: Registration = () => ElementRegistry.earth
  }

  val earth: Register[Element] = register(Earth)

  case object Wind extends Element {
    override val registration: Registration = () => ElementRegistry.wind
  }

  val wind: Register[Element] = register(Wind)

  case object Fire extends Element {
    override val registration: Registration = () => ElementRegistry.fire
  }

  val fire: Register[Element] = register(Fire)

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