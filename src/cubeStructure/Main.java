package cubeStructure;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();

		cube.setCube('f', 'r', 'b', 'l', 't', 'd');

		int[] array = CubeUtils.findCubie('f', 'r');

		System.out.println(Arrays.toString(array));

	}

}
