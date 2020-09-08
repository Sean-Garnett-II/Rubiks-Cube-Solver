package cubeStructure;

public class CubeUtils {

	public CubeUtils() {

	}

	// finds the facelet in a cubie that has the given color/colors and returns the
	// pointer.
	public static int[] findPointer(Cubie tmpCubie, char color) {
		for (int c = 0; c < tmpCubie.facelet.length; c++) {
			if (checkFaceletColor(tmpCubie.facelet[c], color)) {
				return new int[] { tmpCubie.facelet[c].pointer[0], tmpCubie.facelet[c].pointer[1],
						tmpCubie.facelet[c].pointer[2] };

			}
		}
		return new int[] {};
	}

	// finds the cubicle index number of a cubie that matches the colors given
	public static int[] findCubie(char color) {

		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					if (checkFaceletColor(RubiksCube.cubicles[i][j][k].facelet[0], color) == true
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

					if (RubiksCube.cubicles[i][j][k].facelet != null) {
						if (RubiksCube.cubicles[i][j][k].facelet.length == 2
								&& checkFaceletColor(RubiksCube.cubicles[i][j][k].facelet[0], color1, color2) == true
								&& checkFaceletColor(RubiksCube.cubicles[i][j][k].facelet[1], color1, color2) == true) {

							return new int[] { i, j, k };

						}
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
							&& checkFaceletColor(RubiksCube.cubicles[i][j][k].facelet[0], color1, color2,
									color3) == true
							&& checkFaceletColor(RubiksCube.cubicles[i][j][k].facelet[1], color1, color2,
									color3) == true
							&& checkFaceletColor(RubiksCube.cubicles[i][j][k].facelet[2], color1, color2,
									color3) == true) {

						return new int[] { i, j, k };

					}
				}
			}
		}
		return new int[] {};
	}

	public static boolean checkFaceletColor(Facelet tmpFacelet, char color) {
		if (tmpFacelet.getColor() == color) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkFaceletColor(Facelet tmpFacelet, char color1, char color2) {
		if (checkFaceletColor(tmpFacelet, color1) || checkFaceletColor(tmpFacelet, color2)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkFaceletColor(Facelet tmpFacelet, char color1, char color2, char color3) {
		if (checkFaceletColor(tmpFacelet, color1) || checkFaceletColor(tmpFacelet, color2)
				|| checkFaceletColor(tmpFacelet, color3)) {
			return true;
		} else {
			return false;
		}
	}

	// checks the given facelets pointer to the given pointer info
	public static boolean checkPointer(Facelet tmpFacelet, int x, int y, int z) {
		if (tmpFacelet.pointer[0] == x && tmpFacelet.pointer[1] == y && tmpFacelet.pointer[2] == z) {
			return true;
		} else {
			return false;
		}
	}

}
