import javax.swing.*;

public class ChessGameData {
    // Singleton
    private static ChessGameData uniqueInstance = null;

    public static int chessPutAmount = 0;

    public static int WIDTH = 10;
    boolean hasChess[][] =  new boolean[WIDTH][WIDTH];

    public static int NUMBER_OF_CHESS = 12;
    boolean chessHasUse[] = new boolean[NUMBER_OF_CHESS];
    Chess nowChess;

    public static ImageIcon BLACK_BALL = new ImageIcon("black_ball.png");
    public static ImageIcon WHITE_BALL = new ImageIcon("white_ball.png");

    public static ChessGameData getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new ChessGameData();
        }
        return uniqueInstance;
    }

    private ChessGameData() {
        for(int i=0; i<ChessGameData.NUMBER_OF_CHESS; i++) {
            this.chessHasUse[i] = false;
        }
    }
}
