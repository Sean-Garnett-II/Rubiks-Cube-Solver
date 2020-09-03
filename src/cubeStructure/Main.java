package cubeStructure;

public class Main {

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();

		cube.setCube('f', 'r', 'b', 'l', 't', 'd');
		cube.printCube();
		System.out.println();
		RubiksCube.rotate(1, 0, 1, 1);
		cube.printCube();


		
	}
	
}
