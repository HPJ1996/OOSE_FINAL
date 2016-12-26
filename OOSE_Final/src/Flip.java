
public class Flip {
	public boolean[][] doFlip(boolean[][] input) {
		boolean[][] array = new boolean[input.length][input.length];
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input.length; j++) {
				array[input.length - i-1][j] = input[i][j];
			}
		}
		return array;
	}
}
