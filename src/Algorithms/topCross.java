package Algorithms;

import java.util.Arrays;

import cubeStructure.RubiksCube;

public class topCross {
	public topCross() {

	}

	public static void setTarget(char targetColor) {
		int[] cubicleIndex = cubeStructure.CubeUtils.findCubie('u', targetColor);
		int[] targetPointer = cubeStructure.CubeUtils.findPointer(
				cubeStructure.RubiksCube.cubicles[cubicleIndex[0]][cubicleIndex[1]][cubicleIndex[2]], targetColor);

		switch (cubicleIndex[1]) {
		case 0:
			if (targetPointer[0] == 1 && targetPointer[1] == 1 && targetPointer[2] == 0) {
				return;
			} else {
				RubiksCube.rotate(cubicleIndex[0], 1, cubicleIndex[2], 1);
			}
			break;

		case 1:
			break;

		case 2:
			System.out.println("case 2");
			if (cubicleIndex[0] == 1 && cubicleIndex[1] == 2 && cubicleIndex[2] == 0) {
				RubiksCube.rotate(1, 1, 0, 1);
			} else {

			System.out.println("rotated");
			RubiksCube.move("d", 1);
			setTarget(targetColor);
			}
			break;

		}

	}

}
