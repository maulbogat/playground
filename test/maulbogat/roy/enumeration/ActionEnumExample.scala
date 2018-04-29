package maulbogat.roy.enumeration

import maulbogat.roy.enumeration.Actions.Action
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpec, MustMatchers, OneInstancePerTest}
import play.api.test.{DefaultAwaitTimeout, FutureAwaits}

class ActionEnumExample extends FunSpec
  with MustMatchers
  with DefaultAwaitTimeout
  with MockitoSugar
  with OneInstancePerTest
  with FutureAwaits {

  abstract class Service() {

    def eat(): Unit

    def pray(): Unit

    def love(): Unit

    // BAD - remember to update this!
    def act(action: Action): Unit = {
      action match {
        case Actions.Eat => eat()
        case Actions.Pray => pray()
        case Actions.Love => love()
        case _ => throw new IllegalArgumentException(s"unknown action: $action")
      }
    }

    def getAction(name: String): Option[Action] = {
      Actions.find(name)
    }
  }

  describe("named enumeration example") {
    it("get all values") {
      Actions.getAll mustBe List(Actions.Eat, Actions.Pray, Actions.Love)
    }
  }

}

object Actions extends NamedEnumeration {

  override protected type EnumVal = Action

  val Eat = Action("eat")
  val Pray = Action("pray")
  val Love = Action("love")

  case class Action(name: String) extends Val with NamedValue

}