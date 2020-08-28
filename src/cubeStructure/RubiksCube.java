package cubeStructure;

public class RubiksCube {

	static Face frontF = new Face('b');
	static Face rightF = new Face('y');
	static Face backF = new Face('g');
	static Face leftF = new Face('w');
	static Face topF = new Face('o');
	static Face downF = new Face('p');

	static char[] tmpFront = new char[3];
	static char[] tmpRight = new char[3];
	static char[] tmpBack = new char[3];
	static char[] tmpLeft = new char[3];
	static char[] tmpTop = new char[3];
	static char[] tmpDown = new char[3];

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
		downF.printGrid();
		System.out.println();
	}

	public static void setTMPRows(int face, int right, int back, int left, int top, int down) {
		tmpFront = frontF.getRow(face);
		tmpRight = rightF.getRow(right);
		tmpBack = backF.getRow(back);
		tmpLeft = leftF.getRow(left);
		tmpTop = topF.getRow(top);
		tmpDown = downF.getRow(down);
	}

	public static void setTMPColumns(int face, int right, int back, int left, int top, int down) {
		tmpFront = frontF.getColumn(face);
		tmpRight = rightF.getColumn(right);
		tmpBack = backF.getColumn(back);
		tmpLeft = leftF.getColumn(left);
		tmpTop = topF.getColumn(top);
		tmpDown = downF.getColumn(down);
	}

	public static void rotateFront() {
		tmpRight = rightF.getColumn(0);
		tmpLeft = leftF.getColumn(2);
		tmpTop = topF.getRow(2);
		tmpDown = downF.getRow(0);

		rightF.setColumn(0, tmpTop);
		leftF.setColumn(2, tmpDown);
		topF.setRow(2, tmpLeft);
		topF.invertRow(2);
		downF.setRow(0, tmpRight);
		downF.invertRow(0);

		frontF.rotate();

	}

	public static void iRotateFront() {
		tmpRight = rightF.getColumn(0);
		tmpLeft = leftF.getColumn(2);
		tmpTop = topF.getRow(2);
		tmpDown = downF.getRow(0);

		rightF.setColumn(0, tmpDown);
		rightF.invertColumn(0);
		leftF.setColumn(2, tmpTop);
		leftF.invertColumn(2);
		topF.setRow(2, tmpRight);
		downF.setRow(0, tmpLeft);

		frontF.counterRotate();
	}

	public static void rotateRight() {
		tmpFront = frontF.getColumn(2);
		tmpBack = backF.getColumn(0);
		tmpTop = topF.getColumn(2);
		tmpDown = downF.getColumn(2);

		topF.setColumn(2, tmpFront);
		backF.setColumn(0, tmpTop);
		backF.invertColumn(0);
		downF.setColumn(2, tmpBack);
		downF.invertColumn(2);
		frontF.setColumn(2, tmpDown);

		rightF.rotate();
	}

	public static void iRotateRight() {
		tmpFront = frontF.getColumn(2);
		tmpBack = backF.getColumn(0);
		tmpTop = topF.getColumn(2);
		tmpDown = downF.getColumn(2);
		

		topF.setColumn(2, tmpBack);
		topF.invertColumn(2);
		backF.setColumn(0, tmpDown);
		backF.invertColumn(0);
		downF.setColumn(2, tmpFront);
		frontF.setColumn(2, tmpTop);

		rightF.counterRotate();

	}

	public static void rotateBack() {
		tmpRight = rightF.getColumn(2);
		tmpLeft = leftF.getColumn(0);
		tmpTop = topF.getRow(0);
		tmpDown = downF.getRow(2);

		rightF.setColumn(2, tmpDown);
		rightF.invertColumn(2);
		leftF.setColumn(0, tmpTop);
		leftF.invertColumn(0);
		topF.setRow(0, tmpRight);
		downF.setRow(2, tmpLeft);

		backF.rotate();
	}

	public static void iRotateBack() {
		tmpRight = rightF.getColumn(2);
		tmpLeft = leftF.getColumn(0);
		tmpTop = topF.getRow(0);
		tmpDown = downF.getRow(2);

		rightF.setColumn(2, tmpTop);
		leftF.setColumn(0, tmpDown);
		topF.setRow(0, tmpLeft);
		topF.invertRow(0);
		downF.setRow(2, tmpRight);
		downF.invertRow(2);

		backF.counterRotate();
	}

	public static void rotateLeft() {
		tmpFront = frontF.getColumn(0);
		tmpBack = backF.getColumn(2);
		tmpTop = topF.getColumn(0);
		tmpDown = downF.getColumn(0);

		frontF.setColumn(0, tmpTop);
		backF.setColumn(2, tmpDown);
		backF.invertColumn(2);
		topF.setColumn(0, tmpBack);
		topF.invertColumn(0);
		downF.setColumn(0, tmpFront);

		leftF.rotate();

	}

	public static void iRotateLeft() {
		tmpFront = frontF.getColumn(0);
		tmpBack = backF.getColumn(2);
		tmpTop = topF.getColumn(0);
		tmpDown = downF.getColumn(0);

		frontF.setColumn(0, tmpDown);
		backF.setColumn(2, tmpTop);
		backF.invertColumn(2);
		topF.setColumn(0, tmpFront);
		downF.setColumn(0, tmpBack);
		downF.invertColumn(0);

		leftF.counterRotate();
	}

	public static void rotateTop() {
		tmpFront = frontF.getRow(0);
		tmpRight = rightF.getRow(0);
		tmpBack = backF.getRow(0);
		tmpLeft = leftF.getRow(0);

		frontF.setRow(0, tmpRight);
		rightF.setRow(0, tmpBack);
		backF.setRow(0, tmpLeft);
		leftF.setRow(0, tmpFront);

		topF.rotate();
	}

	public static void iRotateTop() {
		tmpFront = frontF.getRow(0);
		tmpRight = rightF.getRow(0);
		tmpBack = backF.getRow(0);
		tmpLeft = leftF.getRow(0);

		frontF.setRow(0, tmpLeft);
		rightF.setRow(0, tmpFront);
		backF.setRow(0, tmpRight);
		leftF.setRow(0, tmpBack);

		topF.counterRotate();
	}

	public static void rotateDown() {
		tmpFront = frontF.getRow(2);
		tmpRight = rightF.getRow(2);
		tmpBack = backF.getRow(2);
		tmpLeft = leftF.getRow(2);

		frontF.setRow(2, tmpLeft);
		rightF.setRow(2, tmpFront);
		backF.setRow(2, tmpRight);
		leftF.setRow(2, tmpBack);

		downF.rotate();
	}

	public static void iRotateDown() {
		tmpFront = frontF.getRow(2);
		tmpRight = rightF.getRow(2);
		tmpBack = backF.getRow(2);
		tmpLeft = leftF.getRow(2);

		frontF.setRow(2, tmpRight);
		rightF.setRow(2, tmpBack);
		backF.setRow(2, tmpLeft);
		leftF.setRow(2, tmpFront);

		downF.counterRotate();
	}

}
