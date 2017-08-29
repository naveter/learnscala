package example

/**
  * Created by bass on 28.08.17.
  */
object Objects extends  App {

  // ex1
  object Conversions {
    def inchesToCentimeters(inches: Double) = {
      inches*2.54
    }
    def gallonsToLiters(gallons: Double) = {
      gallons*3.78541178
    }
    def milesToKilometers(miles: Double) = {
      miles*1.609344
    }
  }
  println("2 inches is centi: "+ Conversions.inchesToCentimeters(2))


  // ex2
  abstract class UnitConversion {
    def convert(value: Double): Double
  }
  object InchesToCentimeters extends UnitConversion {
    def convert(value: Double) = {
      value*2.54
    }
  }
  object GallonsToLiters extends UnitConversion {
    def convert(value: Double) = {
      value*3.78541178
    }
  }
  object MilesToKilometers extends UnitConversion {
    def convert(value: Double) = {
      value*1.609344
    }
  }
  println("3 inches is centi:" + InchesToCentimeters.convert(3))


  // ex4
  class Point(val x:Double, val y: Double)
  object Point {
    def apply(x:Double, y: Double) = new Point(x, y)
  }
  val p = Point(3,4)
  println("Point.x is: " + p.x)


  // ex5
  if (args.length > 0) println(args.reverse.mkString(" "))


  // ex6
  object PlayingCards extends Enumeration {
    type PlayingCards = Value
    val spades = Value("\u2660")
    val diamonds = Value("\u2666")
    val hearts = Value("\u2665")
    val clubs = Value("\u2663")
  }
  for (c <- PlayingCards.values) print(c)
  println("")


  // ex7
  def isRed(cards: PlayingCards.PlayingCards) = {
    if (cards == PlayingCards.hearts || cards == PlayingCards.diamonds)
      true
    else
      false
  }
  println(PlayingCards.diamonds.toString + " is " + isRed(PlayingCards.diamonds))
  println(PlayingCards.spades.toString + " is " + isRed(PlayingCards.spades))


  // ex8
  object RGBColorCube extends Enumeration {
    val r = Value(0xff0000, "red")
    val g = Value(0x00ff00, "green")
    val b = Value(0x0000ff, "blue")
    val rg = Value(0xffff00, "red-green")
    val rb = Value(0xff00ff, "red-blue")
    val gb = Value(0x00ffff, "green-blue")
    val bl = Value(0x000000, "black")
    val wh = Value(0xffffff, "white")
  }
  for (c <- RGBColorCube.values) print(c.id + ":" + c)
  println("")



}
