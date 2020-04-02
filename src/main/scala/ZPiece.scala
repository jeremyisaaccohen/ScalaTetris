import java.awt.Color
case class ZPiece(area: Array[(Int, Int)] = Array((0,0),(0,1),(1,1),(1,2))) extends GamePiece {
  override val color: Color = Color.red
  override val north: Array[(Int, Int)] = Array((0,0),(0,1),(1,1),(1,2))
  override val south: Array[(Int, Int)] = Array((0,0),(0,1),(1,1),(1,2))
  override val east: Array[(Int, Int)] = Array((0,1),(1,0),(1,1),(2,0))
  override val west: Array[(Int, Int)] = Array((0,1),(1,0),(1,1),(2,0))

  override def copy(tuples: Array[(Int, Int)]): GamePiece = ZPiece(tuples)
}
