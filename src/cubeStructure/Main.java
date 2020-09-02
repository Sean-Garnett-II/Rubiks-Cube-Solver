package cubeStructure;

public class Main {

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();

		cube.printCube();
		System.out.println();
		cube.rotate(1, 1, 0);
		cube.printCube();
	}

	public static void rotateF(int[][][] thisCube, int x, int y, int z) {
		int[][] tmp = new int[3][3];

		if (x % 2 == 0) {
			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < 3; j++) {
					tmp[j][k] = thisCube[x][j][k];
				}
			}

			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < 3; j++) {
					thisCube[x][j][k] = tmp[2 - k][j];
				}
			}
		}

		if (y % 2 == 0) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(thisCube[i][y][j] + ", ");
				}
				System.out.println();
			}
		}

		if (z % 2 == 0) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					tmp[j][i] = thisCube[j][i][z];
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tmp[j][i] = thisCube[j][i][z];
				}
			}
		}

	}

	public static void print(int[][][] thisCube) {
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				for (int k = 0; k < 3; k++) {
					System.out.print(thisCube[k][j][i]);
					System.out.print(", ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}

	}

	public static void setCube(int[][][] thisCube) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					thisCube[k][j][i] = count;
					count++;
				}
			}
		}
	}

}
