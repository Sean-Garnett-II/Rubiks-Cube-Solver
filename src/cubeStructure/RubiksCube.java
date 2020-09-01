package cubeStructure;

// TODO write a way to input a cube state

public class RubiksCube {
	static Cubie[][][] cubicles = new Cubie[3][3][3];
	static Cubie[][][] tmp = new Cubie[3][3][3];

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
						cubicles[i][j][k] = new Cubie(new Facelet('o', i, j, k));
						break;
					case 2:
						if (i % 2 == 1) {
							cubicles[i][j][k] = new Cubie(new Facelet('o', i, 1, k), new Facelet('o', i, j, 1));
						} else if (j % 2 == 1) {
							cubicles[i][j][k] = new Cubie(new Facelet('o', 1, j, k), new Facelet('o', i, j, 1));
						} else if (k % 2 == 1) {
							cubicles[i][j][k] = new Cubie(new Facelet('o', 1, j, k), new Facelet('o', i, 1, k));
						}
						break;
					case 3:
						cubicles[i][j][k] = new Cubie(new Facelet('o', i, 1, 1), new Facelet('o', 1, j, 1),
								new Facelet('o', 1, 1, k));
						break;
					}
				}
			}
		}
	}

	public static void rotate(int x, int y, int z) {
		int i1, i2, i3;
		tmp = cubicles;

		if (x % 2 == 0) {
			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < 3; j++) {
					tmp[x][j][k] = cubicles[x][j][k];
				}
			}

			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < 3; j++) {
					cubicles[x][j][k] = tmp[x][k][2 - j];

					for (int c = 0; c < (3 - j % 2 - k % 2); c++) {
						i2 = cubicles[x][j][k].face[c].getY();
						i3 = cubicles[x][j][k].face[c].getZ();
						cubicles[x][j][k].face[c].setY(3 - 1 - i3);
						cubicles[x][j][k].face[c].setZ(i2);
					}
				}
			}

		}

		if (y % 2 == 0) {
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {
					tmp[i][y][k] = cubicles[i][y][k];
				}
			}

			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {
					cubicles[i][y][k] = tmp[k][y][2 - i];

					for (int c = 0; c < (3 - i % 2 - k % 2); c++) {
						i1 = cubicles[i][y][k].face[c].getX();
						i3 = cubicles[i][y][k].face[c].getZ();
						cubicles[i][y][k].face[c].setX(2 - i3);
						cubicles[i][y][k].face[c].setZ(i1);
					}

				}
			}
		}

		
		// THIS IS THE FUNCTION I'M TRYING I ASSUMe ALL OTHER FUNCTIONS ARE ALSO BUGGY
		//
		//
		// i, j, k are another type of x, y, z, 
		// start indexing the cube with the top left corner as 0,0,0
		// +x is right +z is down +z is into the cube
		// I reference a face based off of it's home facelet
		// for example the front face is indexed 1,1,0
		// rotating a face means that only one of it's coordinates is even hence the z % 2 == 0 (rotating the face is a z axis rotation)
		// clockwise rotation of the z axis maps:
		// NEW x = 2 y OLD
		// NEW y = x OLD
		// Z = Z
		//
		//
		// the first loop copies the current face to a temp array
		// each cubie has a number of facelets = 3 - i % 2 - j % 2
		// here that number is c
		// diagnostics in the first loop are as follows:
		// cubicles index -- cubie's c'th facelets pointer information -- pointer information copied to the temp
		// this loop works as intended and is used as a reference point in the secon loop
		//
		//
		// the second loop updates the cubicles facelets pointer information using the same transformation
		// the diagnostics in the second loop are as follows:
		// cubicles index -- cubie's c'th facelets pointer information -- temp file's pointer -- transformed temp files pointer -- updated cubie's c'ths facelts pointer information -- fmp files' transformed information
		// one of the jumbled set of pointer is from cubie 1,0,0 to 2,1,0
		// it's second facelet pointer is 1,0,1. 
		// in the second loop it is referenced from the original cubicle or the temp array with wrong pointer information 0,1,1
		
		
		if (z % 2 == 0) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					for (int c = 0; c < (3 - i % 2 - j % 2); c++) {
						System.out.print(i + "" + j + "" + z);
						
						System.out.print("	" + cubicles[i][j][z].face[c].getX() + " "
								+ cubicles[i][j][z].face[c].getY() + " " + cubicles[i][j][z].face[c].getZ());

						tmp[i][j][z] = cubicles[i][j][z];

						System.out.print("	" + tmp[i][j][z].face[c].getX() + " " + tmp[i][j][z].face[c].getY() + " "
								+ tmp[i][j][z].face[c].getZ());

						System.out.println();
					}
					System.out.println();
				}
			}

			System.out.println("\n Updating Cubie Facelets \n");
			/// System.out.println("XXX");
			// System.out.println(" " + cubicles[2][1][0].face[1].getX() + " " +
			/// cubicles[2][1][0].face[1].getY() + " "
			// + cubicles[2][1][0].face[1].getZ());
			// System.out.println("XXX");
			// System.out.println();

			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					for (int c = 0; c < (3 - i % 2 - j % 2); c++) {
						System.out.print(i + "" + j + "" + z);
						System.out.print("	" + cubicles[i][j][z].face[c].getX() + " "
								+ cubicles[i][j][z].face[c].getY() + " " + cubicles[i][j][z].face[c].getZ());
						
						System.out.print("	" + tmp[i][j][z].face[c].getX() + " " + tmp[i][j][z].face[c].getY() + " "
								+ tmp[i][j][z].face[c].getZ());

						System.out.print("	" + tmp[j][2 - i][z].face[c].getX() + " " + tmp[j][2 - i][z].face[c].getY()
								+ " " + tmp[j][2 - i][z].face[c].getZ());

						// Actual assignment
						cubicles[i][j][z] = tmp[j][2 - i][z];

						System.out.print("		" + cubicles[i][j][z].face[c].getX() + " "
								+ cubicles[i][j][z].face[c].getY() + " " + cubicles[i][j][z].face[c].getZ());

						System.out.print("	" + tmp[j][2 - i][z].face[c].getX() + " " + tmp[j][2 - i][z].face[c].getY()
								+ " " + tmp[j][2 - i][z].face[c].getZ());
						System.out.println();

					}
					System.out.println();
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

	public void printFColor(int i, int j, int k, int x, int y, int z) {

		for (int c = 0; c < (3 - i % 2 - j % 2 - k % 2); c++) {
			if (cubicles[i][j][k].face[c].getX() == x && cubicles[i][j][k].face[c].getY() == y
					&& cubicles[i][j][k].face[c].getZ() == z) {
				System.out.print(cubicles[i][j][k].face[c].getColor());
			}
		}

	}

}
