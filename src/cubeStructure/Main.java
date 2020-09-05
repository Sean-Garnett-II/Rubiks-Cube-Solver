package cubeStructure;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		RubiksCube.setCube('f', 'r', 'b', 'l', 'p', 'd');
		RubiksCube.printCube();

		int[] array = CubeUtils.findCubie('f', 'r');

		System.out.println(Arrays.toString(array));

	}

}
