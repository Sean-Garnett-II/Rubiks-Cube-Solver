package cubeStructure;

// TODO write a way to input a cube state

public class RubiksCube {
	public static Cubie[][][] cubicles = new Cubie[3][3][3];

	public RubiksCube() {

		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					// determines the number of facelets a cubie can have
					int faceletNumber = 3 - i % 2 - j % 2 - k % 2;

					switch (faceletNumber) {
					case 0:
						cubicles[i][j][k] = new Cubie();
						break;
					case 1:
						cubicles[i][j][k] = new Cubie(new Facelet('o', i, j, k));
						break;
					case 2:
						if (i % 2 == 1) {
							cubicles[i][j][k] = new Cubie(new Facelet('o', i, 1, k),
									new Facelet('o', i, j, 1));
						} else if (j % 2 == 1) {
							cubicles[i][j][k] = new Cubie(new Facelet('o', 1, j, k),
									new Facelet('o', i, j, 1));
						} else if (k % 2 == 1) {
							cubicles[i][j][k] = new Cubie(new Facelet('o', 1, j, k),
									new Facelet('o', i, 1, k));
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

	}

	public static void printCube() {

		for (int k = 2; k > -1; k--) {
			for (int i = 0; i < 3; i++) {
				printR(i, 0, k, 1, 0, 1);
			}
			System.out.println();
		}

	}

	public static void printR(int i, int j, int k, int x, int y, int z) {
		for (int faceletNumber = 0; faceletNumber < 3 - i % 2 - j % 2 - k % 2; faceletNumber++) {
			System.out.println(cubicles[i][j][k].face[faceletNumber].pointer[0]);
			if (cubicles[i][j][k].face[faceletNumber].pointer[0] == x
					&& cubicles[i][j][k].face[faceletNumber].pointer[1] == y
					&& cubicles[i][j][k].face[faceletNumber].pointer[2] == z) {
				System.out.print(cubicles[i][j][k].face[faceletNumber].getColor());
			}
		}

	}
}
