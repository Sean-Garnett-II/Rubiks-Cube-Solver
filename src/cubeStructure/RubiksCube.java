package cubeStructure;

// TODO write a way to input a cube state

public class RubiksCube {
	static Cubie[][][] cubicles = new Cubie[3][3][3];

	public RubiksCube() {

		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					// determines the number of facelets a cubie can have
					int c = 3 - i % 2 - j % 2 - k % 2;

					switch (c) {
					case 0:
						cubicles[i][j][k] = new Cubie();
						break;
					case 1:
						cubicles[i][j][k] = new Cubie(new Facelet('X', i, j, k));
						break;
					case 2:
						if (i % 2 == 1) {
							cubicles[i][j][k] = new Cubie(new Facelet('a', i, 1, k), new Facelet('b', i, j, 1));
						} else if (j % 2 == 1) {
							cubicles[i][j][k] = new Cubie(new Facelet('a', 1, j, k), new Facelet('b', i, j, 1));
						} else if (k % 2 == 1) {
							cubicles[i][j][k] = new Cubie(new Facelet('a', 1, j, k), new Facelet('b', i, 1, k));
						}
						break;
					case 3:
						cubicles[i][j][k] = new Cubie(new Facelet('A', i, 1, 1), new Facelet('B', 1, j, 1),
								new Facelet('C', 1, 1, k));
						break;
					}
				}
			}
		}
	}

	public static void rotate(int x, int y, int z) {
		Cubie[][] tmpCubie = new Cubie[3][3];
		int tmpX, tmpY, tmpZ;

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				tmpCubie[i][j] = cubicles[i][j][z];
			}
		}

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {

				for (int c = 0; c < (3 - i % 2 - j % 2); c++) {
					tmpX = cubicles[i][j][z].face[c].pointer[0];
					tmpY = cubicles[i][j][z].face[c].pointer[1];

					cubicles[i][j][z].face[c].pointer[0] = 2 - tmpY;
					cubicles[i][j][z].face[c].pointer[1] = tmpX;

				}

				cubicles[i][j][z] = tmpCubie[j][2 - i];

			}
		}

	}

	public void printCube() {

		// prints the top face
		for (int k = 2; k > -1; k--) {
			for (int i = 0; i < 3; i++) {
				printFColor(i, 0, k, 1, 0, 1);
			}
			System.out.println();
		}
		System.out.println();

		// prints the Rows in order: Front Right Back Left
		for (int j = 0; j < 3; j++) {

			for (int i = 0; i < 3; i++) {
				printFColor(i, j, 0, 1, 1, 0);
			}

			System.out.print(" ");

			for (int k = 0; k < 3; k++) {
				printFColor(2, j, k, 2, 1, 1);
			}

			System.out.print(" ");

			for (int i = 2; i > 0 - 1; i--) {
				printFColor(i, j, 2, 1, 1, 2);
			}

			System.out.print(" ");

			for (int k = 2; k > 0 - 1; k--) {
				printFColor(0, j, k, 0, 1, 1);
			}
			System.out.println();
		}

		System.out.println();

		// prints the Down (bottom) face
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				printFColor(i, 2, k, 1, 2, 1);
			}
			System.out.println();
		}
	}

	public void printFColor(int i, int j, int k, int x, int y, int z) {
		for (int c = 0; c < (3 - i % 2 - j % 2 - k % 2); c++) {
			if (cubicles[i][j][k].face[c].pointer[0] == x && cubicles[i][j][k].face[c].pointer[1] == y
					&& cubicles[i][j][k].face[c].pointer[2] == z) {
				System.out.print(cubicles[i][j][k].face[c].getColor());
			}
		}
	}

}
