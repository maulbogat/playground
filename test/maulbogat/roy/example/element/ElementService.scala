package maulbogat.roy.example.element

import maulbogat.roy.example.element.ElementRegistry.{Earth, Fire, Wind}
import maulbogat.roy.registry.{CompositeRegistry, ExternalRegistry, Register, Registered}

trait ElementService extends Registered[Element]

class EarthService extends ElementService {
  override val registration: Registration = () => ElementRegistry.earth
}

class WindService extends ElementService {
  override val registration: Registration = () => ElementRegistry.wind
}

class FireService extends ElementService {
  override val registration: Registration = () => ElementRegistry.fire
}

sealed trait Element

object ElementRegistry extends ExternalRegistry[Element] {

  val earth: Register[Element] = register(Earth)

  val wind: Register[Element] = register(Wind)

  val fire: Register[Element] = register(Fire)

  case object Earth extends Element

  case object Wind extends Element

  case object Fire extends Element

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