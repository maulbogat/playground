package maulbogat.roy.action

import maulbogat.roy.action.ActionRegistryExample.ActionRegistry
import maulbogat.roy.enumeration.registry.{NamedRegistry, Registered, Registration}

object ActionRegistryExample {

  sealed trait Action extends Registered[Action]

  abstract class Service() {
    def eat(): Unit

    def pray(): Unit

    def love(): Unit

    // GOOD - exhaustive matching
    def act(action: Action): Unit = {
      action match {
        case Eat => eat()
        case Pray => pray()
        case Love => love()
      }
    }

    def getAction(name: String): Option[Action] = {
      ActionRegistry.findRegistered(name)
    }
  }

  case object Eat extends Action {
    override val register: Register = () => ActionRegistry.eat
  }

  case object Pray extends Action {
    override val register: Register = () => ActionRegistry.pray
  }

  case object Love extends Action {
    override val register: Register = () => ActionRegistry.love
  }

  object ActionRegistry extends NamedRegistry[Action] {
    val eat: Registration[Action] = register("eat", Eat)
    val pray: Registration[Action] = register("pray", Pray)
    val love: Registration[Action] = register("love", Love)
  }

}

object ActionExample extends App {

  // OUTPUT: List(Eat, Pray, Love)
  println(ActionRegistry.getAllRegistered)

}