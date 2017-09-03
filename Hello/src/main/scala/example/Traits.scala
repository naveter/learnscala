package example

import java.beans.{PropertyChangeSupport, PropertyChangeListener, PropertyChangeEvent}
import java.io._


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

  // ex4
  val JohnSmith = new Person("John Smith")
  println("JohnSmith.name: " + JohnSmith.name)

  // ex7
  val r = new Roscoe("mapple").plug

  // ex8
  val b = new FileInputStream("resourse/tinyFile.txt") with Buffering
  val ab = new Array[Byte](100)
  b.read(ab)
  ab.foreach(a => print(a.toChar))
  println("")

  // ex9
  val b2 = new FileInputStream("resourse/tinyFile.txt") with Buffering2
  Iterator.continually(b2.read()).takeWhile(_ != -1).map(_.toChar).mkString

  // ex10
  val bi =  new IterableInputStream(new FileInputStream("resourse/tinyFile.txt")).iterator
  val r3 = bi.map(_.toChar).mkString
  println(r3)










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


// ex4
trait Logger {
  def log(msg: String) {}
}

trait PrinterLogger extends Logger {
  override def log(msg: String) {
    println(msg)
  }
}

trait CryptoLogger extends Logger {
  val key=3
  override def log(msg: String) {
    val ceasarMsg = for(c <- msg.toUpperCase) yield c match {
      case a if 'A'<=a && a<='Z' => applyKey(a, 'A', 26)
      case a if '0'<=a && a<='9' => applyKey(a, '0', 10)
      case _ => c
    }
    println("CryptoLogger.log")
    super.log(ceasarMsg)
  }
  private def applyKey(c: Char, r: Char, l: Int): Char = {
    ((c - r + key)%l + r).toChar
  }
}

class Person(private val _name: String) extends {override val key=9} with PrinterLogger with CryptoLogger {
  def name = {log(_name); _name}
}


// ex7
trait Woody {
  val wood: String;
  def play {
    println("Groovy")
  }
}

trait Fretless {
  val inlined = false
  def plug
}

class Roscoe(val wood: String) extends Woody with Fretless {
  def plug {
    println("Bass is plugged")
  }
}

// ex8
trait Buffering {
  this: FileInputStream =>
  val b = new BufferedInputStream(this)
  override def read(ab: Array[Byte]): Int = {
    b.read(ab)
  }
}


// ex9
trait Buffering2 extends Logger {
  this: FileInputStream =>
  val b = new BufferedInputStream(this)
  override def read(): Int = {
    log("Diff Available : " + (b.available - this.available))
    b.read()
  }
  override def log(msg: String) {
    println(msg)
  }
}


// ex10
class IterableInputStream(is: InputStream) extends InputStream with Iterable[Byte] {
  def iterator = new Iterator[Byte] {
    def hasNext = is.available > 0
    def next() = is.read.toByte
  }
  def read = is.read
}


















