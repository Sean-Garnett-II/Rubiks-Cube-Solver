package cubeStructure;

// need to write a method to input all values of a face

public class Face {
	private char[][] face = new char[3][3];

	public Face() {
		// fills the array with ▆ '\u2586'
		for (int r = 0; r < this.face.length; r++) {
			for (int c = 0; c < this.face[0].length; c++) {
				setIndex(r, c, '\u2586');
			}
		}
	}

	public Face(char tmp) {
		// fills the array with given character
		for (int r = 0; r < this.face.length; r++) {
			for (int c = 0; c < this.face[0].length; c++) {
				setIndex(r, c, tmp);
			}
		}

	}

	public void printSimple() {

		for (int r = 0; r < this.face.length; r++) {
			for (int c = 0; c < this.face[0].length; c++) {
				System.out.print(this.face[r][c]);
				System.out.print(", ");
			}
			System.out.println();

		}

		System.out.println();
	}

	public void printGrid() {

		System.out.println("┌─┬─┬─┐");

		for (int r = 0; r < this.face.length; r++) {
			printRow(r);
			System.out.println();

			if (r < 2) {
				System.out.println("├─┼─┼─┤");
			}
		}

		System.out.print("└─┴─┴─┘");
	}

	public void printRow(int r) {
		for (int c = 0; c < this.face[0].length; c++) {
			System.out.print("│");
			System.out.print(this.face[r][c]);
		}
		System.out.print("│");
	}

	public void setIndex(int r, int c, char tmp) {
		this.face[r][c] = tmp;
	}

	public void setRow(int r, char[] tmp) {
		this.face[r] = tmp;

	}

	public void setColumn(int c, char[] tmp) {
		for (int r = 0; r < this.face.length; r++) {
			this.face[r][c] = tmp[r];
		}

	}

	public char getInxed(int r, int c) {
		return this.face[r][c];
	}

	public char[] getRow(int r) {
		return this.face[r];
	}

	public char[] getColumn(int c) {
		char[] tmp = new char[3];

		for (int r = 0; r < this.face.length; r++) {
			tmp[r] = this.face[r][c];
		}

		return tmp;
	}

	public void invertRow(int r) {
		char[] tmp = new char[3];

		for (int c = 0; c < this.face[r].length; c++) {
			tmp[c] = getRow(r)[2 - c];
		}
		setRow(r, tmp);
	}

	public void invertColumn(int c) {
		char[] tmp = new char[3];
		
		for (int r = 0; r < this.face.length; r++) {
			tmp[r]=getColumn(c)[2-r];
		}
		setColumn(c, tmp);
	}

	// 90 degree rotation clockwise
	public void rotate() {
		char[][] tmp = new char[3][3];

		for (int r = 0; r < this.face.length; r++) {
			for (int c = 0; c < this.face[0].length; c++) {
				tmp[r][this.face[0].length - 1 - c] = this.face[c][r];
			}
		}

		this.face = tmp;
	}

	// 90 degree rotation counterclockwise
	public void counterRotate() {
		char[][] tmp = new char[3][3];

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				tmp[3 - 1 - c][r] = this.face[r][c];
			}
		}
		this.face = tmp;
	}

}