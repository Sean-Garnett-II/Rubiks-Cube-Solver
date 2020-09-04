package cubeStructure;

public class Main {

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();

		cube.setCube('f', 'r', 'b', 'l', 't', 'd');
		cube.printCube();
		System.out.println();

		System.out.println();
		RubiksCube.move("f r" , 1);
		cube.printCube();





		
	}
	
}
