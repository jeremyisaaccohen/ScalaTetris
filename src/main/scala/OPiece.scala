import java.awt.Color
case class OPiece( area: Array[(Int, Int)] = Array((0,0),(0,1),(1,0),(1,1))) extends GamePiece {
  override val color: Color = Color.yellow
  override val north: Array[(Int, Int)] = Array((0,0),(0,1),(1,0),(1,1))
  override val south: Array[(Int, Int)] = Array((0,0),(0,1),(1,0),(1,1))
  override val east: Array[(Int, Int)] = Array((0,0),(0,1),(1,0),(1,1))
  override val west: Array[(Int, Int)] = Array((0,0),(0,1),(1,0),(1,1))

  override def copy(tuples: Array[(Int, Int)]): GamePiece = OPiece(tuples)
}
