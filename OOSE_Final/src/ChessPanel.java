import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

@SuppressWarnings("serial")
public class ChessPanel extends AbsChessPanel {

    JPanel controlChessPanel;
    JButton changeChessBtn;
    JButton rotateBtn;
    JButton flipBtn;

    Chess[] chesses = new Chess[ChessGameData.NUMBER_OF_CHESS];

    Random random = new Random();

	public ChessPanel() {
		createChess();
        this.setLayout(new BorderLayout());

        createControlPanel();
        this.add(controlChessPanel, BorderLayout.EAST);

        createNowChessPanel();
        this.add(nowChessPanel, BorderLayout.WEST);

        JPanel topSpace = new JPanel();
        topSpace.setPreferredSize(new Dimension(10, 10));
        topSpace.setBackground(Color.black);
        this.add(topSpace, BorderLayout.NORTH);

        initialization();
	}

	protected void createControlPanel() {
        controlChessPanel = new JPanel();
        controlChessPanel.setPreferredSize(new Dimension(310,180));
        controlChessPanel.setLayout(new GridLayout(1, 3));

        changeChessBtn = new JButton("Change");
        changeChessBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextChess();
            }
        });
        rotateBtn = new JButton("Rotate");
        rotateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameData.nowChess.rotate();
                showChess(gameData.nowChess.getShape());
            }
        });
        flipBtn = new JButton("Flip");
        flipBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameData.nowChess.flip();
                showChess(gameData.nowChess.getShape());
            }
        });

        controlChessPanel.add(changeChessBtn);
        controlChessPanel.add(rotateBtn);
        controlChessPanel.add(flipBtn);
    }

    protected void createNowChessPanel() {
        nowChessPanel = new JPanel();
        nowChessPanel.setPreferredSize(new Dimension(180, 180));
        int chessWidth = 4;
        nowChessPanel.setLayout(new GridLayout(chessWidth, chessWidth, 0, 0));
        for (int i = 0; i < chessWidth; i++) {
           for (int j = 0; j < chessWidth; j++) {
               JLabel newLabel = new JLabel();
               nowChess[i][j] = newLabel;
               nowChessPanel.add(newLabel);
            }
        }
    }

	protected void createChess(){
		chesses[0] = new Chess(StaticShape.shape0, 0);
		chesses[1] = new Chess(StaticShape.shape1, 1);
		chesses[2] = new Chess(StaticShape.shape2, 2);
		chesses[3] = new Chess(StaticShape.shape3, 3);
		chesses[4] = new Chess(StaticShape.shape4, 4);
		chesses[5] = new Chess(StaticShape.shape5, 5);
		chesses[6] = new Chess(StaticShape.shape6, 6);
		chesses[7] = new Chess(StaticShape.shape7, 7);
		chesses[8] = new Chess(StaticShape.shape8, 8);
		chesses[9] = new Chess(StaticShape.shape9, 9);
		chesses[10] = new Chess(StaticShape.shape10, 10);
		chesses[11] = new Chess(StaticShape.shape11, 11);
	}

	public void initialization() {
		for(int i=0; i<ChessGameData.NUMBER_OF_CHESS; i++) {
			gameData.chessHasUse[i] = false;
		}
		nextChess();
	}

	public void nextChess() {
        int randomNumber;
        do {
            randomNumber = random.nextInt(ChessGameData.NUMBER_OF_CHESS);
        }while(gameData.chessHasUse[randomNumber] == true);
        System.out.print("<<<"+randomNumber+">>>   ");
        gameData.nowChess = chesses[randomNumber];
        showChess(gameData.nowChess.getShape());
    }

}
