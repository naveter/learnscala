package cookbook

object Traits extends App {

  val hulk = new DavidBanner with Angry





}

//Recipe 8.1, How to use a Scala trait as an interface
trait Dog3 {
  def speak(whatToSay: String)
  def wagTail(enabled: Boolean)
}

//Recipe 8.2, How to use abstract and concrete fields in Scala traits
trait PizzaTrait {
  val maxNumToppings: Int
  var size  = 10
}
class Pizza extends PizzaTrait {
  override val maxNumToppings = 10  // 'override' is required
  size = 16                // 'var' and 'override' not needed
}

//Recipe 8.3, How to use a Scala trait like an abstract class
trait Pet {
  def speak { println("Yo") }   // concrete implementation
  def comeToMaster              // abstract method
}

class Dog4 extends Pet {
  // don't need to implement 'speak' if you don't need to
  def comeToMaster { ("I'm coming!") }
}

class Cat extends Pet {
  // override the speak method
  override def speak { ("meow") }
  def comeToMaster { ("That's not gonna happen.") }
}

//Recipe 8.5, How to limit which classes can use a trait by inheritance
// For instance, in the following example, Starship and StarfleetWarpCore
// both extend the common superclass StarfleetComponent,
// so the StarfleetWarpCore trait can be mixed into the Starship class:
class StarfleetComponent
trait StarfleetWarpCore extends StarfleetComponent
class Starship extends StarfleetComponent with StarfleetWarpCore

//Recipe 8.6, How to mark a Scala trait so it can only be subclassed by a certain type
trait StarfleetWarpCore2 {
  this: Starship2 =>
  // more code here ...
}
class Starship2
class Enterprise extends Starship2 with StarfleetWarpCore2

//Recipe 8.7, How to declare that a Scala trait can only be mixed into a type that has a specific method
trait WarpCore3 {
  this: {
    def ejectWarpCore(password: String): Boolean
    def startWarpCore: Unit
  } =>
}

class Starship3
class Enterprise3 extends Starship3 with WarpCore3 {
  def ejectWarpCore(password: String): Boolean = {
    if (password == "password") { println("core ejected"); true } else false
  }
  def startWarpCore { println("core started") }
}

//Recipe 8.8, How to dynamically add a Scala trait to an object instance
class DavidBanner
trait Angry {
  println("You won't like me ...")
}

//Recipe 8.9, How to extend a Java interface like a Scala trait






