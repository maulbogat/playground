package maulbogat.roy.example.action

abstract class ActionService() {
  def eat(): Unit

  def pray(): Unit

  def love(): Unit

  // exhaustive matching
  def act(action: Action): Unit = {
    action match {
      case Eat => eat()
      case Pray => pray()
      case Love => love()
    }
  }

  def getAction(name: String): Option[Action] = {
    ActionRegistry.getByName(name)
  }
}