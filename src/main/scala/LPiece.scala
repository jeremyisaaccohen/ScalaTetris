import java.awt.Color
case class LPiece(area: Array[(Int, Int)] = Array((0,0),(1,0),(1,1),(1,2))) extends GamePiece {
  override val color: Color = Color.blue
  override val north: Array[(Int, Int)] = Array((0,0),(1,0),(1,1),(1,2))
  override val south: Array[(Int, Int)] = Array((0,0),(0,1),(0,2),(1,2))
  override val east: Array[(Int, Int)] = Array((0,0),(0,1),(1,0),(2,0))
  override val west: Array[(Int, Int)] = Array((0,1),(1,1),(2,0),(2,1))

  override def copy(tuples: Array[(Int, Int)]): GamePiece = LPiece(tuples)
}
