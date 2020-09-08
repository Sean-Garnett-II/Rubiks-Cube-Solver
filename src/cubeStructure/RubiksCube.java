package cubeStructure;

// TODO write a way to input a cube state

public class RubiksCube {
	public static Cubie[][][] cubicles = new Cubie[3][3][3];

	public RubiksCube() {

		// up right cubicle on the front face is index 0,0,0
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

	public static void move(String moves, int orientation) {
		// orientation 1 does the moves as given
		// orientation -1 undoes the moves

		String[] moveList = moves.split("\\s");
		int tmp1 = 0;
		int tmp2 = 0;

		for (int i = 0; i < moveList.length; i++) {

			if (moveList[i].length() == 1) {
				tmp1 = 1 * orientation;
				tmp2 = -1 * orientation;
			} else if (moveList[i].length() == 2 && moveList[i].charAt(1) == '\'') {
				tmp1 = -1 * orientation;
				tmp2 = 1 * orientation;
			} else {
				return;
			}

			switch (moveList[i].charAt(0)) {
			case 'f':
				rotate(1, 1, 0, tmp1);
				break;
			case 'r':
				rotate(2, 1, 1, tmp2);
				break;
			case 'b':
				rotate(1, 1, 2, tmp2);
				break;
			case 'l':
				rotate(0, 1, 1, tmp1);
				break;
			case 'u':
				rotate(1, 0, 1, tmp1);
				break;
			case 'd':
				rotate(1, 2, 1, tmp2);
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
		// 1. determine the type of rotation
		// 2. copy face cubicles
		// 3. update facelet pointers to their destination
		// 4. move cubicles

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
						tmpY = cubicles[x][j][k].facelet[c].pointer[1];
						tmpZ = cubicles[x][j][k].facelet[c].pointer[2];

						cubicles[x][j][k].facelet[c].pointer[1] = Math.abs(2 - wght1 - tmpZ);
						cubicles[x][j][k].facelet[c].pointer[2] = Math.abs(2 - wght2 - tmpY);

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
						tmpX = cubicles[i][y][k].facelet[c].pointer[0];
						tmpZ = cubicles[i][y][k].facelet[c].pointer[2];

						cubicles[i][y][k].facelet[c].pointer[0] = Math.abs(2 - wght2 - tmpZ);
						cubicles[i][y][k].facelet[c].pointer[2] = Math.abs(2 - wght1 - tmpX);
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
						tmpX = cubicles[i][j][z].facelet[c].pointer[0];
						tmpY = cubicles[i][j][z].facelet[c].pointer[1];

						cubicles[i][j][z].facelet[c].pointer[0] = Math.abs(2 - wght1 - tmpY);
						cubicles[i][j][z].facelet[c].pointer[1] = Math.abs(2 - wght2 - tmpX);
					}

					cubicles[i][j][z] = tmpCubicle[Math.abs(2 - wght2 - j)][Math.abs(2 - wght1 - i)];
				}
			}
		}

	}

	public static void setCube(char frontF, char rightF, char backF, char leftF, char upF, char downF) {

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				setCubie(cubicles[i][j][0], 1, 1, 0, frontF);
			}
		}

		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				setCubie(cubicles[2][j][k], 2, 1, 1, rightF);
			}
		}

		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				setCubie(cubicles[0][j][k], 0, 1, 1, leftF);
			}
		}

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				setCubie(cubicles[i][j][2], 1, 1, 2, backF);
			}
		}

		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				setCubie(cubicles[i][0][k], 1, 0, 1, upF);
			}
		}

		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				setCubie(cubicles[i][2][k], 1, 2, 1, downF);
			}
		}

	}

	private static void setCubie(Cubie tmpCubie, int x, int y, int z, char color) {
		for (int c = 0; c < tmpCubie.facelet.length; c++) {
			if (CubeUtils.checkPointer(tmpCubie.facelet[c], x, y, z) == true) {
				tmpCubie.facelet[c].setColor(color);
			}
		}
	}

	public static void printCube() {

		// prints the up face
		printFace('u');
		System.out.println();

		// prints the Rows in order: Front Right Back Left
		for (int j = 0; j < 3; j++) {

			for (int i = 0; i < 3; i++) {
				printFaceletColor(cubicles[i][j][0], 1, 1, 0);
			}
			System.out.print(" ");

			for (int k = 0; k < 3; k++) {
				printFaceletColor(cubicles[2][j][k], 2, 1, 1);
			}
			System.out.print(" ");

			for (int i = 2; i > 0 - 1; i--) {
				printFaceletColor(cubicles[i][j][2], 1, 1, 2);
			}
			System.out.print(" ");

			for (int k = 2; k > 0 - 1; k--) {
				printFaceletColor(cubicles[0][j][k], 0, 1, 1);
			}
			System.out.println();
			
		}
		System.out.println();

		// prints the Down (bottom) face
		printFace('d');
		System.out.println();
	}

	public static void printFace(char face) {
		switch (face) {
		
		case 'f':
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					printFaceletColor(cubicles[i][j][0], 1, 1, 0);
				}
				System.out.println();
			}
			break;

		case 'r':
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					printFaceletColor(cubicles[2][j][k], 2, 1, 1);
				}
				System.out.println();
			}
			break;

		case 'b':
			for (int j = 0; j < 3; j++) {
				for (int i = 2; i > 0 - 1; i--) {
					printFaceletColor(cubicles[i][j][2], 1, 1, 2);
				}
				System.out.println();
			}
			break;

		case 'l':
			for (int j = 0; j < 3; j++) {
				for (int k = 2; k > 0 - 1; k--) {
					printFaceletColor(cubicles[0][j][k], 0, 1, 1);
				}
				System.out.println();
			}
			break;

		case 'u':
			for (int k = 2; k > -1; k--) {
				for (int i = 0; i < 3; i++) {
					printFaceletColor(cubicles[i][0][k], 1, 0, 1);
				}
				System.out.println();
			}
			break;

		case 'd':
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {
					printFaceletColor(cubicles[i][2][k], 1, 2, 1);
				}
				System.out.println();
			}
			break;

		}

	}

	private static void printFaceletColor(Cubie tmpCubie, int x, int y, int z) {
		for (int c = 0; c < tmpCubie.facelet.length; c++) {
			if (CubeUtils.checkPointer(tmpCubie.facelet[c], x, y, z) == true) {
				System.out.print(tmpCubie.facelet[c].getColor());
			}
		}
	}

}
