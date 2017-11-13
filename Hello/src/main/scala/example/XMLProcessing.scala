package example

import scala.xml.{Elem, NodeSeq, Text, Document}
import scala.language.postfixOps
import scala.xml.parsing.XhtmlParser
import scala.io.Source

object XMLProcessing extends App {

  //ex2
//  val xml = <ul>
//    <li>{Text("Opening bracket: [")}</li>
//    <li>{Text("Closing bracket: ]")}</li>
//    <li>{Text("Opening brace: {")}</li>
//    <li>{Text("Closing brace: }")}</li>
//  </ul>
//
//  println(xml.getClass.getName)

  def getImgWithoutAlt(doc: Document): NodeSeq = doc \\ "img" filter { _ \ "@alt" isEmpty }

  val xhtml = """<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <html>
    <head>
      <title>Xhtml Valid Page</title>
    </head>
    <body>
      <p>
        <img name="image" src="image.jpg" />
      </p>
      <p>
        <img name="imageAlt" src="imageAlt.jpg" alt="diaporama" />
      </p>
    </body>
  </html>"""

//  val parser = new XhtmlParser(Source.fromString(xhtml))
//  val doc = parser.initialize.document()
//
//  (doc \\ "img").foreach{
//    n => {
//      println(n \ "@name")
//      println(n \ "@src")
//    }
//  }

//  def mapToDl(m: Map[String, String]):Elem = {
//    <dl>{ for ((k,v) <- m) yield <dt>{k}</dt><dd>{v}</dd> }</dl>
//  }
//  println(mapToDl(Map("A" -> "1", "B" -> "2")))





}
