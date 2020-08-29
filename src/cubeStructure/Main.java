package cubeStructure;

public class Main {

	public static void main(String[] args) {
		RubiksCube.printCube();
		CubeUtils.setMoves("left, right, right, asdff' ,asdfdf,asdfasdf");
		CubeUtils.setMoves("f, r, b, l, t, d");
		RubiksCube.printCube();
		CubeUtils.undoMoves("f, r, b, l, t, d");
		RubiksCube.printCube();

	}

}
