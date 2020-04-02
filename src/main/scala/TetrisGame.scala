import java.awt.{BorderLayout, Canvas, Color, Dimension, Graphics, GridLayout}
import java.awt.event.{ActionEvent, ActionListener, KeyAdapter, KeyEvent}

import javax.swing.border.LineBorder
import javax.swing.{Box, JButton, JComponent, JFrame, JLabel, JPanel, JTabbedPane, Timer}
import java.awt.BorderLayout
import java.awt.Dimension

object TetrisGame {
  def main(args: Array[String]): Unit = {

    val gameBoard = new Board()

    gameBoard.paintShape(() => {})

    val jframe = new JFrame() {
      setPreferredSize(new Dimension(250,600))
      val wholePanel = new JPanel()
      wholePanel.setLayout(new BorderLayout())

      gameBoard.Timer(250) {
        gameBoard.removeRows()
        repaint()
      }

      gameBoard.Timer(1000) {
        gameBoard.paintShape(gameBoard.tickDown)
        repaint()
      }

//      gameBoard.Timer(1000) {
//        val tiles:Array[Array[Color]] = gameBoard.tiles
//        val oldColor = gameBoard.currShape.color
//        val realArea:Array[(Int, Int)] = gameBoard.currShape.area.map((x) => (x._1 + gameBoard.currPos._1, x._2 + gameBoard.currPos._2))
//        for(tile <- realArea) {
//          tiles(tile._1)(tile._2) = Color.black
//        }
//        if (!gameBoard.isValid(gameBoard.currShape.area.map((x) => (x._1 + gameBoard.currPos._1 + 1, x._2 + gameBoard.currPos._2)))) {
//          gameBoard.addShape()
//          for (tile <- realArea) {
//            tiles(tile._1)(tile._2) = oldColor
//
//          }
//        }
//        else {
//          for(tile <- realArea) {
//            tiles(tile._1)(tile._2) = oldColor
//          }
//          gameBoard.paintShape(gameBoard.tickDown)
//          repaint()
//        }
//      }


      val buttonPanel = new JPanel()
      buttonPanel.setLayout(new BorderLayout())
      wholePanel.add(buttonPanel, BorderLayout.NORTH)

      setFocusable(true)



      val paintPanel = new JPanel() {
        override def paintComponent(g: Graphics) = {
          val tileSize = 25
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

      val startButton = new JButton("Start Game") {
        setFocusable(false)
        addActionListener(new ActionListener {
          override def actionPerformed(e: ActionEvent): Unit =
            println("START")
          paintPanel.repaint()
          setVisible(true)
        })
      }
      val resetButton = new JButton("Reset Game") {
        setFocusable(false)
        addActionListener(new ActionListener {
          override def actionPerformed(e: ActionEvent): Unit = {
            println("RESET")
            gameBoard.blankBoard()
            paintPanel.repaint()
          }})
      }

      buttonPanel.add(startButton, BorderLayout.WEST)
      buttonPanel.add(resetButton, BorderLayout.EAST)


      wholePanel.add(paintPanel, BorderLayout.CENTER)
      setContentPane(wholePanel)

      addKeyListener(new KeyAdapter {
        override def keyPressed(e: KeyEvent): Unit = {

          if(e.getKeyChar == 'a') {
            gameBoard.paintShape(gameBoard.moveLeft)
            repaint()
//            println("COORD = " + gameBoard.currPos)
//            for (i <- 0 until gameBoard.currShape.area.length) {
//              println(gameBoard.currShape.area(i))
//            }
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
           // println("COORD = " + gameBoard.currPos)
//            for (i <- 0 until gameBoard.currShape.area.length) {
//              println(gameBoard.currShape.area(i))
//            }
          }

          if(e.getKeyChar == 's') {
            gameBoard.paintShape(gameBoard.tickDown)
            repaint()
//            println("COORD = " + gameBoard.currPos)
//            for (i <- 0 until gameBoard.currShape.area.length) {
//              println(gameBoard.currShape.area(i))
//            }
          }

          if(e.getKeyChar == 'q') {
            gameBoard.paintShape(gameBoard.rotateCCW)
            repaint()
//            println("COORD = " + gameBoard.currPos)
//            for (i <- 0 until gameBoard.currShape.area.length) {
//              println(gameBoard.currShape.area(i))
//            }
          }

          if(e.getKeyChar == 'e') {
            gameBoard.paintShape(gameBoard.rotateCCW)
            repaint()
//            println("COORD = " + gameBoard.currPos)
//            for (i <- 0 until gameBoard.currShape.area.length) {
//              println(gameBoard.currShape.area(i))
//            }
          }

          if(e.getKeyChar == 'n') {
            gameBoard.addShape()
            //gameBoard.paintShape(() => {})
            repaint()
            println("NEW SHAPE")
          }
        }
      })
      pack
      setVisible(true)
    }
  }
}
