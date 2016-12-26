
public class Transfer {
	public boolean[][] doTransfer(boolean[][] input) {
		int length = input.length;
		boolean[][] array = new boolean[length][length];
		for(int i=0; i<length; i++) {
			for(int j=0; j<length; j++) {
				array[j][length-i-1] = input[i][j];
			}
		}

		boolean leftIsBlank;
		do {
			leftIsBlank = false;
			int leftBlankCount = 0;
			for(int i=0; i<length; i++) {
				if(array[i][0] == false) {
					leftBlankCount += 1;
				}
			}
			if(leftBlankCount >= length) {
				leftIsBlank = true;
				for(int i=0; i<length; i++) {
					int j = 0;
					for(; j<length-1; j++) {
						array[i][j] = array[i][j+1];
					}
					array[i][length-1] = false;
				}
			}
		} while(leftIsBlank);

		return array;
	}
}
