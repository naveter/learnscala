package myblogswing

import scala.swing._
import java.awt.Dimension
import java.awt.Color

class UI extends MainFrame {
  def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }

  title = "MyBlogSwing"
  maximumSize = new Dimension(1200, 600)
  minimumSize = new Dimension(1200, 600)


  val bottomLabel = new Label("...")
  val categoryPanel = new BoxPanel(Orientation.Vertical) {
    contents += new Button("categoryPanel")

    maximumSize  = new Dimension(300, 600)
    minimumSize  = new Dimension(300, 600)
  }

  val postsPanel = new BoxPanel(Orientation.Vertical) {
    contents += new Label("postsPanel")
    contents += Swing.HStrut(5)
  }

  val postPanel = new BoxPanel(Orientation.Vertical) {
    contents += new Button("postPanel")

    maximumSize  = new Dimension(500, 600)
    minimumSize  = new Dimension(500, 600)
  }

  val centerPanel = new BorderPanel {
    add(categoryPanel, BorderPanel.Position.West)
    add(postsPanel, BorderPanel.Position.Center)
    add(postPanel, BorderPanel.Position.East)
  }

  contents = new BorderPanel {
    add((new MainMenuBar()).menuBar, BorderPanel.Position.North)
    add(centerPanel, BorderPanel.Position.Center)
    add(new BoxPanel(Orientation.Horizontal) {
      contents += bottomLabel
    }, BorderPanel.Position.South)

    border = Swing.EmptyBorder(0, 1, 1, 1)
  }

  def reportAndClose() {

    sys.exit(0)
  }
}

object MyBlogSwing {
  def main(args: Array[String]) {
    val ui = new UI
    ui.visible = true
    println("End of main function")
  }
}


