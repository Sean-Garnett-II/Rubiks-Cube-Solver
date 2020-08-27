package cubeStructure;

// need to write a method to input all values of a face

public class Face {
	char[][] face = new char[3][3];

	public Face() {
		// fills the array with ▆
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				this.face[r][c] = '\u2586';
			}
		}
	}

	public Face(char var) {
		// fills the array with given char
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				this.face[r][c] = var;
			}
		}

	}

	public void printSimple() {

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				System.out.print(this.face[r][c]);
				if (c < 2) {
					System.out.print(" ,");
				} else if (c == 2) {
					System.out.println();
				}
			}
		}
		System.out.println();
	}

	public void printGrid() {
		System.out.println("┌─┬─┬─┐");

		for (int r = 0; r < 3; r++) {
			System.out.print("│");
			for (int c = 0; c < 3; c++) {
				System.out.print(this.face[r][c]);
				System.out.print("│");
			}

			if (r < 2) {
				System.out.println();
				System.out.println("├─┼─┼─┤");
			}
		}

		System.out.println();
		System.out.print("└─┴─┴─┘");
	}

	public void printRow(int r) {
		for (int c = 0; c < 3; c++) {
			if (c == 0) {
				System.out.print("│");
			}
			System.out.print(this.face[r][c]);
			System.out.print("│");
		}
	}

	public void set(int r, int c, char var) {
		this.face[r][c] = var;
	}

	public void setRow() {

	}

	public void setColumn() {

	}

	// 90 degree rotation clockwise
	public void rotate() {
		char[][] temp = new char[3][3];

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				temp[r][3 - 1 - c] = this.face[c][r];
			}
		}

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				this.face[r][c] = temp[r][c];
			}
		}
	}

	// 90 degree rotation counterclockwise
	public void counterRotate() {
		char[][] temp = new char[3][3];

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				temp[3 - 1 - c][r] = this.face[r][c];
			}
		}

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				this.face[r][c] = temp[r][c];
			}
		}
	}

}