package myblogswing

import java.awt.{Color, Cursor, Dimension}
import javax.swing.ImageIcon

import myblogswing.Category
import org.w3c.dom.events
import org.w3c.dom.events.EventListener

import scala.swing._
import scala.swing.event.{Event, MouseClicked}

class Components {
  val categoryPanelContent = new BoxPanel(Orientation.Vertical){
    contents += new Label("categories")
    preferredSize = new Dimension(280,480)
    background = Color.CYAN
  }

  val postsPanelContent = new BoxPanel(Orientation.Vertical){
    contents += new Label("posts")
    preferredSize = new Dimension(380,480)
    background = Color.RED
  }

  val postPanelContent = new BoxPanel(Orientation.Vertical){
    contents += new Label("posts")
    preferredSize = new Dimension(455,480)
    background = Color.GRAY
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
        contents += new Label(c.getName){
          cursor = new Cursor(Cursor.HAND_CURSOR)

//          mouse.clicks = new Publisher[] {
//            override def publish(e: Event) {
//              publish(e)
//            }
//          }
//          mouse.clicks.listeners(new EventListener() {
//            override def handleEvent(evt: events.Event) {
//
//            }
//          })
        }
        contents += Swing.VStrut(5)
      })
    }
    bp
  }

}

