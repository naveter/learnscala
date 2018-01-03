package myblogswing

import java.awt.{Dimension, Toolkit}
import java.util.Date
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

  val bottomLabel = new Label("...")

  val centerPanel = new BoxPanel(Orientation.Horizontal) {
    contents += UI.components.categoryPanel
    contents += Swing.HStrut(5)
    contents += UI.components.postsPanel
    contents += Swing.HStrut(5)
    contents += UI.components.postPanel

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

  listenTo(UI.components.updateCategoryBtn)
  listenTo(UI.components.updatePostsBtn)
  listenTo(UI.components.updatePostBtn)
  listenTo(UI.components.exportPostBtn)

  reactions += {
    case ButtonClicked(UI.components.`updateCategoryBtn`) =>
      UI.components.updateCategories()
    case ButtonClicked(UI.components.`updatePostsBtn`) =>
      UI.components.updatePosts()
    case ButtonClicked(UI.components.`updatePostBtn`) =>
      UI.components.updatePost()
    case ButtonClicked(UI.components.`exportPostBtn`) =>
      UI.components.exportPost()
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

object UI {
  val restService = new RestService
  val components = new Components
  val currentData = new Classes.CurrentData
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


