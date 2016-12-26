
public class ChessGame {
	
	public ChessGame() {
		ChessPanelFactory chessPanelFactory = new ChessPanelFactory();
		
		ChessFrame chessFrame = new ChessFrame(chessPanelFactory);
		chessFrame.setVisible(true);
	}
}
