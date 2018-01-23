package cookbook

object ClassesAndProperties extends App {

//  val a = Person()         // corresponds to apply()
//  val b = Person("Pam")    // corresponds to apply(name: String)
//  val c = Person("William Shatner", 82)
//  println(a);   println(b) ;  println(c);

//  val brain = Brain.getInstance
//  println(brain)

//  val s = new Socket(timeout=5000)

//  val p = new Person2("Jonathan")
//  p.name = "Jony"    // setter
//  println(p.name)    // getter

//  val p = Person3("alvinalexander", "secret")
//  p.address = Some(Address("Talkeetna", "AK", "99676"))








}

//Recipe 4.3, How to define auxiliary class constructors
case class Person (var name: String, var age: Int)
object Person {
  def apply() = new Person("<no name>", 0)
  def apply(name: String) = new Person(name, 0)
}

//Recipe 4.4, How to define a private primary constructor in Scala
class Brain private {
  override def toString = "This is the brain."
}

object Brain {
  val brain = new Brain
  def getInstance = brain
}

//Recipe 4.5, How to provide default values for Scala constructor parameters
class Socket (val timeout: Int = 10000)

class Socket2(val timeout: Int) {
  def this() = this(10000)
  override def toString = s"timeout: $timeout"
}

//Recipe 4.6, How to override default accessors and mutators in Scala classes
class Person2(private var _name: String) {
  def name = _name                             // accessor
  def name_=(aName: String) { _name = aName }  // mutator
}

//Recipe 4.7, How to prevent getter and setter methods from being generated in Scala classes
class Stock {
  // getter and setter methods are generated
  var delayedPrice: Double = _

  // keep this field hidden from other classes
  private var currentPrice: Double = _
}
class Stock2 {
  // a private[this] var is object-private, and can only be seen
  // by the current instance
  private[this] var price: Double = _
  def setPrice(p: Double) { price = p }
  // error: this method won't compile because price is now object-private
//  def isHigher(that: Stock): Boolean = this.price > that.price
}

//Recipe 4.8, How to assign a Scala class field to a block or function
class Foo {
  // will be invoke when called
  lazy val text = {
    var lines = ""
    try {
      lines = io.Source.fromFile("/etc/passwd").getLines.mkString
    } catch {
      case e: Exception => lines = "Error happened"
    }
    lines
  }
}

//Recipe 4.9, How to set uninitialize var field types in Scala
case class Person3(var username: String, var password: String) {
  var age = 0
  var firstName = ""
  var lastName = ""
  var address = None: Option[Address]
}
case class Address(city: String, state: String, zip: String)

//Recipe 4.10, How to handle constructor parameters when extending a Scala class
class Person4 (var name: String, var address: Address) {
  override def toString = if (address == null) name else s"$name @ $address"
}
// leave the var declaration off of those fields, but age is new, so declare it as a var
class Employee (name: String, address: Address, var age: Int)
  extends Person4 (name, address) {
  // rest of the class
}

//Recipe 4.13, How to define properties in an abstract base class or trait
abstract class Animal {
  val greeting = { println("Animal"); "Hello" }
}
class Dog extends Animal {
  override val greeting = { println("Dog"); "Woof" }
}

trait Animal2 {
  val greeting: Option[String]
  var age: Option[Int] = None
  override def toString = s"I say $greeting, and I'm $age years old."
}
class Dog2 extends Animal2 {
  val greeting = Some("Woof")
  age = Some(2)
}

//Recipe 4.14, How to generate boilerplate code with Scala case classes
case class Person5(var name: String, var age: Int)
//scalac Person5.scala
//javap Person5
/*Compiled from "Person5.scala"
public class Person5 extends java.lang.Object implements scala.ScalaObject,scala.Product,scala.Serializable{
  public static final scala.Function1 tupled();
  public static final scala.Function1 curry();
  public static final scala.Function1 curried();
  public scala.collection.Iterator productIterator();
  public scala.collection.Iterator productElements();
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public int age();
  public void age_$eq(int);
  public Person copy(java.lang.String, int);
  public int copy$default$2();
  public java.lang.String copy$default$1();
  public int hashCode();
  public java.lang.String toString();
  public boolean equals(java.lang.Object);
  public java.lang.String productPrefix();
  public int productArity();
  public java.lang.Object productElement(int);
  public boolean canEqual(java.lang.Object);
  public Person(java.lang.String, int);
}*/

// Recipe 4.15, How to define an equals method (object equality) in Scala
class Employee5(name: String, age: Int, var role: String) extends Person(name, age) {
  override def canEqual(a: Any) = a.isInstanceOf[Employee5]
  override def equals(that: Any): Boolean =
    that match {
      case that: Employee5 => that.canEqual(this) && this.hashCode == that.hashCode
      case _ => false
    }
  override def hashCode: Int = {
    val ourHash = if (role == null) 0 else role.hashCode
    super.hashCode + ourHash
  }
}




