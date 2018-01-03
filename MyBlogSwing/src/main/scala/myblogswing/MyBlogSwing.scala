package myblogswing

import java.awt.{Dimension, Toolkit}
import scala.swing._
import scala.swing.event.ButtonClicked

class UI extends MainFrame {
  title = "MyBlogSwing"
  preferredSize = new Dimension(1200,600)
  resizable = false
  iconImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icon.128x128.png"))

  val centerPanel = new BoxPanel(Orientation.Horizontal) {
    contents += UI.components.categoryPanel
    contents += Swing.HStrut(5)
    contents += UI.components.postsPanel
    contents += Swing.HStrut(5)
    contents += UI.components.postPanel

    border = Swing.EmptyBorder(5, 5, 5, 5)
  }

  val bottomBoxPanel = new BoxPanel(Orientation.Horizontal) {
    contents += Swing.HStrut(5)
    contents += UI.components.bottomLabel
  }

  def refreshBottom(): Unit ={
    bottomBoxPanel.revalidate()
    bottomBoxPanel.repaint()
  }

  contents = new BorderPanel {
    add((new MainMenuBar()).menuBar, BorderPanel.Position.North)
    add(centerPanel, BorderPanel.Position.Center)
    add(bottomBoxPanel, BorderPanel.Position.South)

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

  // Window moves to center of screen
  val dim: Dimension = Toolkit.getDefaultToolkit.getScreenSize
  this.location = new Point((dim.width - this.size.width) / 2, (dim.height - this.size.height) / 2)

}

object UI {
  val restService = new RestService
  val components = new Components
  val currentData = new Classes.CurrentData
  val bottomBoxPanel = UI.bottomBoxPanel

  def revalidate(): Unit = {
    UI.revalidate()
  }
  def repaint(): Unit ={
    UI.repaint()
  }
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
  }
}


