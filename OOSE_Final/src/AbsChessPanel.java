import javax.swing.*;

@SuppressWarnings("serial")
public abstract class AbsChessPanel extends JPanel {

    ChessGameData gameData = ChessGameData.getInstance();
    protected ChessFrame chessFrame;

    public void setChessFrame(ChessFrame chessFrame) {
        this.chessFrame = chessFrame;
    }

    protected JPanel nowChessPanel;
    protected JLabel[][] nowChess = new JLabel[AbsChess.LENGTH][AbsChess.LENGTH];

    public void showChess(boolean[][] shape) {
        for(int i=0; i<nowChess.length; i++) {
            for(int j=0; j<nowChess.length; j++) {
                if(shape[i][j]) {
                    nowChess[i][j].setIcon(ChessGameData.BLACK_BALL);
                } else {
                    nowChess[i][j].setIcon(null);
                }
            }
        }
    }

    abstract public void initialization();
    abstract public void nextChess();
}
