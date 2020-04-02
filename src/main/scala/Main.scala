import java.awt.Color

import javax.swing.Timer

object Main {
  def main(args: Array[String]): Unit = {

    val gameBoard = new Board()

    gameBoard.removeRows()


//    println(gameBoard.currShape)
//    println(gameBoard.prevShape)
//    gameBoard.currShape.rotateCCW()
//    println(gameBoard.currShape.area)
//    println(gameBoard.prevShape.area)




//    val board = new Board()
//    board.paintShape(() => {})
//    board.printShapeArea()
//    println("")
//    board.paintShape(board.rotateCCW)
//    board.printShapeArea()


//    println(board.tiles(0)(4))
//    println(board.tiles(0)(5))
//    board.paintShape(board.moveRight)
//    println(board.tiles(0)(4))
//    println(board.tiles(0)(5))
//    board.paintShape(board.moveLeft)
//    println(board.tiles(0)(4))
//    println(board.tiles(0)(5))
//    board.paintShape(board.moveLeft)
//    println(board.tiles(0)(4))
//    println(board.tiles(0)(5))


    //    println(board.currShape)
//    for (i <- 0 until board.currShape.area.length) {
//      println(board.currShape.area(i))
//    }
//    println( "")
//    board.rotateCW()
//    for (i <- 0 until board.currShape.area.length) {
//      println(board.currShape.area(i))
//    }
//    println( "")

//    println(board.currShape)
//    board.rotateCW()
//    println(board.currShape)
//    board.rotateCW()
//    board.rotateCW()
//    board.rotateCCW()
//    println(board.currShape)

//    println(board.currShape.toString)
//    println(board.currShape.toString)
//    println(board.currShape.rotateCW().toString)
//    println(board.currShape.rotateCW().toString)
//    println(board.currShape.rotateCW().toString)
//    println(board.currShape.rotateCCW().toString)
//    println(board.currShape.rotateCCW().toString)
//    println(board.currShape.rotateCCW().toString)


//    println("\n  \n \n\n\n\n\n\n\n\n\n\n\n\n\n \n")
//
//    board.paintShape()



//    for(x <- board.tiles) {
//      println("NEW ROW         ! ! ! ! ! ! !L@!J@L!JL@JL!J@L!JL@!L@L!K@LK!LK@!LK@L!K@L!@KL!K@L!@K!LK@L!K@L!K")
//      for (y <- x) {
//        println(y.toString)
//      }
//    }

//    board.tickDown()
//    board.tickDown()
//    board.tickDown()
//    board.tickDown()
//    board.moveRight()
//    board.moveRight()
//    board.currShape.rotateCW()

//    board.currShape.rotateCW()
//    board.paintShape()
//
//    println()
//    println()
//    println("down 4 right 2 and CW rot")
//
//    for(x <- board.tiles) {
//      println("NEW ROW         ! ! ! ! ! ! !L@!J@L!JL@JL!J@L!JL@!L@L!K@LK!LK@!LK@L!K@L!@KL!K@L!@K!LK@L!K@L!K")
//      for (y <- x) {
//        println(y.toString)
//      }
//    }
//
//
//
//
//
//    println("OG BOARD :")
////    for( arr <- board.tiles) {
////      for(tile <- arr)
////      print(tile)
////    }
//
//    println()
//    println("NEW")

    //println(board.tiles.)



//    //TODO : ROTATE WORKS
//    println("BEGINNING SHAPE AREA: " +
//      "" +
//      "")
//    board.printShapeArea()
//    println("NEW ROTATED CW : " +
//      "" +
//      "")
//
//
//    board.rotateCW()
//    board.printShapeArea()
//    println("ROTATE BACK")
//    board.rotateCCW()
//    board.printShapeArea()
//    println("ROTATE CCW")
//    board.rotateCCW()
//    board.printShapeArea()
//    println("ROTATE CCW")
//    board.rotateCCW()
//    board.printShapeArea()
//    println("ROTATE CCW")
//    board.rotateCCW()
//    board.printShapeArea()
//    println("ROTATE CCW")
//    board.rotateCCW()
//    board.printShapeArea()

//    board.printShapeArea()
//    board.convertCoords(board.currShape.area)
//    println("converted")
//    board.printShapeArea()
    
//    println(board.tiles(0)(3))
//    board.addShape(new IPiece())
//    println(board.tiles(0)(3))
//    board.tiles(0)(3) = Color.BLACK

//    println("NEW SHIT" +
//    "" +
//    "" +
//    "" +
//    "" +
//    "" +
//    "")

    // println("AREA IS : " + board.currShape.area)
    ///for (x <- currPiece.area) {
   /// task.cancel()


  //  }
    //for (x <- currPiece.area) {println(x._2)}
//    for (i <- 0 to 3) {
//      val (x, y) = board.currShape.area(i)
//      println("X: " + x + " Y: " + y)
//    }

//    board.printCurrArea()
//    board.tickShape()
//    println("TICKED")
//    board.printCurrArea()
//    board.tickShape()
//    for (i <- 0 to 3) {
//      val (x, y) = board.currShape.area(i)
//      println("X: " + x + " Y: " + y)
//    }
    //println(board.printCurrArea())

   // Thread.sleep(100)
   // println(board.printCurrArea())
    //board.tickShape()
    //print(board.printCurrArea())


  }

}
