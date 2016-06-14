package main.scala

object Direction extends Enumeration {
  type Direction = Value
  val NORTH, SOUTH, EAST, WEST = Value
}
import Direction._

class Robot(var x: Integer, var y: Integer, var facing: Direction) {
  def report() = x.toString + "," + y.toString + "," + facing
}

class Tabletop(val x: Integer, val y: Integer) {}