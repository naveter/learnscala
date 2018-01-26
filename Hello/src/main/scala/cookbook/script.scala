
//class Person(var firstName: String, var lastName: String) {
//  override def toString = firstName + " " + lastName
//}
//
//println(new Person("Nacho", "Libre"))

object Hello extends App {
  // write some text out to the user with Console.println
  Console.println("Hello")

  // Console is imported by default, so it's not really needed, just use println
  println("World")

  // readLine lets you prompt the user and read their input as a String
  val name = readLine("What's your name? ")

  // readInt lets you read an Int, but you have to prompt the user manually
  print("How old are you? ")
  val age = readInt()

  // you can also print output with printf
  println(s"Your name is $name and you are $age years old.")
}