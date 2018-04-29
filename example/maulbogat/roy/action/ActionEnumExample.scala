package maulbogat.roy.action

import maulbogat.roy.action.ActionEnumExample.Action.Action
import maulbogat.roy.enumeration.{InnerTypeEnumeration, NamedEnumeration, NamedValue}

object ActionEnumExample {

  abstract class Service() {
    def eat(): Unit

    def pray(): Unit

    def love(): Unit

    // BAD - remember to update this!
    def act(action: Action): Unit = {
      action match {
        case Action.Eat => eat()
        case Action.Pray => pray()
        case Action.Love => love()
        case _ => throw new IllegalArgumentException(s"unknown maulbogat.roy.action: $action")
      }
    }

    def getAction(name: String): Option[Action] = {
      Action.find(name)
    }
  }

  object Action extends NamedEnumeration with InnerTypeEnumeration {

    override protected type EnumVal = Action

    val Eat = Action("eat")
    val Pray = Action("pray")
    val Love = Action("love")

    case class Action(name: String) extends Val with NamedValue

  }

}