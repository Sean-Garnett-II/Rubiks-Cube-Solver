package cubeStructure;

public class CubeUtils {

	public static int[] findCubie(char color) {

		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					if (checkFacletColor(RubiksCube.cubicles[i][j][k].facelet[0], color) == true
							&& RubiksCube.cubicles[i][j][k].facelet.length == 1) {
						return new int[] { i, j, k };
					}

				}
			}
		}

		return new int[] {};
	}

	public static int[] findCubie(char color1, char color2) {
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					if (RubiksCube.cubicles[i][j][k].facelet.length == 2
							&& checkFacletColor(RubiksCube.cubicles[i][j][k].facelet[0], color1, color2) == true
							&& checkFacletColor(RubiksCube.cubicles[i][j][k].facelet[1], color1, color2) == true) {

						return new int[] { i, j, k };

					}
				}
			}
		}
		return new int[] {};
	}

	public static int[] findCubie(char color1, char color2, char color3) {
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					if (RubiksCube.cubicles[i][j][k].facelet.length == 3
							&& checkFacletColor(RubiksCube.cubicles[i][j][k].facelet[0], color1, color2, color3) == true
							&& checkFacletColor(RubiksCube.cubicles[i][j][k].facelet[1], color1, color2, color3) == true
							&& checkFacletColor(RubiksCube.cubicles[i][j][k].facelet[2], color1, color2,
									color3) == true) {

						return new int[] { i, j, k };

					}
				}
			}
		}
		return new int[] {};
	}

	public static boolean checkFacletColor(Facelet tmpFacelet, char color) {
		if (tmpFacelet.getColor() == color) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkFacletColor(Facelet tmpFacelet, char color1, char color2) {
		if (checkFacletColor(tmpFacelet, color1) || checkFacletColor(tmpFacelet, color2)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkFacletColor(Facelet tmpFacelet, char color1, char color2, char color3) {
		if (checkFacletColor(tmpFacelet, color1) || checkFacletColor(tmpFacelet, color2)
				|| checkFacletColor(tmpFacelet, color3)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkPointer(Facelet tmpFacelet, int x, int y, int z) {
		if (tmpFacelet.pointer[0] == x && tmpFacelet.pointer[1] == y && tmpFacelet.pointer[2] == z) {
			return true;
		} else {
			return false;
		}
	}

}
