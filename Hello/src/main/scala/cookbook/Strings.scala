package cookbook

object Strings extends App {

  //1.6. Finding Patterns in Strings
  val numPattern = "[0-9]+".r
  val address = "123 Main Street Suite 101"
  val match1 = numPattern.findFirstIn(address)
  val matches = numPattern.findAllIn(address).toArray

  //1.7. Replacing Patterns in Strings
  val address2 = "123 Main Street".replaceAll("[0-9]", "x")
  val regex = "[0-9]".r
  val newAddress = regex.replaceAllIn("123 Main Street", "x")

  //1.8. Extracting Parts of a String That Match Patterns
  val pattern="([0-9]+) ([A-Za-z]+)".r
  val pattern(count, fruit) = "100 Bananas"

  //1.9. Accessing a Character in a String
  "hello".charAt(0)
  "hello"(1)

  //1.10. Add Your Own Methods to the String Class
  implicit class StringImprovements(s: String) {
     def increment = s.map(c => (c + 1).toChar)
  }
  println( "HAL".increment )



}



