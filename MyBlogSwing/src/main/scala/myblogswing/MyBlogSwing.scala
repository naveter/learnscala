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

      val u1 = new User()
      u1.setFirstname("Karl")
      u1.setLastname("Petroff")
      val c1 = new Post()
      c1.setTitle("First title of article")
      c1.setBody("Ересь в <b>христианстве</b> (в противоположность ортодоксии) — формальное отрицание или сомнение в какой-либо из основных доктрин христианской веры, как они определены в одной или более христианских церквей. Ересь следует отличать от отступничества и раскола. Отступничество почти всегда предполагает полный отказ от христианской веры после того, как она была свободно принята, а раскол является нарушением церковного единства, не обязательно на догматической почве.")
      c1.setUser(u1)
      c1.setCreated(new Date())

      val cats = Array(c1,c1,c1)
      components.postsPanelContent.contents.clear()
      components.postsPanelContent.contents += components.getPosts(cats)
      components.postsPanelContent.revalidate()
      components.postsPanelContent.repaint()

    case ButtonClicked(components.updatePost) =>
      println("updatePost")

      val u1 = new User()
      u1.setFirstname("Karl")
      u1.setLastname("Petroff")
      val c1 = new Post()
      c1.setTitle("First title of article")
      c1.setBody("Ересь в <b>христианстве</b> (в противоположность ортодоксии) — формальное отрицание или сомнение в какой-либо из основных доктрин христианской веры, как они определены в одной или более христианских церквей. Ересь следует отличать от отступничества и раскола. Отступничество почти всегда предполагает полный отказ от христианской веры после того, как она была свободно принята, а раскол является нарушением церковного единства, не обязательно на догматической почве.<p>Ересь в <b>христианстве</b> (в противоположность ортодоксии) — формальное отрицание или сомнение в какой-либо из основных доктрин христианской веры, как они определены в одной или более христианских церквей. Ересь следует отличать от отступничества и раскола. Отступничество почти всегда предполагает полный отказ от христианской веры после того, как она была свободно принята, а раскол является нарушением церковного единства, не обязательно на догматической почве.</p>")
      c1.setUser(u1)
      c1.setCreated(new Date())

      components.postPanelContent.contents.clear()
      components.postPanelContent.contents += components.getPost(c1)
      components.postPanelContent.revalidate()
      components.postPanelContent.repaint()

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


