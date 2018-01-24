package cookbook

object Methods extends App {
//  val child = new Child

//  val conn = new Connection
//  conn.makeConnection(timeout=10000)
//  conn.makeConnection(protocol="https")
//  conn.makeConnection(timeout=10000, protocol="https")

//  val (symbol, currentPrice, bidPrice) = StockInfo.getStockInfo

  //Recipe 5.7, How to create methods that take variable-arguments (varargs) fields
//  def printAll(strings: String*) {
//    strings.foreach(println)
//  }
//  printAll()
//  printAll("foo")
//  printAll("foo", "bar")
//  printAll("foo", "bar", "baz")

  //Recipe 5.8, How to declare that a Scala method can throw an exception
//  @throws(classOf[Exception])
//  def play {  }

  val employee = new Person6
  employee.setFirstName("Al").setLastName("Alexander")
  println(employee)







}

//Recipe 5.1, How to control method scope in Scala (private, package, more)
class Test {
  private[this] def isFoo = true
  private def heartBeat {}
  protected def breathe {}
  private[cookbook] def doX {}
}

//Recipe 5.2, How to call a method on a superclass in Scala
trait Human {
  def hello = "the Human trait"
  def printHello = {
    println(hello)
  }
}
class Child extends Human  {
  override def hello = "Child"

  printHello

  def printSuper = super.hello
  def printHuman = super[Human].hello
}

//Recipe 5.3, How to set default values for Scala method parameters
class Connection {
  def makeConnection(timeout: Int = 5000, protocol:String = "http") {
    println("timeout = %d, protocol = %s".format(timeout, protocol))
  }
}

//Recipe 5.5, How to define Scala methods that returns multiple items (tuples)
object StockInfo{
  def getStockInfo = {
    ("NFLX", 100.00, 101.00) // this is a Tuple3
  }
}

//Recipe 5.9, How to support a fluent style of programming in Scala
class Person6 {
  protected var fname = ""
  protected var lname = ""
  def setFirstName(firstName: String): this.type = {
    fname = firstName
    this
  }
  def setLastName(lastName: String): this.type = {
    lname = lastName
    this
  }
}



