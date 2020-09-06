package cubeStructure;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		RubiksCube.printCube();
		RubiksCube.setCube('f', 'r', 'b', 'l', 'p', 'd');

		int[] array = CubeUtils.findCubie('f', 'r');

		System.out.println(Arrays.toString(array));

	}

}
