package example


/**
  * Created by bass on 01.09.17.
  */
object Traits extends App {

  // ex1
  val egg = new java.awt.geom.Ellipse2D.Double(5,10,20,30) with RectangleLike
  egg.translate(10, 10)
  println("egg.getX:" + egg.getX + " egg.getY:" + egg.getY)
  egg.grow(10, 20)
  println("egg.getWidth:" + egg.getWidth + " egg.getHeight:" + egg.getHeight)

  // ex2
  val op1 = new OrderedPoint(10, 5)
  val op2 = new OrderedPoint(10, 6)













}

// ex1
trait RectangleLike {
  this: java.awt.geom.Ellipse2D =>
  def translate(dx: Int, dy: Int) {
    setFrame(getX + dx, getY + dy, getWidth, getHeight)
  }
  def grow(dw: Int, dh: Int) {
    setFrame(getX, getY, getWidth + dw, getHeight + dh)
  }
}

// ex2
class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {
  def compare(that: Point): Int = {
    ((this.x - that.x).signum, (this.y - that.y).signum) match {
      case (-1,_) | (0,-1) => -1
      case (0, 0) => 0
      case _ => 1
    }
  }
}




