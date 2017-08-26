package example

/**
  * Created by bass on 25.08.17.
  */
object ControlStructures extends  App{

  // 1 exercise
  def signum(s : Integer): Integer = {
    if (s > 0) 1
    else if (s < 0) -1
    else 0
  }
  println(s"23: ${signum(23)}, -23: ${signum(-23)}, 0: ${signum(0)}" );

  // 2 ex
  //Unit has only one value which is ()
  assert( {} == () )

  //His type is Unit
  assert( {}.isInstanceOf[Unit] )

  // 3ex
  // for (int i = 10; i >= 0; i--) System.out.println(i);
  //With a range and reverse
  (0 to 10).reverse.foreach(print)
  println("");
  //With a for loop
  for (i <- 10.to(0, -1)) print(i)
  println("");

  // ex5
  def countdown(n: Int): Unit = {
    (0 to 10).reverse.foreach(print)
  }
  countdown(10)
  println("")

  // Ex7
  println(s"Hello in Unicode is: ${ "Hello".map(_.toLong).product }")

  // Ex8
  def product(s: String): Long = s.map(_.toLong).product




}
