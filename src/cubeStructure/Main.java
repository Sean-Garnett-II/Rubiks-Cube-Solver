package cubeStructure;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		new RubiksCube();
		RubiksCube.printCube();
		RubiksCube.setCube('f', 'r', 'b', 'l', 'u', 'd');

		int[] array = CubeUtils.findCubie('f', 'u', 'r');

		System.out.println(Arrays.toString(array));

	}

}
