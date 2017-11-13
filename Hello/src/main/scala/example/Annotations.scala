package example

import scala.annotation.varargs
import scala.io.Source
import java.io.IOException

object Annotations extends App {

  // ex5
  val ex05 = new Ex05();
  println(ex05.fileToString("/ch09_ex07.txt"))

  // ex6
  @volatile var status = false

  new Thread {
    override def run() {
      Thread.sleep(200)
      status = true
      println("## Status field to true")
    }
  }.start()

  new Thread {
    override def run() {
      while (!status) {
        println("Status field is false")
        Thread.sleep(100)
      }
      println("Status field is true")
    }
  }.start()






}

// ex2
@deprecated(message = "Use * instead", since = "1.0")
class Multiply(val x: Int, val y : Int) {

  @deprecated(message = "Use * instead", since = "1.0")
  val result = x * y

  @deprecated(message = "Use * instead", since = "1.0")
  def multiply() = x * y
}

// ex3
class Ex04 {
  @varargs def sum(x: Int*): Int = x.sum
}

// ex5

class Ex05 {
  @throws(classOf[IOException]) def fileToString(file: String): String = {
    val url = getClass.getResource(file)

    if (url == null) throw new IOException("File not found")
    else Source.fromURL(url).mkString
  }
}