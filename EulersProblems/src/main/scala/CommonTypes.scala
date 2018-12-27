object CommonTypes {
  sealed trait Bool {
    type If[T <: Up, F <: Up, Up] <: Up
    type And[A <: Bool] <: Bool
    type Or[A <: Bool] <: Bool
    type Not <: Bool
  }
  sealed trait True extends Bool {
    type If[T <: Up, F <: Up, Up] = T
    type And[A <: Bool] = A
    type Or[A <: Bool] = True
    type Not = False
  }
  sealed trait False extends Bool {
    type If[T <: Up, F <: Up, Up] = F
    type And[A <: Bool] = False
    type Or[A <: Bool] = A
    type Not = True
  }
}