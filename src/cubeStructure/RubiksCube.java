package cubeStructure;

public class RubiksCube {

	static Face frontF = new Face('f');
	static Face rightF = new Face('r');
	static Face backF = new Face('b');
	static Face leftF = new Face('l');
	static Face topF = new Face('t');
	static Face bottomF = new Face('b');

	public RubiksCube() {

		/**
		 * Face[] cube = new Face[6]; Instead of making the faces, I can make an array
		 * of face objects. I can then map an array index to a face, IE Front Face will
		 * be the first index. This could be potentially confusing and also requires the
		 * printCube() method to be rewritten. However it allows a more automated
		 * approach to manipulating the faces.
		 */
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
	}
}