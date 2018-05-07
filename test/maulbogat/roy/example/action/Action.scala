package maulbogat.roy.example.action

import maulbogat.roy.registry.Registered
import maulbogat.roy.registry.Registered.Registration
import maulbogat.roy.registry.named.{NamedExternalRegistry, ToLowerStringNamedValue}

sealed trait Action extends Registered[Action] with ToLowerStringNamedValue

case object Eat extends Action {
  override val registration: Registration[Action] = ActionRegistry.eat
}

case object Pray extends Action {
  override val registration: Registration[Action] = ActionRegistry.pray
}

case object Love extends Action {
  override val registration: Registration[Action] = ActionRegistry.love
}

object ActionRegistry extends NamedExternalRegistry[Action] {

  val eat: Registration[Action] = register(Eat)

  val pray: Registration[Action] = register(Pray)

  val love: Registration[Action] = register(Love)

}