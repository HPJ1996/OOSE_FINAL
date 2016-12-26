
abstract public class AbsChess implements CanRotate, CanFlip {
	
	public static int LENGTH = 4;

	protected int chessNumber;
	
	protected boolean[][] shape = new boolean[LENGTH][LENGTH];
	
	public boolean[][] getShape() {
		return shape;
	}

	public int getChessNumber() {
		return this.chessNumber;
	}

	public void setShape(boolean[][] shape) {
		this.shape = shape;
	}

	@Override
	abstract public void rotate();

	@Override
	abstract public void flip();
	
}
