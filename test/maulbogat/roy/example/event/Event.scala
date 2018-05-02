package maulbogat.roy.example.event

import maulbogat.roy.registry.{NamedValue, Registered}

sealed trait Event extends Registered[Event] with NamedValue

sealed trait UserEvent extends Event

sealed trait ProductEvent extends Event

case object UserCreatedEvent extends UserEvent {
  override val name: String = "user.created"

  override val registration: Registration = () => EventRegistry.userCreated
}

case object UserDeletedEvent extends UserEvent {
  override val name: String = "user.deleted"

  override val registration: Registration = () => EventRegistry.userDeleted
}

case object ProductCreatedEvent extends ProductEvent {
  override val name: String = "product.created"

  override val registration: Registration = () => EventRegistry.productCreated
}

case object ProductDeletedEvent extends ProductEvent {
  override val name: String = "product.deleted"

  override val registration: Registration = () => EventRegistry.productDeleted
}