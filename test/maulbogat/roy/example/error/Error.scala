package maulbogat.roy.example.error

import maulbogat.roy.registry.named.NamedRegistered
import maulbogat.roy.registry.named.NamedRegistered.NamedRegistration

sealed trait Error extends NamedRegistered[Error]

sealed trait UserError extends Error

case object UserCreatedError extends UserError {
  override val registration: NamedRegistration[Error] = () => ErrorRegistry.userCreated
}

case object UserDeletedError extends UserError {
  override val registration: NamedRegistration[Error] = () => ErrorRegistry.userDeleted
}

sealed trait ProductError extends Error

case object ProductCreatedError extends ProductError {
  override val registration: NamedRegistration[Error] = () => ErrorRegistry.productCreated
}

case object ProductDeletedError extends ProductError {
  override val registration: NamedRegistration[Error] = () => ErrorRegistry.productDeleted
}