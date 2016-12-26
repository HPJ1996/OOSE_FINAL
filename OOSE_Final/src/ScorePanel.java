import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Timer;
import java.awt.GridLayout;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class ScorePanel extends AbsScorePanel implements ActionListener {

	JLabel time;
	JButton btnRestart;

	private DecimalFormat df = new DecimalFormat("#00");
	private Timer timer = new Timer();
	long startTime;
	long runTime;

	public ScorePanel() {
		this.setLayout(new GridLayout(1, 2));

		time = new JLabel("", SwingConstants.CENTER);
		this.add(time);

		btnRestart = new JButton("Restart");
		btnRestart.addActionListener(this);
		this.add(btnRestart);

		initialization();
		timer.schedule(new CountingTimerTask(), 0, 1000);
	}

	public void initialization() {
		startTime = System.currentTimeMillis();
		setTimeLabel(runTime);
        ChessGameData.chessPutAmount = 0;
	}

	public void setTimeLabel(long runtime) {
		String message = "Gaming Time: " + df.format((runtime/1000)/60) + ":" +  df.format((runtime/1000)%60) +
                ", Have Put " + df.format(ChessGameData.chessPutAmount) + " Chess";
		time.setText(message);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRestart) {
            chessFrame.initialization();
		}
	}

	public class CountingTimerTask extends TimerTask {
		@Override
		public void run() {
			runTime = (System.currentTimeMillis() - startTime);
			setTimeLabel(runTime);
		}
	}

}