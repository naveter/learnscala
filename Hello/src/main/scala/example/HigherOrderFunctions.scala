package example

/**
  * Created by bass on 07.09.17.
  */
object HigherOrderFunctions extends App {

  // ex1
  def values(fun: (Int) => Int, low: Int, high: Int) = for(v <- low to high) yield (v, fun(v))
  val result = values(x => x * x, -5, 5)
  println( result )

  // ex2
  val a = Array(1, 25, 47, 2, 54, 0, 6)
  println( a.reduceLeft[Int]((a,b) => if (a>b) a else b) )

  // ex3
  def fact(v: Int): Int = (1 to v).reduceLeft(_ * _)
  println( "fact(5):" + fact(5) )

  // ex4
  def fact2(v: Int): Int = (1 to v).foldLeft(1)(_ * _)
  println("fact2(0):" + fact2(0) )
  println("fact2(5):" + fact2(5) )

  // ex5
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.map(fun).reduceLeft((a,b) => if (a>b) a else b)
  }
  println( largest(x => 10 * x - x * x, 1 to 10) )

  // ex6
  def largest2(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.map(a => (fun(a),a)).reduceLeft( (a,b) => if (a._1>b._1) a else b )._2
  }
  println("largest2:" + largest2(x => 10 * x - x * x, 1 to 10))

  // ex7
  def adjustToPair(f: (Int, Int) => Int) = (t: (Int, Int)) => f(t._1, t._2)
  val pairs = (1 to 10) zip (11 to 20)
  println(pairs.map(adjustToPair(_ * _)(_)))

  // ex8
  val a3 = Array("Hello", "World")
  val b3 = Array(5, 4)
  println( a3.corresponds(b3)(_.length==_) )

  // ex9
  def corresponds2(a: Array[String], b: Array[Int], f: (String, Int) => Boolean): Boolean = {
    (a zip b).map(t => f(t._1, t._2)).reduce(_ & _)
  }
  println( corresponds2(a3, b3, (x, y) => x.length==y) )

  // ex10
  def unless(condition: => Boolean)(block: => Unit) {
    if (!condition) block
  }
  val pos = 10
  unless(pos == 7) { println("ok") }







}
