package maulbogat.roy.example.action

import maulbogat.roy.registry._
import maulbogat.roy.registry.named.{NamedExternalRegistry, ToLowerStringNamedValue}

sealed trait Action extends Registered[Action] with ToLowerStringNamedValue

case object Eat extends Action {
  override val registration: Registration = () => ActionRegistry.eat
}

case object Pray extends Action {
  override val registration: Registration = () => ActionRegistry.pray
}

case object Love extends Action {
  override val registration: Registration = () => ActionRegistry.love
}

object ActionRegistry extends NamedExternalRegistry[Action] {

  val eat: Register[Action] = register(Eat)

  val pray: Register[Action] = register(Pray)

  val love: Register[Action] = register(Love)

}