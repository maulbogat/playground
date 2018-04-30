package maulbogat.roy.registry.action

import maulbogat.roy.registry.Registry.CompelledGenericRegistry
import maulbogat.roy.registry._

sealed trait Action extends Registered[Action] with NamedValue

case object Eat extends Action {
  override val name: String = "eat"

  override val registration: Registration = () => ActionRegistry.eat
}

case object Pray extends Action {
  override val name: String = "pray"

  override val registration: Registration = () => ActionRegistry.pray
}

case object Love extends Action {
  override val name: String = "love"

  override val registration: Registration = () => ActionRegistry.love
}

object ActionRegistry extends CompelledGenericRegistry[Action]
  with NamedRegistry {

  val eat: Register[Action] = register(Eat)

  val pray: Register[Action] = register(Pray)

  val love: Register[Action] = register(Love)

}