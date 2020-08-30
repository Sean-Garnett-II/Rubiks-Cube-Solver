package cubeStructure;

import java.util.HashMap;

// TODO inputFace(Face, char)
// TODO inputCube()

public final class CubeUtils {
	public static final HashMap<String, String> movesMap;
	static {
		HashMap<String, String> tmpMap = new HashMap<String, String>();
		tmpMap.put("f", "Rotate Front Face");
		tmpMap.put("f'", "Counter Rotate Front Face");
		tmpMap.put("r", "Rotate Right Face");
		tmpMap.put("r'", "Counter Rotate Right Face");
		tmpMap.put("b", "Rotate Back Face");
		tmpMap.put("b'", "Counter Rotate Back Face");
		tmpMap.put("l", "Rotate Left Face");
		tmpMap.put("l'", "Counter Rotate Left Face");
		tmpMap.put("t", "Rotate Top Face");
		tmpMap.put("t'", "Counter Rotate Top Face");
		tmpMap.put("d", "Rotate Down Face");
		tmpMap.put("d'", "Counter Rotate Down Face");
		movesMap = tmpMap;
	}

	private CubeUtils() {
	}

	public static boolean isValidMove(String tmp) throws Exception {

		boolean valid = movesMap.containsKey(tmp);

		if (valid == false) {
			throw new Exception("Error: " + "'" + tmp + "'" + " is not a valid move that the cube can make.");
		}
		return valid;
	}

	public static void setMoves(String moves) {
		// \\s* is the regular expression for all white space characters
		String[] moveList = moves.split("\\s*,\\s*");
		boolean valid = true;

		for (int i = 0; i < moveList.length; i++) {
			try {
				isValidMove(moveList[i]);
			} catch (Exception e) {
				valid = false;
				System.out.println(e.getLocalizedMessage());
				break;
			}
		}

		if (valid == true) {
			for (int i = 0; i < moveList.length; i++) {

				switch (moveList[i]) {
				case "f":
					RubiksCube.rotateFront();
					break;
				case "f'":
					RubiksCube.iRotateFront();
					break;
				case "r":
					RubiksCube.rotateRight();
					break;
				case "r'":
					RubiksCube.iRotateRight();
					break;
				case "b":
					RubiksCube.rotateBack();
					break;
				case "b'":
					RubiksCube.iRotateBack();
					break;
				case "l":
					RubiksCube.rotateLeft();
					break;
				case "l'":
					RubiksCube.iRotateLeft();
					break;
				case "t":
					RubiksCube.rotateTop();
					break;
				case "t'":
					RubiksCube.iRotateTop();
					break;
				case "d":
					RubiksCube.rotateDown();
					break;
				case "d'":
					RubiksCube.iRotateDown();
					break;
				}
			}
		}
	}

	public static void undoMoves(String moves) {
		// \\s* is the regular expression for all white space characters
		String[] moveList = moves.split("\\s*,\\s*");
		boolean valid = true;

		for (int i = 0; i < moveList.length; i++) {
			try {
				isValidMove(moveList[i]);
			} catch (Exception e) {
				valid = false;
				System.out.println(e.getLocalizedMessage());
				break;
			}
		}

		if (valid == true) {
			for (int i = moveList.length; i > 0; i--) {

				switch (moveList[i - 1]) {
				case "f":
					RubiksCube.iRotateFront();
					break;
				case "f'":
					RubiksCube.rotateFront();
					break;
				case "r":
					RubiksCube.iRotateRight();
					break;
				case "r'":
					RubiksCube.rotateRight();
					break;
				case "b":
					RubiksCube.iRotateBack();
					break;
				case "b'":
					RubiksCube.rotateBack();
					break;
				case "l":
					RubiksCube.iRotateLeft();
					break;
				case "l'":
					RubiksCube.rotateLeft();
					break;
				case "t":
					RubiksCube.iRotateTop();
					break;
				case "t'":
					RubiksCube.rotateTop();
					break;
				case "d":
					RubiksCube.iRotateDown();
					break;
				case "d'":
					RubiksCube.rotateDown();
					break;
				}
			}
		}
	}
}
