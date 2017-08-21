package example

/**
  * Created by bass on 20.08.17.
  */
object TheBasics extends App {
  val ages = Seq(42, 75, 29, 64, 76, 78)
  println(s"The oldest person is ${ages.max}")

  var str1 = "Some string".charAt(0)
  println(s"The first char is ${str1}")
  println(s"The last char is ${"Some string".last}")

  var str2 = "Some example string"
  println(s"take: ${str2.take(3)}")
  println(s"drop: ${str2.drop(3)}")
  println(s"takeRight: ${str2.takeRight(3)}")
  println(s"dropRight: ${str2.dropRight(3)}")





}
