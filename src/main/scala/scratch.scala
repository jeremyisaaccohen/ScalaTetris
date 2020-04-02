import java.awt.{BorderLayout, Canvas, Color, Dimension, Graphics, GridLayout}
import java.awt.event.{ActionEvent, ActionListener, KeyAdapter, KeyEvent}

import javax.swing.border.LineBorder
import javax.swing.{Box, JButton, JComponent, JFrame, JLabel, JPanel, JTabbedPane}
import java.awt.BorderLayout
import java.awt.Dimension

object TetrisGame1 {
  def main(args: Array[String]): Unit = {
    val gameBoard = new Board()

    gameBoard.paintShape(() => {})

    val jframe = new JFrame() {
      setPreferredSize(new Dimension(300,650))
      val wholePanel = new JPanel()
      wholePanel.setLayout(new BorderLayout())

      val startButton = new JButton("Start Game") {
        addActionListener(new ActionListener {
          override def actionPerformed(e: ActionEvent): Unit = println("STARTTTTT")
        })
        setFocusable(false)
        def actionPerformed(e: ActionEvent): Unit =
          println("START CALLEd")
        repaint()
        setVisible(true)
      }
      val resetButton = new JButton("Reset Game")  {
        setFocusable(false)

        def actionPerformed(e: ActionEvent): Unit = {
          println("RESET CALLED")
          gameBoard.makeRed()

          //gameBoard.blankBoard()
          repaint()
          setVisible(true)
        }
      }
      val buttonPanel = new JPanel()
      buttonPanel.setLayout(new BorderLayout())
      buttonPanel.add(startButton, BorderLayout.WEST)
      buttonPanel.add(resetButton, BorderLayout.EAST)

      wholePanel.add(buttonPanel, BorderLayout.NORTH)

      setFocusable(true)


      val paintPanel = new JPanel() {
        override def paintComponent(g: Graphics) = {
          val tileSize = 15
          var x1 = 0
          var x2 = tileSize
          var y1 = 0
          var y2 = tileSize
          val tiles: Array[Array[Color]] = gameBoard.tiles
          var rows = 0
          var cols = 0

          for(arr <- tiles) {
            for (tile <- arr) {
              g.setColor(tile)
              g.fillRect(x1, y1, x2, y2)
              g.setColor(Color.GRAY)
              g.drawRect(x1,y1,x2,y2)

              x1 += tileSize
              x2 += tileSize
            }
            x1 = 0
            x2 = tileSize
            y1 += tileSize
            y2 += tileSize
          }
        }
      }


      wholePanel.add(paintPanel, BorderLayout.CENTER)
      setContentPane(wholePanel)

      addKeyListener(new KeyAdapter {
        override def keyPressed(e: KeyEvent): Unit = {

          if(e.getKeyChar == 'a') {
            gameBoard.paintShape(gameBoard.moveLeft)
            repaint()
            println("COORD = " + gameBoard.currPos)
            for (i <- 0 until gameBoard.currShape.area.length) {
              println(gameBoard.currShape.area(i))
            }
          }

          if(e.getKeyChar == 'r') {
            gameBoard.blankBoard()
            repaint()
          }

          if(e.getKeyChar == 'm'){
            gameBoard.makeRed()
            repaint()
          }

          if(e.getKeyChar == 'd') {
            gameBoard.paintShape(gameBoard.moveRight)
            repaint()
            println("COORD = " + gameBoard.currPos)
            for (i <- 0 until gameBoard.currShape.area.length) {
              println(gameBoard.currShape.area(i))
            }
          }

          if(e.getKeyChar == 's') {
            gameBoard.paintShape(gameBoard.tickDown)
            repaint()
            println("COORD = " + gameBoard.currPos)
            for (i <- 0 until gameBoard.currShape.area.length) {
              println(gameBoard.currShape.area(i))
            }
          }

          if(e.getKeyChar == 'q') {
            gameBoard.paintShape(gameBoard.rotateCCW)
            repaint()
            println("COORD = " + gameBoard.currPos)
            for (i <- 0 until gameBoard.currShape.area.length) {
              println(gameBoard.currShape.area(i))
            }
          }

          if(e.getKeyChar == 'e') {
            gameBoard.paintShape(gameBoard.rotateCCW)
            repaint()
            println("COORD = " + gameBoard.currPos)
            for (i <- 0 until gameBoard.currShape.area.length) {
              println(gameBoard.currShape.area(i))
            }
          }

          if(e.getKeyChar == 'n') {
            gameBoard.addShape()
            repaint()
            println("NEW TSHAPE")
          }

          //          if(gameBoard.stuck()) {
          //            gameBoard.addShape()
          //          }
        }
      })
      pack
      setVisible(true)
    }
  }
}

