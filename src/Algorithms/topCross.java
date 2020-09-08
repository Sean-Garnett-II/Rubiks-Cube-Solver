package Algorithms;

import cubeStructure.RubiksCube;

public class topCross {
	public topCross() {

	}

	public static void setTarget(char targetColor) {
		char topColor = RubiksCube.cubicles[1][0][1].facelet[0].getColor();
		int[] cubicleIndex = cubeStructure.CubeUtils.findCubie(topColor, targetColor);
		int[] targetPointer = cubeStructure.CubeUtils.findPointer(
				cubeStructure.RubiksCube.cubicles[cubicleIndex[0]][cubicleIndex[1]][cubicleIndex[2]], targetColor);

		switch (cubicleIndex[1]) {
		case 0:
			if (targetPointer[0] == 1 && targetPointer[1] == 1 && targetPointer[2] == 0) {
				RubiksCube.move("u", 1);
				return;
			} else {
				RubiksCube.rotate(cubicleIndex[0], 1, cubicleIndex[2], 1);
			}
			break;

		case 1:
			char c1 = RubiksCube.cubicles[1][0][0].facelet[0].getColor();
			char c2 = RubiksCube.cubicles[1][0][0].facelet[1].getColor();
			int[] tmpIndex = cubeStructure.CubeUtils.findCubie(c1, c2);

			while (tmpIndex[0] != targetPointer[0] || tmpIndex[2] != targetPointer[2]) {
				RubiksCube.move("u", 1);
				tmpIndex = cubeStructure.CubeUtils.findCubie(c1, c2);
			}

			cubicleIndex = cubeStructure.CubeUtils.findCubie(topColor, targetColor);
			RubiksCube.rotate(targetPointer[0], 1, targetPointer[2],
					(tmpIndex[0] - cubicleIndex[0]) + (cubicleIndex[2] - tmpIndex[2]));

			while (targetPointer[0] != 1 || targetPointer[1] != 1 || targetPointer[2] != 0) {
				RubiksCube.move("u", 1);
				cubicleIndex = cubeStructure.CubeUtils.findCubie(topColor, targetColor);
				cubicleIndex = cubeStructure.CubeUtils.findCubie(topColor, targetColor);
				targetPointer = cubeStructure.CubeUtils.findPointer(
						cubeStructure.RubiksCube.cubicles[cubicleIndex[0]][cubicleIndex[1]][cubicleIndex[2]],
						targetColor);
			}

			break;

		case 2:
			if (cubicleIndex[0] == 1 && cubicleIndex[1] == 2 && cubicleIndex[2] == 0) {
				RubiksCube.rotate(1, 1, 0, 1);
				System.out.println("rotated case2 if==t");
			} else {
				RubiksCube.move("d", 1);
				System.out.println("rotated in else clause");
			}
			break;

		}

		setTarget(targetColor);

	}

}
