package cookbook

object Numbers extends App {

  //2.1. Parsing a Number from a String
  "100".toDouble
  BigInt("1")
  Integer.parseInt("100", 2)

  //2.2. Converting Between Numeric Types (Casting)
  19.toFloat

  //2.3. Overriding the Default Numeric Type
  val a1 = 1f
  val a2 = 0: Double
  var name=null.asInstanceOf[String]

  //2.5. Comparing Floating-Point Numbers
  def~=(x:Double,y:Double,precision:Double)={if((x-y).abs<precision)true else false}

  //2.7. Generating Random Numbers
  val r = scala.util.Random
  r.nextInt
  r.nextInt(100)
  for (i <- 1 to 5) yield r.nextInt(100)

  //2.8. Creating a Range, List, or Array of Numbers
  val rw = 1 to 10 by 2

  //2.9. Formatting Numbers and Currency
  val pi = scala.math.Pi
  println(f"$pi%1.5f")
  val formatter = java.text.NumberFormat.getIntegerInstance
  formatter.format(10000)

  import java.util.{Currency, Locale}
  val de = Currency.getInstance(new Locale("de", "DE"))


}







