package cookbook

object ActorsAndConcurrency {

  //Recipe 13.1, How to get started with a simple Scala/Akka Actor
  //libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.1.2"

  //Recipe 13.9, Simple concurrency with Scala Futures
  import scala.concurrent.{Await, Future}
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.util.{Failure, Success}

  object Futures1 extends App {

    // used by 'time' method
    implicit val baseTime = System.currentTimeMillis

    // 2 - create a Future
    val f = Future {
      Thread.sleep(500)
      1 + 1
    }

    // 3 - this is blocking (blocking is bad)
    f.onComplete {
      case Success(value) => println(s"Got the callback, meaning = $value")
      case Failure(e) => e.printStackTrace
    }
  }

}
