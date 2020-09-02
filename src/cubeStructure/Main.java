package cubeStructure;

public class Main {

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();

		cube.setCube('z', 'x', 'j', 'v', 'o', 'm');
		cube.printCube();
		System.out.println();
		RubiksCube.rotate(1, 1, 0);
		cube.printCube();
		RubiksCube.rotate(1, 1, 0);
		RubiksCube.rotate(1, 1, 0);
		RubiksCube.rotate(1, 1, 0);
		System.out.println();
		cube.printCube();

		
	}
	
}
