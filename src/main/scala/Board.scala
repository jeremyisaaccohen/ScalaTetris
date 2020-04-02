import java.awt.{Color, Component, Dimension}
import java.awt.event.{ActionEvent, ActionListener}
import java.util.Timer
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

import javax.swing.plaf.ColorUIResource
import javax.swing.{JButton, JFrame, JPanel}

class Board  {

  var score = 0

  var currShape :GamePiece = SPiece()
  var prevShape :GamePiece = currShape.copy()
  var currPos : (Int,Int) = (0,4) //position of top left corner shape grid, reset to top middle whenever piece is settled ;; (0,4) is roughly middle top
  var tiles:Array[Array[Color]] = Array.fill(22,10)(Color.black)


  object Timer {
    def apply(interval: Int, repeats: Boolean = true)(op: => Unit) {
      val timeOut = new javax.swing.AbstractAction() {
        def actionPerformed(e : java.awt.event.ActionEvent) = op
      }
      val t = new javax.swing.Timer(interval, timeOut)
      t.setRepeats(repeats)
      t.start()
    }
  }


  //Timer
//  val t = new java.util.Timer()
//  val task = new java.util.TimerTask {
//    //tickShape will go here
//    def run() = tickDown()
//    println("Timer Went Off")
//  }
//  t.schedule(task, 1000, 100000)
//  // task.cancel()

  def blankBoard():Unit = {
    addShape()
    currPos = (0,4)
    tiles = Array.fill(22,10)(Color.black)
//    for (i <- 0 until tiles.length) {
//      for (j <- 0 until tiles(0).length) {
//        tiles(i)(j) = Color.black
//      }
    }
//    currPos = (0,4)
//    tiles = Array.fill(22,10)(Color.black)

  def stuck():Boolean = {
    //val piece = pieceCoords()
    val piece = this.currShape.copy()
//    val rightArea = piece.area.map(x => (x._1, x._2 + 1))
//    val leftArea = piece.area.map(x => (x._1, x._2 - 1))
//    val rcwArea = piece.rotateCW().area
//    val rccwArea = piece.rotateCCW().area
    val downArea = piece.area.map(x => (x._1 + 1, x._2))

    if(isValid(downArea)) {
      false
    }
    else true
  }


  def makeRed() = {
    tiles(15)(3) = Color.RED
  }

  def removeRow(rowNum : Int) = {
    for (tile <- 0 until 10) {
      tiles(rowNum)(tile) = Color.BLACK
    }
  }

//  def shiftDownFrom(num: Int): Unit = {
//    for (row <- 21 to num) {
//      for (col <- 0 until 10)
//        if(row > 0 ) {
//          tiles(row)(col) = tiles(row - 1)(col)
//        }
//      println("REMOVE ROW")
//    }
//  }

  def shiftDownFrom(i: Int) = {
    val num = 21 - i
    for(row <- 1 to num)
      for (col <- 0 until 10) {
        tiles(row)(col) = tiles(row - 1)(col)
      }
  }


  def removeRows() = {
    var rowNum :Int = 21
    for (row <- tiles) {
     // if (rowNum >= 0) {
        var toRemove: Boolean = true
        for (tile <- row) {
          if (tile == Color.black) {
            toRemove = false
          }
        }
        if (toRemove) {
          println("ROW TO REMOVE NUM: " + rowNum)
          shiftDownFrom(rowNum)
        }
        rowNum -= 1
      //}
    }

    }



  def isValid(area: Array[(Int, Int)]): Boolean = {
    val newTiles = tiles.clone()
//    for(tile <- area) {
//      newTiles(tile._1 + currPos._1)(tile._2 + currPos._2) = Color.black
//    }

    for(tile <- area) {
      if (tile._1 + currPos._1 > 21 || tile._1 + currPos._1 < 0 ||  tile._2 + currPos._2 > 9 || tile._2 + currPos._2 < 0 || newTiles(tile._1 + currPos._1)(tile._2 + currPos._2) != Color.BLACK)
      return false
    }
    true
  }
  def moveLeft() = {
    val newArea = currShape.area.map(x => (x._1, x._2 - 1))
    if (isValid(newArea)) {
      currPos = (currPos._1, currPos._2 - 1)

    }
//    if (currPos._2 - 1 >= 0) {
//      currPos = (currPos._1, currPos._2 - 1)
//    }
  }
  def moveRight() = {
    val newArea = currShape.area.map(x => (x._1, x._2 + 1))
    if (isValid(newArea)) {
      currPos = (currPos._1, currPos._2 + 1)
    }
//    val rightMost:Int = currShape.area.map((x) => x._2).max
//    if (currPos._2 + rightMost + 1 <= 9) {
//      currPos = (currPos._1, currPos._2 + 1)
//    }
  }
  def tickDown() = {
    val newArea = currShape.area.map(x => (x._1 + 1, x._2))
    if (isValid(newArea)) {
      currPos = (currPos._1 + 1, currPos._2)

    }
    //    val downMost: Int = currShape.area.map((x) => x._1).max
//    if(currPos._1 + downMost + 1 <= 21)
//      currPos = (currPos._1 + 1, currPos._2)
  }
  def rotateCW() = {
    val newArea = currShape.rotateCW().area
    if (isValid(newArea)) {
      currShape = currShape.rotateCW()
    }
  }
  def rotateCCW() = {
    val newArea = currShape.rotateCCW().area
    if(isValid(newArea)) {
      currShape = currShape.rotateCCW()
    }
  }

  def paintShape(translation: () => Unit): Unit = {
    val toBlack: Array[(Int, Int)] = currShape.area.map((x) => (x._1 + currPos._1, x._2 + currPos._2))
    for(tile <- toBlack) {
      tiles(tile._1)(tile._2) = Color.black
    }
    translation()
    val toPaint: Array[(Int,Int)] = currShape.area.map((x) => (x._1 + currPos._1, x._2 + currPos._2))
    for (tile <- toPaint) {
      tiles(tile._1)(tile._2) = currShape.color
    }
  }

  def printShapeArea() ={
    for (i <- 0 to 3) {
      val (x, y) = currShape.area(i)
      println("X: " + x + " Y: " + y)
    }
  }

  def addShape(): Unit = {

    currPos = (0, 4)

    val random = new scala.util.Random
    val rand = random.nextInt(7)

    if (rand == 0) {
      currShape = LPiece()
    }
    if (rand == 1) {
      currShape = SPiece()
    }
    if (rand == 2) {
      currShape = TPiece()
    }
    if (rand == 3) {
      currShape = ZPiece()
    }
    if (rand == 4) {
      currShape = OPiece()
    }
    if (rand == 5) {
      currShape = IPiece()
    }
    if (rand == 6) {
      currShape = JPiece()
    }

  }

}

