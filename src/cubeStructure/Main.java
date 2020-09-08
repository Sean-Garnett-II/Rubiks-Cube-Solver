package cubeStructure;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		new RubiksCube();

		RubiksCube.setCube('f', 'r', 'b', 'l', 'u', 'd');


		RubiksCube.move("f f d", 1);
		RubiksCube.printCube();
		Algorithms.topCross.setTarget('f');
		RubiksCube.printCube();
		

	}

}
