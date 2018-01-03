package myblogswing

import net.liftweb.json._
import net.liftweb.json.DefaultFormats
import scala.util.control.Breaks._
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import scala.collection.mutable.ArrayBuffer
import scala.swing.Dialog

class RestService {

  val serverUrl = "http://localhost:8080/rest/"
  implicit val formats = DefaultFormats

  def getRestContent(url:String): String = {
    val rurl = serverUrl + url
    val client = HttpClientBuilder.create.build
    val request = new HttpGet(rurl)
    val response = client.execute(request)

    if(200 != response.getStatusLine.getStatusCode){
      Dialog.showMessage(null, "Network not found", title="Error")
      return ""
    }

    val rd = new BufferedReader(new InputStreamReader(response.getEntity.getContent))
    val result = new StringBuffer
    var line = ""
    breakable {
      while ((line = rd.readLine()) != null) {
        if (line == null) break()

        result.append(line)
      }
    }

    result.toString
  }

//  case class Categor(id: Int, name: String)

  def getCategories():Array[Classes.Categor] = {
    val result = getRestContent("categories")
    val jValue = parse(result.toString)
    val categories = ArrayBuffer[Classes.Categor]()

    val elements = jValue.children

    for(j <- elements){
       val cat = j.extract[Classes.Categor]
      categories += cat
    }

//    val categories = jValue.extract[ Array[Categor] ]

    Array(new Category)
    categories.toArray
  }

  def getPosts(category_id:Integer) : Array[Post] = {

    Array(new Post())
  }

  def getPost(post_id:Integer) : Post = {

    new Post()
  }
}

class CurrentData {
  var categoryId = null
  var postId = null
}