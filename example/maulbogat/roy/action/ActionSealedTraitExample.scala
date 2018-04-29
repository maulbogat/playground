package maulbogat.roy.action

object ActionSealedTraitExample {

  sealed trait Action {
    def name: String
  }

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
      Action.all.find(_.name == name)
    }
  }

  case object Eat extends Action {
    override val name: String = "eat"
  }

  case object Pray extends Action {
    override val name: String = "pray"
  }

  case object Love extends Action {
    override val name: String = "love"
  }

  object Action {
    // BAD - remember to update this!
    val all: List[Action] = List(Eat, Pray, Love)
  }

}