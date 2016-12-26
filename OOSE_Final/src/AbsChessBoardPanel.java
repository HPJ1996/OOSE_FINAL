import javax.swing.*;

@SuppressWarnings("serial")
public abstract class AbsChessBoardPanel extends JPanel {

    public static int WIDTH = 10;
    protected JButton[][] button = new JButton[WIDTH][WIDTH];

    ChessGameData gameData = ChessGameData.getInstance();
    protected ChessFrame chessFrame;

    public void setChessFrame(ChessFrame chessFrame) {
        this.chessFrame = chessFrame;
    }

    protected void clickButton(int row, int column) {
        boolean[][] nowChessShape = gameData.nowChess.getShape();
        System.out.print("Click " + row + "  " + column + " ;");

        if(canPutChess(row, column, nowChessShape) == true) {
            putChess(row, column, nowChessShape);
        }
    }

    abstract protected boolean canPutChess(int row, int column, boolean[][] nowChessShape);
    abstract protected void putChess(int row, int column, boolean[][] nowChessShape);
    abstract public void initialization();

}
