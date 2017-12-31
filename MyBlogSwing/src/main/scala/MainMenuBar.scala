package myblogswing

import swing._
import Swing._
import javax.swing.KeyStroke

class MainMenuBar
{
  var menuBar : MenuBar = new MenuBar {
      contents += new Menu("File") {
        contents += new MenuItem(new Action("New") {
          def apply {

          }
        })

        contents += new MenuItem(new Action("Open") {
          def apply {
            // Your code will go here...
          }
        })

        contents += new MenuItem(new Action("Save") {
          accelerator = Some(KeyStroke.getKeyStroke("ctrl S"))

          def apply {
            // Your code will go here...
          }
        })

        contents += new MenuItem(new Action("Save As...") {
          def apply {
            // Your code will go here...
          }
        })
      }
    }
}
