package example

object TypeParameters extends App {

  // ex3
  def swap[T, S](p: Pair3[T, S]): Pair3[S, T] = {
    new Pair3(p.second, p.first)
  }

  // ex6
  def middle[T](it: Iterable[T]): T = {
    val l = it.toList
    l(l.size / 2)
  }
  println( middle("Ella Fitzgerald"))

  // ex10
  println( (new Pair5("hello", "world")).swap("Param").toString() )






}

// ex1
class Pair[T, S](val first: T, val second: S) {
  def swap:Pair[S, T] = new Pair(second, first)
}

// ex2
class Pair2[T](val first: T, val second: T) {
  def swap:Pair2[T] = new Pair2(second, first)
}

// ex3
class Pair3[T, S](val first: T, val second: S) {}

// ex5
class Pair4[T <% Comparable[T]](val first: T, val second: T)

// ex10
class Pair5[S, T](var first: S, var second: T) {
  def swap(ev:String) {
    val tempSecond = first
    val tempFirst = second
    first = tempSecond
    second = tempFirst
  }
  override def toString():String = {
    first + ", " + second
  }
}






