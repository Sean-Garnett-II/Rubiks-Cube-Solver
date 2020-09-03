package cubeStructure;

// TODO write a way to input a cube state

public class RubiksCube {
	static Cubie[][][] cubicles = new Cubie[3][3][3];

	public RubiksCube() {

		// top right cubicle on the front face is index 0,0,0
		// +x is right, +y is down, +z is into the cube
		// the default facelet 'color' indicates what index that facelt is in its cubie
		// center face cubies all have X
		// a Cubie that holds only 2 facelets has a = first index, b = second index
		// a Cubie that holds 3 facelets has A = first index, B = second index, C =
		// third index
		// the center cubie (1,1,1) holds no facelets and SHOULD NOT BE REFERENCED
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {

					// determines the number of facelets a cubie can have
					int faceletCount = 3 - i % 2 - j % 2 - k % 2;

					switch (faceletCount) {
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

	public static void rotate(int x, int y, int z, int orientation) {
		// rotates a face given its home plate coordiantes.
		// the rotation follows positive orientation for the cube (think right hand
		// rule)
		// +1 for positive rotation orientation
		// -1 for negative rotation orientation
		// Method steps
		// 1. copy face cubicles
		// 2. update facelet pointers to their destination
		// 3. move cubicles

		Cubie[][] tmpCubicle = new Cubie[3][3];
		int tmpX, tmpY, tmpZ, wght1, wght2;

		switch (orientation) {
		case 1:
			wght1 = 0;
			wght2 = 2;
			break;
		case -1:
			wght1 = 2;
			wght2 = 0;
			break;
		default:
			return;
		}

		if (x % 2 == 0) {
			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < 3; j++) {
					tmpCubicle[j][k] = cubicles[x][j][k];
				}
			}

			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < 3; j++) {

					for (int c = 0; c < (3 - j % 2 - k % 2); c++) {
						tmpY = cubicles[x][j][k].face[c].pointer[1];
						tmpZ = cubicles[x][j][k].face[c].pointer[2];

						cubicles[x][j][k].face[c].pointer[1] = Math.abs(2 - wght1 - tmpZ);
						cubicles[x][j][k].face[c].pointer[2] = Math.abs(2 - wght2 - tmpY);

					}

					cubicles[x][j][k] = tmpCubicle[Math.abs(2 - wght2 - k)][Math.abs(2 - wght1 - j)];
				}
			}
		}

		if (y % 2 == 0) {
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {
					tmpCubicle[i][k] = cubicles[i][y][k];
				}
			}

			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {

					for (int c = 0; c < (3 - i % 2 - k % 2); c++) {
						tmpX = cubicles[i][y][k].face[c].pointer[0];
						tmpZ = cubicles[i][y][k].face[c].pointer[2];

						cubicles[i][y][k].face[c].pointer[0] = Math.abs(2 - wght2 - tmpZ);
						cubicles[i][y][k].face[c].pointer[2] = Math.abs(2 - wght1 - tmpX);
					}

					cubicles[i][y][k] = tmpCubicle[Math.abs(2 - wght1 - k)][Math.abs(2 - wght2 - i)];
				}
			}
		}

		if (z % 2 == 0) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					tmpCubicle[i][j] = cubicles[i][j][z];
				}
			}

			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {

					for (int c = 0; c < (3 - i % 2 - j % 2); c++) {
						tmpX = cubicles[i][j][z].face[c].pointer[0];
						tmpY = cubicles[i][j][z].face[c].pointer[1];

						cubicles[i][j][z].face[c].pointer[0] = Math.abs(2 - wght1 - tmpY);
						cubicles[i][j][z].face[c].pointer[1] = Math.abs(2 - wght2 - tmpX);
					}

					cubicles[i][j][z] = tmpCubicle[Math.abs(2 - wght2 - j)][Math.abs(2 - wght1 - i)];
				}
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

	public void setCube(char frontF, char rightF, char backF, char leftF, char topF, char downF) {
		// sets the Front face
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				setFace(i, j, 0, 1, 1, 0, frontF);
			}
		}

		// sets the Right face
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				setFace(2, j, k, 2, 1, 1, rightF);
			}
		}

		// sets the Left face
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				setFace(0, j, k, 0, 1, 1, leftF);
			}
		}

		// sets the Back face
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				setFace(i, j, 2, 1, 1, 2, backF);
			}
		}

		// sets the top face
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				setFace(i, 0, k, 1, 0, 1, topF);
			}
		}

		// sets the Down face
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				setFace(i, 2, k, 1, 2, 1, downF);
			}
		}

	}

	public void setFace(int i, int j, int k, int x, int y, int z, char color) {
		for (int c = 0; c < (3 - i % 2 - j % 2 - k % 2); c++) {
			if (checkPointer(i, j, k, x, y, z, c) == true) {
				cubicles[i][j][k].face[c].setColor(color);
			}
		}
	}

	public void printFColor(int i, int j, int k, int x, int y, int z) {
		for (int c = 0; c < (3 - i % 2 - j % 2 - k % 2); c++) {
			if (checkPointer(i, j, k, x, y, z, c) == true) {
				System.out.print(cubicles[i][j][k].face[c].getColor());
			}
		}
	}

	public boolean checkPointer(int i, int j, int k, int x, int y, int z, int c) {
		if (cubicles[i][j][k].face[c].pointer[0] == x && cubicles[i][j][k].face[c].pointer[1] == y
				&& cubicles[i][j][k].face[c].pointer[2] == z) {
			return true;
		} else {
			return false;
		}
	}
}
