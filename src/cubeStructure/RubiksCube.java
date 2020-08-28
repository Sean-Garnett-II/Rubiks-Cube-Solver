package cubeStructure;

public class RubiksCube {

	static Face frontF = new Face('f');
	static Face rightF = new Face('r');
	static Face backF = new Face('b');
	static Face leftF = new Face('l');
	static Face topF = new Face('t');
	static Face bottomF = new Face('B');

	static char[] tmpFront = new char[3];
	static char[] tmpRight = new char[3];
	static char[] tmpBack = new char[3];
	static char[] tmpLeft = new char[3];
	static char[] tmpTop = new char[3];
	static char[] tmpBottom = new char[3];

	public RubiksCube() {

	}

	public static void printCube() {

		topF.printGrid();
		System.out.println();
		System.out.println("┌─┬─┬─┐┌─┬─┬─┐┌─┬─┬─┐┌─┬─┬─┐");

		for (int i = 0; i < 3; i++) {
			frontF.printRow(i);
			rightF.printRow(i);
			backF.printRow(i);
			leftF.printRow(i);
			System.out.println();

			if (i < 2) {
				System.out.println("├─┼─┼─┤├─┼─┼─┤├─┼─┼─┤├─┼─┼─┤");
			}
		}

		System.out.println("└─┴─┴─┘└─┴─┴─┘└─┴─┴─┘└─┴─┴─┘");
		bottomF.printGrid();
		System.out.println();
	}

	public static void setTMPRows(int face, int right, int back, int left, int top, int bottom) {
		tmpFront = frontF.getRow(face);
		tmpRight = rightF.getRow(right);
		tmpBack = backF.getRow(back);
		tmpLeft = leftF.getRow(left);
		tmpTop = topF.getRow(top);
		tmpBottom = bottomF.getRow(bottom);
	}

	public static void setTMPColumns(int face, int right, int back, int left, int top, int bottom) {
		tmpFront = frontF.getColumn(face);
		tmpRight = rightF.getColumn(right);
		tmpBack = backF.getColumn(back);
		tmpLeft = leftF.getColumn(left);
		tmpTop = topF.getColumn(top);
		tmpBottom = bottomF.getColumn(bottom);
	}

	public static void rotateFace() {
		setTMPColumns(0, 0, 0, 2, 0, 0);
	}

	public static void rotateRight() {
		setTMPColumns(2, 0, 0, 0, 2, 2);

		topF.setColumn(2, tmpFront);
		backF.setColumn(0, tmpTop);
		backF.invertColumn(0);
		bottomF.setColumn(2, tmpBack);
		bottomF.invertColumn(2);
		frontF.setColumn(2, tmpBottom);

		rightF.rotate();
	}

	public static void iRotateRight() {
		setTMPColumns(2, 0, 0, 0, 2, 2);

		topF.setColumn(2, tmpBack);
		topF.invertColumn(2);
		backF.setColumn(0, tmpBottom);
		backF.invertColumn(0);
		bottomF.setColumn(2, tmpFront);
		frontF.setColumn(2, tmpTop);

		rightF.counterRotate();

	}
}