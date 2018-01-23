package cookbook


// http://scalacookbook.com/
object ControlStructures extends App {

  // Recipe 3.1, How to loop over a collection with for and foreach (and how a for loop is translated)
//  val a = Array("apple", "banana", "orange")
//  val newArray = for (e <- a) yield e.toUpperCase
//  println(newArray.mkString(", "))
//  for (i <- 0 until a.length) println(s"$i is ${a(i)}")
//  for ((e, count) <- a.zipWithIndex) println(s"$count is $e")
//  for (i <- 1 to 3) println(i)
//  for (i <- 1 to 10 if i < 4) println(i)
//  val names = Map("fname" -> "Robert", "lname" -> "Goren")
//  for ((k,v) <- names) println(s"key: $k, value: $v")
//  a.foreach(println)
//  a.foreach(e => println(e.toUpperCase))
//  a.foreach { e =>
//       val s = e.toUpperCase
//       println(s)
//  }
//  // scalac -Xprint:parse ControlStructures.scala
//  1.to(10).foreach(((i) => println(i)))

  // Recipe 3.2, How to use Scala for loops with multiple counters
//  for (i <- 1 to 2; j <- 1 to 2) println(s"i = $i, j = $j")

  //Recipe 3.3, How to use a 'for' loop with embedded 'if' statements (guards)
//  for {
//    i <- 1 to 10
//    if i > 3
//    if i < 6
//    if i % 2 == 0
//  } println(i)

  //Recipe 3.4, How to create a "for comprehension" (for/yield loop)
//  val names = Array("chris", "ed", "maurice")
//  val capNames = for (e <- names) yield e.capitalize
//  val fruits = "apple" :: "banana" :: "orange" :: Nil
//  val out = for (e <- fruits) yield e.toUpperCase

  //Recipe 3.5, Scala: How to use break and continue in for loops (and while loops)
  import util.control.Breaks._
//  breakable {
//    for (i <- 1 to 10) {
//      println(i)
//      if (i > 4) break  // break out of the for loop
//    }
//  }
//  for (x <- 1.to(10)) {
//    breakable {
//      if (Array(1,2,3,4).contains(x) ) break
//      println(x)
//    }
//  }

  //Recipe 3.6, How to use a Scala if/then statement like a ternary operator
//  val a = 10
//  val absValue = if (a < 0) -a else a

  //Recipe 3.7, How to use a Scala match expression like a switch statement
//  val i = 2
//  val month = i match {
//    case 1  => "January"
//    case 2  => "February"
//    case 3  => "March"
//    case _  => "Invalid month"  // the default, catch-all
//  }
//  println(month)
//  import scala.annotation.switch
//  println( (i: @switch) match {
//    case 1  => "One"
//    case 2  => "Two"
//    case _  => "Other"
//  })
//  // disassemble : javap -c SwitchDemo

  //Recipe 3.8, How to match multiple conditions with one case statement
//  val i = 5
//  i match {
//    case 1 | 3 | 5 | 7 | 9 => println("odd")
//    case 2 | 4 | 6 | 8 | 10 => println("even")
//  }

  //Recipe 3.9, How to assign the result of a match expression to a variable
//  def isTrue(a: Any) = a match {
//    case 0 | "" => false
//    case _ => true
//  }

  // Recipe 3.10, How to access the value of the default case in a Scala match expression
//  2 match {
//    case 0 => println("1")
//    case 1 => println("2")
//    case default => println("You gave me: " + default)
//  }

  //Recipe 3.11, How to use pattern matching in Scala match expressions
//  case class Person(firstName: String, lastName: String)
//  def matchType(x: Any): String = x match {
//    //case x: List(1, _*) => s"$x"          // doesn't compile
//    case x @ List(1, _*) => s"$x"           // works; prints the list
//    //case Some(_) => "got a Some"          // works, but can't access the Some
//    //case Some(x) => s"$x"                 // works, returns "foo"
//    case x @ Some(_) => s"$x"               // works, returns "Some(foo)"
//    case p @ Person(first, "Doe") => s"$p"  // works, returns "Person(John,Doe)"
//  }
//  println(matchType(List(1,2,3)))             // prints "List(1, 2, 3)"
//  println(matchType(Some("foo")))             // prints "Some(foo)"
//  println(matchType(Person("John", "Doe")))   // prints "Person(John,Doe)"

  //Recipe 3.12, How to use case classes in Scala match expressions
//  trait Animal
//  case class Dog(name: String) extends Animal
//  case class Cat(name: String) extends Animal
//  case object Woodpecker extends Animal
//  def determineType(x: Animal): String = x match {
//    case Dog(moniker) => "Got a Dog, name = " + moniker
//    case _:Cat => "Got a Cat (ignoring the name)"
//    case Woodpecker => "That was a Woodpecker"
//    case _ => "That was something else"
//  }
//  println(determineType(new Dog("Rocky")))
//  println(determineType(new Cat("Rusty the Cat")))
//  println(determineType(Woodpecker))

  //Recipe 3.13, How to add 'if' expressions (guards) to case statements
//  1 match {
//    case x if x == 1 => println("one, a lonely number")
//    case x if (x == 2 || x == 3) => println(x)
//    case _ => println("some other value")
//  }

  //Recipe 3.15, How to use Lists in Scala match expressions
//  val fruits = "Apples" :: "Bananas" :: "Oranges" :: Nil
//  def listToString(list: List[String]): String = list match {
//    case s :: rest => s + " " + listToString(rest)
//    case Nil => ""
//  }
//  println( listToString(fruits) )

  //Recipe 3.16, How to match one or more exceptions with try/catch in Scala
//  @throws(classOf[NumberFormatException])
//  def toInt(s: String): Option[Int] =
//    try {
//      Some(s.toInt)
//    } catch {
//      case e: NumberFormatException => throw e
//    }

  //Recipe 3.17, How to declare a variable (var) before using it in try/catch/finally
//  import java.io._
//  var in = None: Option[FileInputStream]
//  var out = None: Option[FileOutputStream]
//  try {
//    in = Some(new FileInputStream("/tmp/Test.class"))
//    out = Some(new FileOutputStream("/tmp/Test.class.copy"))
//  } catch {
//    case e: IOException => e.printStackTrace
//  } finally {
//    println("entered finally ...")
//    if (in.isDefined) in.get.close
//    if (out.isDefined) out.get.close
//  }

  //Recipe 3.18, How to create your own control structures in Scala
  def doubleif(test1: => Boolean)(test2: => Boolean)(codeBlock: => Unit) {
    if (test1 && test2) {
      codeBlock
    }
  }
  val age = 19
  val numAccidents = 0
  doubleif(age > 18)(numAccidents == 0) { println("Discount!") }









}