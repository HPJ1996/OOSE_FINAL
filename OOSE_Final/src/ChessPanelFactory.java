
public class ChessPanelFactory extends ChessPanelAbstractFactory {

	@Override
	public AbsChessPanel createChessPanel() {
		AbsChessPanel chessPanel = new ChessPanel();
		return chessPanel;
	}

	@Override
	public AbsChessBoardPanel createChessBoardPanel() {
		AbsChessBoardPanel chessBoardPanel = new ChessBoardPanel();
		return chessBoardPanel;
	}

	@Override
	public AbsScorePanel createScorePanel() {
		AbsScorePanel scorePanel = new ScorePanel();
		return scorePanel;
	}
	
}
