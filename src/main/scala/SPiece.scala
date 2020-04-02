import java.awt.Color
case class SPiece(area: Array[(Int, Int)] = Array((0,1),(0,2),(1,0),(1,1))) extends GamePiece {
  override val color: Color = Color.green
  override val north: Array[(Int, Int)] = Array((0,1),(0,2),(1,0),(1,1))
  override val south: Array[(Int, Int)] = Array((0,1),(0,2),(1,0),(1,1))
  override val east: Array[(Int, Int)] = Array((0,0),(1,0),(1,1),(2,1))
  override val west: Array[(Int, Int)] = Array((0,0),(1,0),(1,1),(2,1))

  override def copy(tuples: Array[(Int, Int)]): GamePiece = SPiece(tuples)
}
