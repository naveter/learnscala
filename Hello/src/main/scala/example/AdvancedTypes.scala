package example

import scala.collection.mutable.ArrayBuffer

object AdvancedTypes extends App {

  // ex1
  val bugsy = new Bug
  bugsy.move(4).show().move(6).show().turn().move(5).show()

  // ex2
  object Show
  object Then
  object Around

  val show = Show
  val then = Then
  val around = Around

  trait FluentBug {
    this: Bug =>
    def and(obj: Show.type): this.type = { this.show() }
    def and(obj: Then.type): this.type = { this }
    def turn(obj: Around.type): this.type = { this.turn() }
  }

  val bugsy2 = new Bug() with FluentBug
  bugsy2 move 4 and show and then move 6 and show turn around move 5 and show

  // ex3
  val myBook = new Document
  myBook set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
  println(myBook.title)
  println(myBook.author)

  // ex4
  val NetworkA = new Network
  val NetworkB = new Network

  val Basile = NetworkA.join("Basile")
  val John = NetworkA.join("John")
  val Alfred = NetworkB.join("Alfred")

  println(Basile.equals(Alfred))
  println(Basile.equals(John))

  // ex5
  def processA[ T <: n.Member forSome {val n: Network} ](m1: T, m2: T) = (m1, m2)
  type NetworkMember = n.Member forSome {val n: Network}
  def processB(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
  processA(Basile, John)

  // ex7
  val myDoor = new Door
  new Closable().add(myDoor)

  // ex8





}

// ex1
class Bug {

  var position = 0
  var direction = 1

  def move(n: Int): this.type = {
    position += n * direction
    this
  }

  def turn(): this.type = {
    direction *= -1
    this
  }

  def show(): this.type = {
    println(" " * position + "☻" )
    this
  }
}

// ex3
object Title
object Author
class Document {
  var title: String = _
  var author: String = _
  var useNextArgAs: Any = null

  def set(obj: Title.type) = {
    useNextArgAs = obj
    this
  }
  def set(obj: Author.type) = {
    useNextArgAs = obj
    this
  }
  def to(s: String) = {
    useNextArgAs match {
      case Title => title = s
      case Author => author = s
    }
    this
  }
}

// ex4
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]

    def equals(that: Member):Boolean = true
  }
  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

// ex7
class Closable[T <: {def close(): Unit}] {

  def add(obj: T) {
    process(obj)
  }

  def process(obj: T) {
    try {
      println("Processing object...")
    } finally {
      obj.close
    }
  }
}
class Door {
  def close() {println("Door is closed")}
}




