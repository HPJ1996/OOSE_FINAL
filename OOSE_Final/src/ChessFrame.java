import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ChessFrame extends JFrame {
		
	protected static int WIDTH = 500;
	protected static int HEIGHT = 700;
	
	protected AbsChessPanel chessPanel;
	protected AbsChessBoardPanel chessBoardPanel;
	protected AbsScorePanel scorePanel;

	public ChessFrame(ChessPanelAbstractFactory factory) {
		super();
		this.createFrame(factory);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	protected void createFrame(ChessPanelAbstractFactory factory) {

		this.setTitle("OOSE ´Á¥½§@·~");
		this.setSize(WIDTH, HEIGHT);

		this.chessPanel = factory.createChessPanel();
		this.chessPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT-WIDTH-20));
		this.chessBoardPanel = factory.createChessBoardPanel();
		this.scorePanel = factory.createScorePanel();
		
		this.setLayout(new BorderLayout());
		this.add(this.chessPanel, BorderLayout.SOUTH);
		this.add(this.chessBoardPanel, BorderLayout.CENTER);
		this.add(this.scorePanel, BorderLayout.NORTH);

		this.chessPanel.setChessFrame(this);
		this.chessBoardPanel.setChessFrame(this);
		this.scorePanel.setChessFrame(this);
	}

	public void initialization() {
		chessPanel.initialization();
		chessBoardPanel.initialization();
		scorePanel.initialization();
	}

	public void winTheChess() {
		this.initialization();
	}

	public void chessPut() {
		chessPanel.nextChess();
	}

}
