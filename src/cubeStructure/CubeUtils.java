package cubeStructure;

public class CubeUtils {

	private CubeUtils() {
	}

	public static boolean isValidMove(String tmp) {
		boolean valid = tmp.equalsIgnoreCase("f") || tmp.equalsIgnoreCase("f'") || tmp.equalsIgnoreCase("r")
				|| tmp.equalsIgnoreCase("r'") || tmp.equalsIgnoreCase("b") || tmp.equalsIgnoreCase("b'")
				|| tmp.equalsIgnoreCase("l") || tmp.equalsIgnoreCase("l'") || tmp.equalsIgnoreCase("t")
				|| tmp.equalsIgnoreCase("t'") || tmp.equalsIgnoreCase("d") || tmp.equalsIgnoreCase("d'");
		if (valid == false) {
			System.out.println("'" + tmp + "'" + " is not a valid move.");
		}
		return valid;
	}

	public static void setMoves(String moves) {
		// //s* is the regular expression to all white space character, tabs included
		String[] moveList = moves.split("\\s*,\\s*");
		boolean valid = true;

		for (int i = 0; i < moveList.length; i++) {
			if ((valid = isValidMove(moveList[i])) == false) {
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
		String[] moveList = moves.split("\\s*,\\s*");
		boolean valid = true;

		for (int i = 0; i < moveList.length; i++) {
			if ((valid = isValidMove(moveList[i])) == false) {
				break;
			}
		}

		if (valid == true) {
			for (int i = moveList.length; i > 0; i--) {
				if (moveList[i-1].equalsIgnoreCase("f")) {
					RubiksCube.iRotateFront();
				} else if (moveList[i-1].equalsIgnoreCase("f'")) {
					RubiksCube.rotateFront();
				} else if (moveList[i-1].equalsIgnoreCase("r")) {
					RubiksCube.iRotateRight();
				} else if (moveList[i-1].equalsIgnoreCase("r'")) {
					RubiksCube.rotateRight();
				} else if (moveList[i-1].equalsIgnoreCase("b")) {
					RubiksCube.iRotateBack();
				} else if (moveList[i-1].equalsIgnoreCase("b'")) {
					RubiksCube.rotateBack();
				} else if (moveList[i-1].equalsIgnoreCase("l")) {
					RubiksCube.iRotateLeft();
				} else if (moveList[i-1].equalsIgnoreCase("l'")) {
					RubiksCube.rotateLeft();
				} else if (moveList[i-1].equalsIgnoreCase("t")) {
					RubiksCube.iRotateTop();
				} else if (moveList[i-1].equalsIgnoreCase("t'")) {
					RubiksCube.rotateTop();
				} else if (moveList[i-1].equalsIgnoreCase("d")) {
					RubiksCube.iRotateDown();
				} else if (moveList[i-1].equalsIgnoreCase("d'")) {
					RubiksCube.rotateDown();
				}
			}
		}
	}

}
