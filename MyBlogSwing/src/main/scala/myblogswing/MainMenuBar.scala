package myblogswing

import javax.swing.{ImageIcon, KeyStroke}
import scala.swing._

class MainMenuBar
{
  var menuBar : MenuBar = new MenuBar {
      contents += new Menu("File") {
        contents += new MenuItem(new Action("New") {
          def apply {

          }
          icon = new ImageIcon(this.getClass().getResource("../img/folder_explore.16x16.png"))
        })

        contents += new MenuItem(new Action("Open") {
          def apply {
            // Your code will go here...
          }
          icon = new ImageIcon(this.getClass().getResource("../img/node-tree.16x16.png"))
        })

        contents += new MenuItem(new Action("Save") {
          accelerator = Some(KeyStroke.getKeyStroke("ctrl S"))

          def apply {
            // Your code will go here...
          }
          icon = new ImageIcon(this.getClass().getResource("../img/refresh.16x16.png"))
        })

        contents += new MenuItem(new Action("Save As...") {
          def apply {
            // Your code will go here...
          }
          icon = new ImageIcon(this.getClass().getResource("../img/pdffile.16x16.png"))
        })
      }
    }
}
