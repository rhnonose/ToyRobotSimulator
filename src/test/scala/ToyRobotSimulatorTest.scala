import org.scalatest._
import main.scala._

class ToyRobotSimulatorTest extends FlatSpec with Matchers {

  "Robot" should "report his current location and direction" in {
    val robot = new Robot(0,0,Direction.NORTH)
    robot.report() should be ("0,0,NORTH")
  }

}