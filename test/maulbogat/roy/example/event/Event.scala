package maulbogat.roy.example.event

import maulbogat.roy.registry.Registered
import maulbogat.roy.registry.Registered.Registration
import maulbogat.roy.registry.named.NamedValue

sealed trait Event extends Registered[Event] with NamedValue

sealed trait UserEvent extends Event

case object UserCreatedEvent extends UserEvent {
  override val name: String = "user.created"

  override val registration: Registration[Event] = () => EventRegistry.userCreated
}

case object UserDeletedEvent extends UserEvent {
  override val name: String = "user.deleted"

  override val registration: Registration[Event] = () => EventRegistry.userDeleted
}

sealed trait ProductEvent extends Event

case object ProductCreatedEvent extends ProductEvent {
  override val name: String = "product.created"

  override val registration: Registration[Event] = () => EventRegistry.productCreated
}

case object ProductDeletedEvent extends ProductEvent {
  override val name: String = "product.deleted"

  override val registration: Registration[Event] = () => EventRegistry.productDeleted
}