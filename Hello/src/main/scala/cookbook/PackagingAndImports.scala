package cookbook

object PackagingAndImports extends App{

//  val foo = new store.Foo()







}

//Recipe 7.1, How to package Scala code with the 'curly braces' style
package store {
  class Foo { override def toString = "I am com.acme.store.Foo" }
}

//Recipe 7.2, How to import multiple members in Scala (wildcard and curly braces syntax)
import java.io.{File, IOException, FileNotFoundException}

//Recipe 7.3, How to rename members on import in Scala
import java.util.{Date => JDate, HashMap => JHashMap}

//Recipe 7.4, How to hide a class (or classes) with Scala import statements
import java.util.{Random => _, _}




