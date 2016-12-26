import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbsScorePanel extends JPanel {

    protected ChessFrame chessFrame;

    public void setChessFrame(ChessFrame chessFrame) {
        this.chessFrame = chessFrame;
    }

    abstract public void initialization();
}
