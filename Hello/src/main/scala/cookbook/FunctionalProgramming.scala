package cookbook

object FunctionalProgramming extends App {

//  Recipe 9.1, How to use function literals (anonymous functions) in Scala
  val x = List.range(1, 10)
  val evens = x.filter((i: Int) => i % 2 == 0)
  val evens1 = x.filter(i => i % 2 == 0)
  val evens2 = x.filter(_ % 2 == 0)

//  Recipe 9.2, How to use functions as variables (values) in Scala
  val double = (i: Int) => { i * 2 }
  double(2)
  val list = List.range(1, 5)
  list.map(double)

  // implicit approach
  val add = (x: Int, y: Int) => { x + y }
  val add1 = (x: Int, y: Int) => x + y

  // explicit approach
  val add2: (Int, Int) => Int = (x,y) => { x + y }
  val add3: (Int, Int) => Int = (x,y) => x + y

  def modMethod(i: Int) = i % 2 == 0
  def modMethod2(i: Int) = { i % 2 == 0 }
  def modMethod3(i: Int): Boolean = i % 2 == 0
  def modMethod4(i: Int): Boolean = { i % 2 == 0 }

  val p = scala.math.pow(_, _)
  p(scala.math.E, 2)

  //  Recipe 9.3, How to define a method that accepts a simple function parameter
  def executeFunction(callback:() => Unit) {
    callback()
  }
  val sayHello = () => { println("Hello") }
  executeFunction(sayHello)

  //  Recipe 9.4, How to define Scala methods that take complex functions as parameters
  def exec(callback: Int => Unit) {
    // invoke the function we were given, giving it an Int parameter
    callback(1)
  }
  val plusOne = (i: Int) => { println(i+1) }
  exec(plusOne)

  val sum = (x: Int, y: Int) => x + y
  val multiply = (x: Int, y: Int) =>  x * y

  // 1 - define the method
  def exec2(callback: (Any, Any) => Unit, x: Any, y: Any) {
    callback(x, y)
  }

  // 2 - define a function to pass in
  val printTwoThings =(a: Any, b: Any) => {
    println(a)
    println(b)
  }

  // 3 - pass the function and some parameters to the method
  case class Person(name: String)
  exec2(printTwoThings, "Hello", Person("Dave"))

  //  Recipe 9.6, How to use partially applied functions in Scala
  val sum2 = (a: Int, b: Int, c: Int) => a + b + c
  val fder = sum2(1, 2, _: Int)
  fder(3)

  // Recipe 9.7, How to create a method that returns a function in Scala
  def saySomething(prefix: String) = (s: String) => {
    prefix + " " + s
  }
  val sayHello2 = saySomething("Hello")

  def greeting(language: String) = (name: String) => {
    val english = () => "Hello, " + name
    val spanish = () => "Buenos dias, " + name
    language match {
      case "english" => println("returning 'english' function")
        english()
      case "spanish" => println("returning 'spanish' function")
        spanish()
    }
  }

  //  Recipe 9.8, How to create and use partial functions in Scala
  val divide = new PartialFunction[Int, Int] {
    def apply(x: Int) = 42 / x
    def isDefinedAt(x: Int) = x != 0
  }
  if (divide.isDefinedAt(1)) divide(1)

  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }

  // converts 1 to "one", etc., up to 5
  val convert1to5 = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three", "four", "five")
    def apply(i: Int) = nums(i-1)
    def isDefinedAt(i: Int) = i > 0 && i < 6
  }

  //  Recipe 9.9, A real-world functional programming example in Scala







}











