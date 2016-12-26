
public class Chess extends AbsChess {

	@Override
	public void rotate() {
		Transfer trans = new Transfer();
		this.shape = trans.doTransfer(shape);
	}

	@Override
	public void flip() {
		Flip flp = new Flip();
		this.shape = flp.doFlip(shape);
	}

	public Chess(boolean[][] shape, int number) {
		this.shape = shape;
		this.chessNumber = number;
	}

}
