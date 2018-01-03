package myblogswing

import java.awt.{Color, Cursor, Dimension}
import java.text.SimpleDateFormat
import javax.swing.ImageIcon
import scala.swing._

class Components {

  def dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm")

  val bottomLabel = new Label("...")

  val categoryPanelContent = new BoxPanel(Orientation.Vertical){
    contents += new Label("categories")
    preferredSize = new Dimension(280,480)
    border = Swing.EmptyBorder(5, 5, 5, 5)
  }

  val postsPanelContent = new BoxPanel(Orientation.Vertical){
    contents += new Label("posts")
    preferredSize = new Dimension(380,480)
    border = Swing.EmptyBorder(5, 5, 5, 5)
  }

  val postPanelContent = new BoxPanel(Orientation.Vertical){
    contents += new Label("posts")
    preferredSize = new Dimension(455,480)
    border = Swing.EmptyBorder(5, 5, 5, 5)
  }

  val updateCategoryBtn = new Button("Update"){
    icon = new ImageIcon(this.getClass().getResource("../img/update.16x16.png"))
  }

  val updatePostsBtn = new Button("Update"){
    icon = new ImageIcon(this.getClass().getResource("../img/update.16x16.png"))
  }

  val updatePostBtn = new Button("Update"){
    icon = new ImageIcon(this.getClass().getResource("../img/update.16x16.png"))
  }

  val exportPostBtn = new Button("Export"){
    icon = new ImageIcon(this.getClass().getResource("../img/pdffile.16x16.png"))
  }

  val categoryPanel = new BoxPanel(Orientation.Vertical) {
    contents += new BorderPanel {
      add(new BorderPanel() {
        add( updateCategoryBtn, BorderPanel.Position.East)
        border = Swing.EmptyBorder(5, 5, 5, 5)

      }, BorderPanel.Position.North)
      add(new ScrollPane(){
        contents = categoryPanelContent
      }, BorderPanel.Position.South)
    }
    preferredSize = new Dimension(300,600)
  }

  val postsPanel = new BoxPanel(Orientation.Vertical) {
    contents += new BorderPanel {
      add(new BorderPanel() {
        add( updatePostsBtn, BorderPanel.Position.East)
        border = Swing.EmptyBorder(5, 5, 5, 5)

      }, BorderPanel.Position.North)
      add(new ScrollPane(){
        contents = postsPanelContent

      }, BorderPanel.Position.South)
    }
    preferredSize = new Dimension(400,600)
  }

  val postPanel = new BoxPanel(Orientation.Vertical) {
    contents += new BorderPanel {
      add(new BorderPanel() {
        add( updatePostBtn, BorderPanel.Position.East)
        add( exportPostBtn, BorderPanel.Position.West)
        border = Swing.EmptyBorder(5, 5, 5, 5)

      }, BorderPanel.Position.North)
      add(new ScrollPane(){
        contents = postPanelContent

      }, BorderPanel.Position.South)
    }
    preferredSize = new Dimension(475,600)
  }

  def getCategories(cats: Array[Classes.Category]) : Component = {
    val bp = new BoxPanel(Orientation.Vertical) {
      cats.foreach(c => {
        contents += new Label("<html><a href=''>" + c.name + "</a></html>"){
          cursor = new Cursor(Cursor.HAND_CURSOR)
          listenTo(mouse.clicks)
          reactions += {
            case _ : event.MouseClicked => {
              UI.currentData.categoryId = c.id
              updatePosts()
            }
          }
        }
        contents += Swing.VStrut(5)
      })
    }
    bp
  }

  def getPosts(posts: Array[Classes.Post]) : Component = {
    val bp = new BoxPanel(Orientation.Vertical) {
      posts.foreach(p => {
        contents += new Label("<html><a href=''>" + p.title + "</a></html>"){
          cursor = new Cursor(Cursor.HAND_CURSOR)
          listenTo(mouse.clicks)
          reactions += {
            case _ : event.MouseClicked => {
              UI.currentData.postId = p.id
              updatePost()
            }
          }
        }
        contents += Swing.VStrut(2)
        contents += new Label(buildName(p.user) + ", " + formatDate(p.created) )
        contents += Swing.VStrut(2)
        var text = p.body;
        if (text.length > 200) text = text.substring(0, 200)
        contents += new Label("<html>" + text + "...</html>")
        contents += Swing.VStrut(10)
      })
    }
    bp
  }

  def getPost(post: Classes.Post) : Component = {
    val bp = new BoxPanel(Orientation.Vertical) {
        contents += new Label("<html><h3>" + post.title + "</h></html>")
        contents += Swing.VStrut(10)
        contents += new Label(buildName(post.user) + ", " + formatDate(post.created))
        contents += Swing.VStrut(5)
        contents += new Label("<html>" + post.body + "</html>")
        contents += Swing.VStrut(10)
    }
    bp
  }

  def buildName(user:Classes.User):String = {
    user.firstname + " " + user.lastname
  }

  def formatDate(dt:String) : String = {
    val time = new java.util.Date(dt.toLong)
    dateFormatter.format(time)
  }

  def updateCategories(): Unit = {
    val categories = UI.restService.getCategories()
    categoryPanelContent.contents.clear()
    categoryPanelContent.contents += UI.components.getCategories(categories)
    categoryPanelContent.revalidate()
    categoryPanelContent.repaint()
  }

  def updatePosts(): Unit = {
    if (0 == UI.currentData.categoryId) return

    val posts = UI.restService.getPosts(UI.currentData.categoryId)
    postsPanelContent.contents.clear()
    postsPanelContent.contents += UI.components.getPosts(posts)
    postsPanelContent.revalidate()
    postsPanelContent.repaint()
  }

  def updatePost(): Unit ={
    if (0 == UI.currentData.postId) return

    val post = UI.restService.getPost(UI.currentData.postId)
    postPanelContent.contents.clear()
    postPanelContent.contents += UI.components.getPost(post)
    postPanelContent.revalidate()
    postPanelContent.repaint()
  }

  def exportPost(): Unit = {
    println("exportPost")
  }

}

