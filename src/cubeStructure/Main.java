package cubeStructure;

public class Main {

	public static void main(String[] args) {

		Face frontFace = new Face();

		frontFace.printSimple();
		frontFace.set(1, 2, 'O');
		frontFace.printSimple();

		char what = frontFace.face[1][2];
		System.out.println(what);
		frontFace.face[1][2] = 'P';
		what = frontFace.face[1][2];
		System.out.println(what);

		Face backF = new Face('b');
		backF.printSimple();

		frontFace.printGrid();
		System.out.println("\u2586" + "\u2586");
		backF.printGrid();
		System.out.println("here is text");

		backF.printRow(1);

		System.out.println();
		RubiksCube.printCube();
		System.out.println();

		backF.set(0, 0, 'y');
		backF.set(1, 0, 'h');
		backF.set(2, 0, 'a');

		backF.set(0, 1, 'y');
		backF.set(1, 1, 'h');
		backF.set(2, 1, 'a');

		backF.set(0, 2, 'y');
		backF.set(1, 2, 'h');
		backF.set(2, 2, 'a');

		backF.printSimple();
		backF.counterRotate();
		backF.printSimple();
		backF.rotate();
		backF.printSimple();

	}

}
