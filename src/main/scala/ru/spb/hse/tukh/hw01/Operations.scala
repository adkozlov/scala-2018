package ru.spb.hse.tukh.hw01

trait Operations[T] extends Enumeration {
  protected case class Operation(label: String, function: T) extends super.Val {
    def getLabel: String = label
    def getFunction: T = function
  }

  protected val defaultValue: T

  protected implicit def valueToOperation(x: Value): Operation = x.asInstanceOf[Operation]

  def getOperation(label: String): T = {
    values.find(value => value.getLabel == label)
      .map(_.getFunction).getOrElse(defaultValue)
  }
}
