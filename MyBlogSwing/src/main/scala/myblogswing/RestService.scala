package myblogswing

import org.apache.http.impl.client.HttpClients

import scala.util.control.Breaks._
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import java.io.BufferedReader
import java.io.InputStreamReader

import scala.swing.Dialog

class RestService {

  val serverUrl = "http://localhost:8080/rest/"

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

  def getCategories():Array[Category] = {
    val cont = getRestContent("categories")

    Array(new Category())
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