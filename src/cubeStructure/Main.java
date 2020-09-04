package cubeStructure;

public class Main {

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();

		cube.setCube('f', 'r', 'b', 'l', 't', 'd');
		cube.printCube();
		System.out.println();

		System.out.println();
		RubiksCube.move("f r", 1);
		cube.printCube();
		System.out.println();
		RubiksCube.printFace(1,1,0);
		System.out.println();
		RubiksCube.printFace(2,1,1);
		System.out.println();
		RubiksCube.printFace(1,1,2);
		System.out.println();
		RubiksCube.printFace(0,1,1);
		System.out.println();
		RubiksCube.printFace(1,0,1);
		System.out.println();
		RubiksCube.printFace(1,2,1);
		System.out.println();


		
	}
	
}
