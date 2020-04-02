import java.awt.Color
case class TPiece(area: Array[(Int, Int)] = Array((0,1),(1,0),(1,1),(1,2))) extends GamePiece {
  override val color: Color = Color.magenta
  override val north: Array[(Int, Int)] = Array((0,1),(1,0),(1,1),(1,2))
  override val south: Array[(Int, Int)] = Array((0,0),(0,1),(0,2),(1,1))
  override val east: Array[(Int, Int)] = Array((0,0),(1,0),(2,0),(1,1))
  override val west: Array[(Int, Int)] = Array((0,1),(1,0),(1,1),(2,1))

  override def copy(tuples: Array[(Int, Int)]): GamePiece = TPiece(tuples)
}
