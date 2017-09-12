package example

/**
  * Created by bass on 12.09.17.
  */
object PatternMatching extends App {

  // ex2
  def swap(p: (Int,Int)): (Int, Int) = p match { case (x, y) => (y, x) }
  println( swap(1, 2).toString())

  // ex3
  def swap(a: Array[Int]) = a match { case Array(a, b, end @ _*) => Array(b, a) ++ end }
  println( swap(Array(1,2,3,4)).deep.mkString(", ") )

  // ex4
  abstract class Item
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item
  case class Multiple(quantity: Int, items: Item*) extends Item
  val m = Multiple(10,
    Bundle("DVD pack", 2.0,
      Article("Dr No", 4.00),
      Article("Goldfinger", 6.00)
    ),
    Multiple(2,
      Article("Thunderbolt", 7.00)
    )
  )
  def price(it: Item): Double = it match {
    case Multiple(q, its @ _*) => q * its.map(price _).sum
    case Bundle(_, d, its @ _*) => its.map(price _).sum - d
    case Article(_, p) => p
  }
  println( price(m) )

  // ex5
  val l = List(List(3, 8), 2, List(5))
  def leafSum(l: List[Any]): Int = l.map(_ match {
    case l: List[Any] => leafSum(l)
    case x: Int => x
    case _ => 0
  }).sum
  println( leafSum(l) )









}






