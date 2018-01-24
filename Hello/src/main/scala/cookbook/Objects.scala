package cookbook

object Objects extends App {

  // Recipe 6.1, How to cast an object from one type to another (object casting)
//  val cm = new ConfigurationManager("config.xml")
//  val recognizer = cm.lookup("recognizer").asInstanceOf[Recognizer]

  val p7 = Person7("Fred Flinstone")
  val p8 = Person8("Fred Flinstone")










}

//Recipe 6.4, How to launch a Scala application with an object
object Hello2 {
  def main(args: Array[String]) {
    println("Hello, world")
  }
}

//Recipe 6.5, How to implement the Singleton Pattern with a Scala object
object CashRegister {
  def open { println("opened") }
  def close { println("closed") }
}

//Recipe 6.7, How to put common code in Scala package objects
package object model {

  // field
  val MAGIC_NUM = 42

  // method
  def echo(a: Any) { println(a) }

  // enumeration
  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }

  // type definition
  type MutableMap[K, V] = scala.collection.mutable.Map[K, V]
  val MutableMap = scala.collection.mutable.Map

}

//Recipe 6.8, How to create object instances without using the 'new' keyword
class Person7 {
  var name: String = _
}
object Person7 {
  def apply() = {
    var p = new Person7()
    p.name = "Fred Flinsone"
    p
  }
  def apply(name: String): Person7 = {
    var p = new Person7
    p.name = name
    p
  }
}
case class Person8 (var name: String)





