import java.awt.Color

trait GamePiece {
  val area: Array[(Int,Int)]
  val color: Color
  val north :Array[(Int,Int)]
  val south :Array[(Int,Int)]
  val east :Array[(Int,Int)]
  val west :Array[(Int,Int)]
  val pos = (Int, Int)

  def copy(tuples: Array[(Int, Int)]) :GamePiece

  def copy() :GamePiece = {
    this.copy(area)
  }

  override def clone(): AnyRef = this.copy(area)

//  def moveLeft(): GamePiece = {
//
//  }
//
//  def moveRight(): GamePiece = {
//
//  }
//
//  def moveDown(): GamePiece = {
//
//  }

   def rotateCW(): GamePiece = {
      if (area.deep == north.deep) {this.copy(east)}
      else if (area.deep == east.deep) {this.copy(south)}
      else if (area.deep == south.deep) {this.copy(west)}
      else {this.copy(north)}
   }

  def rotateCCW(): GamePiece = {
      if (area.deep == north.deep) {this.copy(west)}
      else if (area.deep == west.deep) {this.copy(south)}
      else if (area.deep == south.deep) {this.copy(east)}
      else {this.copy(north)}

  }




  //def rotateCW(): Array[(Int,Int)] = {
  //  val rotated = {
  //    if (area == north) {east}
  //    else if (area == east) {south}
  //    else if (area == south) {west}
  //    else {north}
  //  }
  //  rotated
  //}

//def rotateCCW(): Array[(Int,Int)] = {
//  val rotated = {
//    if (area == north) {(west)}
//    else if (area == west) {(south)}
//    else if (area == south) {(east)}
//    else {(north)}
//  }
//  rotated
//}




}
