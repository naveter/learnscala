package myblogswing

import java.awt.{Dimension, Toolkit}

import scala.collection.mutable
import scala.swing._
import scala.swing.event.ButtonClicked

class UI extends MainFrame {
  def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }

  title = "MyBlogSwing"
  preferredSize = new Dimension(1200,600)
  resizable = false
  iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icon.128x128.png"))

  val components = new Components
  val bottomLabel = new Label("...")

  val centerPanel = new BoxPanel(Orientation.Horizontal) {
    contents += components.categoryPanel
    contents += Swing.HStrut(5)
    contents += components.postsPanel
    contents += Swing.HStrut(5)
    contents += components.postPanel

    border = Swing.EmptyBorder(5, 5, 5, 5)
  }

  contents = new BorderPanel {
    add((new MainMenuBar()).menuBar, BorderPanel.Position.North)
    add(centerPanel, BorderPanel.Position.Center)
    add(new BoxPanel(Orientation.Horizontal) {
      contents += Swing.HStrut(5)
      contents += bottomLabel
    }, BorderPanel.Position.South)

    border = Swing.EmptyBorder(0, 1, 1, 1)
  }

  listenTo(components.updateCategory)
  listenTo(components.updatePosts)
  listenTo(components.updatePost)
  listenTo(components.exportPost)

  reactions += {
    case ButtonClicked(components.updateCategory) =>

      println("updateCatgory")
      val c1 = new Category();
      c1.setName("First")
      c1.setId(1L)
      val c2 = new Category();
      c2.setName("Second category")
      c2.setId(2L)
      val c3 = new Category();
      c3.setName("Third super long category and may be some else")
      c3.setId(3L)
      val cats = Array(c1,c2,c3)

      components.categoryPanelContent.contents.clear()
      components.categoryPanelContent.contents += components.getCategories(cats)
      components.categoryPanelContent.revalidate()
      components.categoryPanelContent.repaint()

    case ButtonClicked(components.updatePosts) =>
      println("updatePosts")
    case ButtonClicked(components.updatePost) =>
      println("updatePost")
    case ButtonClicked(components.exportPost) =>
      println("exportPost")
    case ButtonClicked(s) =>
      println("Button click on button: '" + s.text + "'")
  }

  val dim: Dimension = Toolkit.getDefaultToolkit.getScreenSize
  val w: Int = this.size.width
  val h: Int = this.size.height
  val x: Int = (dim.width - w) / 2
  val y: Int = (dim.height - h) / 2
  this.location = new Point(x, y)

}

object MyBlogSwing {
  def main(args: Array[String]) {

    for (info <- javax.swing.UIManager.getInstalledLookAndFeels) {
      if ("Windows" == info.getName) {
        javax.swing.UIManager.setLookAndFeel(info.getClassName)
      }
    }

    val ui = new UI
    ui.visible = true
    println("End of main function")
  }
}


