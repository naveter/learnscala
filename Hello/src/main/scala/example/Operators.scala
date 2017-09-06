package example

import scala.collection.mutable.ArrayBuffer

/**
  * Created by bass on 06.09.17.
  */
object Operators extends App{

  // ex3
  val f1 = new Fraction(4,-5)
  val f2 = new Fraction(-8,3)
  println( (f1 / f2).toString )

  // ex4
  println( Money(1, 75) + Money(0, 50) toFloat )

  // ex5
  val result = Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"
  println(result.toString)

  // ex6
  val a = new ASCIIArt(""" /\_/\
( ' ' )
(  -  )
 | | |
(__|__)""")
  val b = new ASCIIArt(""" -----
/ Hello \
< Scala |
\ Coder /
-----""")
  val c = new ASCIIArt(""" -----
/ Hello \
< Scala |
\ Coder /
-----""")
  println(a/c + b)

  // ex7
  val b2 = new BitSequence("010101010101010101010101010101010101010101010101010101010101110")
  b2(0) = true
  println( b2.toString )

  // ex8
  val m = new Matrix(Array(Array(1.0,2.0,3.0), Array(4.0,5.0,6.0)))
  val n = new Matrix(Array(Array(1.0,2.0,3.0), Array(4.0,5.0,6.0)))
  println("New Matrix: " + (m*2 + n) * m )

  // ex9
  val RichFile(path, name, extension) = "/home/cay/readme.txt"
  println(path + " " + name + " " + extension)

  // ex10
  val RichFile2(a3 @ _*) = "/home/cay/readme.txt"
  println(a3)


}

// ex3
class Fraction(_n: Int, _d: Int) {
  val signum = _n.signum*_d.signum
  val g = gcd(_n.abs, _d.abs)
  val n = _n.abs*signum/g
  val d = _d.abs/g
  def /(that: Fraction) = new Fraction(n*that.d, d*that.n)
  def *(that: Fraction) = new Fraction(n*that.n, d*that.d)
  def +(that: Fraction) = new Fraction(n*that.d+that.n*d, d*that.d)
  def -(that: Fraction) = new Fraction(n*that.d-that.n*d, d*that.d)
  private def gcd(a: Int, b: Int): Int = {
    if (b==0) a else gcd(b, a%b)
  }
  override def toString = n + "/" + d
}

// ex4
class Money(d: Int, c: Int) {
  def +(that: Money) = Money(toFloat + that.toFloat)
  def -(that: Money) = Money(toFloat - that.toFloat)
  def ==(that: Money) = toFloat==that.toFloat
  def <(that: Money) = toFloat<that.toFloat
  def toFloat = (d+"."+c).toFloat
}
object Money{
  def apply(d: Int, c: Int): Money = new Money(d, c)
  def apply(d: Float): Money = {
    val s = d.toString.split('.')
    new Money(s(0).toInt, s(1).toInt)
  }
}

// ex5
class Table {
  private val items = ArrayBuffer[ArrayBuffer[String]](ArrayBuffer())
  def |(s: String): Table = {
    items(items.length-1).append(s)
    this
  }
  def ||(s: String): Table = {
    items += ArrayBuffer(s)
    this
  }
  override def toString = items.map(_.mkString("<td>", "</td><td>", "</td>")).mkString("<table><tr>", "</tr><tr>", "</tr></table>")
}
object Table {
  def apply() = new Table
}

// ex6
class ASCIIArt(private val _items: Array[String]) {
  def this(s: String) {
    this(s.split("\r\n"))
  }
  def +(that: ASCIIArt) = {
    new ASCIIArt(
      (for(k <- _items.indices) yield that.items.isDefinedAt(k) match {
        case true => _items(k) + that.items(k)
        case _ => _items(k)
      }).toArray
    )
  }
  def /(that: ASCIIArt) = {
    new ASCIIArt(
      _items ++ that.items
    )
  }
  def items = _items
  override def toString = _items.mkString("\n")
}

// ex7
class BitSequence(s: String) {
  var l = java.lang.Long.parseLong(s, 2)
  def apply(i: Int) = l & (1<<i)
  def update(i: Int, v: Boolean) {
    l = v match {
      case true => l | (1<<i)
      case false => l ^ (1<<i)
    }
  }
  override def toString = l.toString
}

// ex8
class Matrix(val m: Array[Array[Double]]) {
  val rows = m.length
  val cols = m(0).length
  def apply(r: Int, c: Int) = m(r)(c)
  def update(r: Int, c: Int, v: Double) { m(r)(c) = v}
  private def compute(that: Matrix, f:(Double,Double) => Double): Array[Array[Double]] = {
    if (that.dim != dim) throw new Exception("Can only add matrix with same size")
    (for (i <- m.indices) yield m(i).zip(that.m(i)).map(v => f(v._1, v._2))).toArray
  }
  def +(that: Matrix) = new Matrix(compute(that, (a,b) => a+b))
  def *(that: Matrix) = new Matrix(compute(that, (a,b) => a*b))
  def *(s: Double) = {
    new Matrix(
      ( for (i <- m.indices)
        yield m(i).map(_*s) ).toArray
    )
  }
  def dim = (rows, cols)
  override def toString = m.map(_.mkString(" ")).mkString("\n")
}

// ex9
object RichFile {
  def unapply(s: String) = {
    val r = """(.+?)/([^/]+)\.([^\.]+)$""".r
    val r(p, n, e) = s
    Some(p, n , e)
  }
}


// ex10
object RichFile2 {
  def unapplySeq(s: String): Option[Seq[String]] = Some(s.split("/").filter(_!=""))
}




