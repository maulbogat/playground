package maulbogat.roy.element

import maulbogat.roy.element.StaticElementExample.ElementRegistry
import maulbogat.roy.enumeration.registry.{Registered, Registration, TypedRegistry}

object StaticElementExample {

  trait ElementService extends Registered[ElementService]

  object EarthService extends ElementService {
    override val register: Register = () => ElementRegistry.earth

    override def toString: String = "earth service"
  }

  object WindService extends ElementService {
    override val register: Register = () => ElementRegistry.wind

    override def toString: String = "wind service"
  }

  object FireService extends ElementService {
    override val register: Register = () => ElementRegistry.fire

    override def toString: String = "fire service"
  }

  object ElementRegistry extends TypedRegistry[ElementService] {
    val earth: Registration[ElementService] = register(EarthService)
    val wind: Registration[ElementService] = register(WindService)
    val fire: Registration[ElementService] = register(FireService)
  }

}

object ProcessorApp extends App {

  // OUTPUT: List(earth service, wind service, fire service)
  println(ElementRegistry.getAllRegistered)

}