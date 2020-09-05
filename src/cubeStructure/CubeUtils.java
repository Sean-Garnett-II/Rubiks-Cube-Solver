package cubeStructure;

public class CubeUtils {

	public static int[] findCubie(char color) {
		if (checkFacelet(1, 1, 0, 0, color) == true) {
			return new int[] { 1, 1, 0 };
		} else if (checkFacelet(2, 1, 1, 0, color) == true) {
			return new int[] { 2, 1, 0 };
		} else if (checkFacelet(1, 1, 2, 0, color) == true) {
			return new int[] { 1, 1, 2 };
		} else if (checkFacelet(0, 1, 1, 0, color) == true) {
			return new int[] { 0, 1, 1 };
		} else if (checkFacelet(1, 0, 1, 0, color) == true) {
			return new int[] { 1, 0, 1 };
		} else if (checkFacelet(1, 2, 1, 0, color) == true) {
			return new int[] { 1, 2, 1 };
		} else {
			return new int[] {};
		}

	}

	public static boolean checkFacelet(int i, int j, int k, int c, char color) {
		if (RubiksCube.cubicles[i][j][k].face[c].getColor() == color) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkPointer(int i, int j, int k, int x, int y, int z, int c) {
		if (RubiksCube.cubicles[i][j][k].face[c].pointer[0] == x && RubiksCube.cubicles[i][j][k].face[c].pointer[1] == y
				&& RubiksCube.cubicles[i][j][k].face[c].pointer[2] == z) {
			return true;
		} else {
			return false;
		}
	}

}
