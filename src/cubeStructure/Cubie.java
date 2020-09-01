package cubeStructure;

public class Cubie {

	char facelet1, facelet2, facelet3;
	int fCount;

	public Cubie() {
		fCount = 0;
	}

	public Cubie(char color1) {
		facelet1 = color1;
		fCount = 1;
	}

	public Cubie(char color1, char color2) {
		facelet1 = color1;
		facelet2 = color2;
		fCount = 2;
	}

	public Cubie(char color1, char color2, char color3) {
		facelet1 = color1;
		facelet2 = color2;
		facelet2 = color3;
		fCount = 3;
	}

}
