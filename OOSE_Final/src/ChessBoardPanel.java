import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ChessBoardPanel extends AbsChessBoardPanel {

	public ChessBoardPanel() {
        super();
		this.setLayout(new GridLayout(WIDTH, WIDTH, 0, 0));
        this.create();
		this.initialization();
	}

    public void create() {
        for(int i=0; i<WIDTH; i++) {
            for(int j=0; j<=i; j++) {
                JButton newButton = new JButton(ChessGameData.WHITE_BALL);
                newButton.setOpaque(false);
                newButton.setContentAreaFilled(false);
                newButton.setBorderPainted(false);

                final int i2 = i, j2 = j;
                newButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clickButton(i2, j2);
                    }
                });
                button[i][j] = newButton;
                gameData.hasChess[i][j] = false;

                this.add(newButton);
            }
            for(int j=i; j<WIDTH-1; j++) {
                this.add(new JLabel());
                gameData.hasChess[i][j] = true;
            }
        }
    }

    public void initialization() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j <= i; j++) {
                button[i][j].setIcon(ChessGameData.WHITE_BALL);
                gameData.hasChess[i][j] = false;
            }
        }
    }

    protected boolean canPutChess(int row, int column, boolean[][] nowChessShape) {
        boolean canPut = true;
        for(int i=0; i<nowChessShape.length && canPut == true; i++) {
            for(int j=0; j<nowChessShape.length && canPut == true; j++) {
                if(nowChessShape[i][j] == true) {
                    if( ((row+i) >= ChessGameData.WIDTH) || ((column+j) >= ChessGameData.WIDTH)) {
                        canPut = false;
                    } else if(gameData.hasChess[row+i][column+j] == true) {
                        canPut = false;
                    }
                }
            }
        }
        System.out.println(canPut);
        return canPut;
    }

    protected void putChess(int row, int column, boolean[][] nowChessShape) {
        for(int i=0; i<nowChessShape.length; i++) {
            for (int j = 0; j < nowChessShape.length; j++) {
                if (nowChessShape[i][j] == true) {
                    gameData.hasChess[row + i][column + j] = true;
                    this.button[row + i][column + j].setIcon(ChessGameData.BLACK_BALL);
                    gameData.chessHasUse[gameData.nowChess.getChessNumber()] = true;
                }
            }
        }
        ChessGameData.chessPutAmount += 1;
        if(ChessGameData.chessPutAmount >= ChessGameData.NUMBER_OF_CHESS) {
            chessFrame.winTheChess();
        } else {
            chessFrame.chessPut();
        }
    }

}
