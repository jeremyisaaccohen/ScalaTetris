import java.awt.Color
case class IPiece(area: Array[(Int, Int)] = Array((0,0),(0,1),(0,2),(0,3))) extends GamePiece {
  override val color: Color = Color.cyan
  override val north: Array[(Int, Int)] = Array((0, 0), (0, 1), (0, 2), (0, 3))
  override val south: Array[(Int, Int)] = Array((0, 0), (0, 1), (0, 2), (0, 3))
  override val east: Array[(Int, Int)] = Array((0, 0), (1, 0), (2, 0), (3, 0))
  override val west: Array[(Int, Int)] = Array((0, 0), (1, 0), (2, 0), (3, 0))

  override def copy(tuples: Array[(Int, Int)]): GamePiece = IPiece(tuples)

}
