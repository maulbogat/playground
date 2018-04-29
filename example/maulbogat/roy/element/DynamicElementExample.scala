package maulbogat.roy.element

import maulbogat.roy.element.DynamicElementExample.ElementRegistry.ElementRegistry
import maulbogat.roy.element.DynamicElementExample.{EarthService, FireService, WindService}
import maulbogat.roy.enumeration.registry._

object DynamicElementExample {

  sealed trait Element

  trait ElementService extends Registered[Element]

  class EarthService extends ElementService {
    override val register: Register = () => ElementRegistry.earth

    override def toString: String = "earth service"
  }

  class WindService extends ElementService {
    override val register: Register = () => ElementRegistry.wind

    override def toString: String = "wind service"
  }

  class FireService extends ElementService {
    override val register: Register = () => ElementRegistry.fire

    override def toString: String = "fire service"
  }

  object ElementRegistry extends TypedRegistry[Element] {

    val earth: Registration[Element] = register(Earth)
    val wind: Registration[Element] = register(Wind)
    val fire: Registration[Element] = register(Fire)

    class ElementRegistry(earthService: EarthService,
                          windService: WindService,
                          fireService: FireService) extends DynamicRegistry[ElementService, Element] {

      override protected def nameRegistry: Registry[Element] = ElementRegistry

      override protected def fromName(name: Element): ElementService = name match {
        case Earth => earthService
        case Wind => windService
        case Fire => fireService
      }
    }

    case object Earth extends Element

    case object Wind extends Element

    case object Fire extends Element

  }

}

object DynamicProcessorApp extends App {

  val earthService = new EarthService
  val windService = new WindService
  val fireService = new FireService
  val registry = new ElementRegistry(earthService, windService, fireService)

  // OUTPUT: List(earth service, wind service, fire service)
  println(registry.getAllRegistered)

}