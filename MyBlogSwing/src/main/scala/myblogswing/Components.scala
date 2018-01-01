package myblogswing

import java.awt.{Color, Cursor, Dimension}
import javax.swing.ImageIcon
import scala.swing._

class Components {
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

  val updateCategory = new Button("Update"){
    icon = new ImageIcon(this.getClass().getResource("../img/update.16x16.png"))
  }

  val updatePosts = new Button("Update"){
    icon = new ImageIcon(this.getClass().getResource("../img/update.16x16.png"))
  }

  val updatePost = new Button("Update"){
    icon = new ImageIcon(this.getClass().getResource("../img/update.16x16.png"))
  }

  val exportPost = new Button("Export"){
    icon = new ImageIcon(this.getClass().getResource("../img/pdffile.16x16.png"))
  }

  val categoryPanel = new BoxPanel(Orientation.Vertical) {
    contents += new BorderPanel {
      add(new BorderPanel() {
        add( updateCategory, BorderPanel.Position.East)
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
        add( updatePosts, BorderPanel.Position.East)
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
        add( updatePost, BorderPanel.Position.East)
        add( exportPost, BorderPanel.Position.West)
        border = Swing.EmptyBorder(5, 5, 5, 5)

      }, BorderPanel.Position.North)
      add(new ScrollPane(){
        contents = postPanelContent

      }, BorderPanel.Position.South)
    }
    preferredSize = new Dimension(475,600)
  }

  def getCategories(cats: Array[Category]) : Component = {
    val bp = new BoxPanel(Orientation.Vertical) {
      cats.foreach(c => {
        contents += new Label("<html><a href=''>" + c.getName + "</a></html>"){
          cursor = new Cursor(Cursor.HAND_CURSOR)
          listenTo(mouse.clicks)
          reactions += {
            case _ : event.MouseClicked => {
              println("Cat:" + c.getName)
            }
          }
        }
        contents += Swing.VStrut(5)
      })
    }
    bp
  }

  def getPosts(posts: Array[Post]) : Component = {
    val bp = new BoxPanel(Orientation.Vertical) {
      posts.foreach(p => {
        contents += new Label("<html><a href=''>" + p.getTitle + "</a></html>"){
          cursor = new Cursor(Cursor.HAND_CURSOR)
          listenTo(mouse.clicks)
          reactions += {
            case _ : event.MouseClicked => {
              println("Posts:" + p.getTitle)
            }
          }
        }
        contents += Swing.VStrut(2)
        contents += new Label(buildName(p.getUser) + ", " + p.getCreated)
        contents += Swing.VStrut(2)
        var text = p.getBody;
        if (text.length > 200) text = text.substring(0, 200)
        contents += new Label("<html>" + text + "...</html>")
        contents += Swing.VStrut(10)
      })
    }
    bp
  }

  def getPost(post: Post) : Component = {
    val bp = new BoxPanel(Orientation.Vertical) {
        contents += new Label("<html><h3>" + post.getTitle + "</h></html>"){
          cursor = new Cursor(Cursor.HAND_CURSOR)
          listenTo(mouse.clicks)
          reactions += {
            case _ : event.MouseClicked => {
              println("Posts:" + post.getTitle)
            }
          }
        }
        contents += Swing.VStrut(10)
        contents += new Label(buildName(post.getUser) + ", " + post.getCreated)
        contents += Swing.VStrut(5)
        contents += new Label("<html>" + post.getBody + "</html>")
        contents += Swing.VStrut(10)
    }
    bp
  }


  def buildName(user:User):String = {
    user.getFirstname + " " + user.getLastname
  }
}

