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
		// \\s* is the regular expression to all white space character, tabs included
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
				if (moveList[i].equalsIgnoreCase("f")) {
					RubiksCube.rotateFront();
				} else if (moveList[i].equalsIgnoreCase("f'")) {
					RubiksCube.iRotateFront();
				} else if (moveList[i].equalsIgnoreCase("r")) {
					RubiksCube.rotateRight();
				} else if (moveList[i].equalsIgnoreCase("r'")) {
					RubiksCube.iRotateRight();
				} else if (moveList[i].equalsIgnoreCase("b")) {
					RubiksCube.rotateBack();
				} else if (moveList[i].equalsIgnoreCase("b'")) {
					RubiksCube.iRotateBack();
				} else if (moveList[i].equalsIgnoreCase("l")) {
					RubiksCube.rotateLeft();
				} else if (moveList[i].equalsIgnoreCase("l'")) {
					RubiksCube.iRotateLeft();
				} else if (moveList[i].equalsIgnoreCase("t")) {
					RubiksCube.rotateTop();
				} else if (moveList[i].equalsIgnoreCase("t'")) {
					RubiksCube.iRotateTop();
				} else if (moveList[i].equalsIgnoreCase("d")) {
					RubiksCube.rotateDown();
				} else if (moveList[i].equalsIgnoreCase("d'")) {
					RubiksCube.iRotateDown();
				}
			}
		}
	}

	public static void undoMoves(String moves) {
		// \\s* is the regular expression to all white space character, tabs included
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

				if (moveList[i - 1].equalsIgnoreCase("f")) {
					RubiksCube.iRotateFront();
				} else if (moveList[i - 1].equalsIgnoreCase("f'")) {
					RubiksCube.rotateFront();
				} else if (moveList[i - 1].equalsIgnoreCase("r")) {
					RubiksCube.iRotateRight();
				} else if (moveList[i - 1].equalsIgnoreCase("r'")) {
					RubiksCube.rotateRight();
				} else if (moveList[i - 1].equalsIgnoreCase("b")) {
					RubiksCube.iRotateBack();
				} else if (moveList[i - 1].equalsIgnoreCase("b'")) {
					RubiksCube.rotateBack();
				} else if (moveList[i - 1].equalsIgnoreCase("l")) {
					RubiksCube.iRotateLeft();
				} else if (moveList[i - 1].equalsIgnoreCase("l'")) {
					RubiksCube.rotateLeft();
				} else if (moveList[i - 1].equalsIgnoreCase("t")) {
					RubiksCube.iRotateTop();
				} else if (moveList[i - 1].equalsIgnoreCase("t'")) {
					RubiksCube.rotateTop();
				} else if (moveList[i - 1].equalsIgnoreCase("d")) {
					RubiksCube.iRotateDown();
				} else if (moveList[i - 1].equalsIgnoreCase("d'")) {
					RubiksCube.rotateDown();
				}
			}
		}
	}

	public static void inputFace(Face face) {

	}

}
