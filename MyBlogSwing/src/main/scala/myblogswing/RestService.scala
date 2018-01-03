package myblogswing

import net.liftweb.json._
import net.liftweb.json.DefaultFormats

import scala.util.control.Breaks._
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.SimpleDateFormat

import scala.collection.mutable.ArrayBuffer
import scala.swing.Dialog

class RestService {

  val serverUrl = "http://localhost:8080/rest/"
  implicit val formats = new DefaultFormats {
    override def dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm")
  }

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

  def getCategories():Array[Classes.Category] = {
    val result = getRestContent("categories")
    val jValue = parse(result.toString)
    val categories = ArrayBuffer[Classes.Category]()
    val elements = jValue.children

    for(j <- elements){
       val cat = j.extract[Classes.Category]
      categories += cat
    }

    categories.toArray
  }

  def getPosts(category_id:Integer) : Array[Classes.Post] = {
    val result = getRestContent("category?id=" + category_id)
    val jValue = parse(result.toString)
    val posts = ArrayBuffer[Classes.Post]()
    val elements = jValue.children

    for(j <- elements){
      val cat = j.extract[Classes.Post]
      posts += cat
    }

    posts.toArray
  }

  def getPost(post_id:Integer) : Classes.Post = {
    val result = getRestContent("post?id=" + post_id)
    val jValue = parse(result.toString)
    val post = jValue.extract[Classes.Post]

    post
  }

}

