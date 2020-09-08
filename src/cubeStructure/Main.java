package cubeStructure;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		new RubiksCube();

		RubiksCube.setCube('f', 'r', 'b', 'l', 'u', 'd');


		RubiksCube.move("f r b l", 1);
		RubiksCube.printCube();
		Algorithms.topCross.setTarget('f');
		RubiksCube.printCube();
		Algorithms.topCross.setTarget('r');
		RubiksCube.printCube();
		Algorithms.topCross.setTarget('b');
		RubiksCube.printCube();
		Algorithms.topCross.setTarget('l');
		RubiksCube.printCube();
		

	}

}
