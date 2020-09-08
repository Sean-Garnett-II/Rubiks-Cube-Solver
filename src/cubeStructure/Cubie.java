package cubeStructure;

public class Cubie {
	Facelet[] facelet;

	public Cubie() {
		facelet = null;
	}

	public Cubie(Facelet facelet1) {
		facelet = new Facelet[1];
		facelet[0] = facelet1;
	}

	public Cubie(Facelet facelet1, Facelet facelet2) {
		facelet = new Facelet[2];
		facelet[0] = facelet1;
		facelet[1] = facelet2;
	}

	public Cubie(Facelet facelet1, Facelet facelet2, Facelet facelet3) {
		facelet = new Facelet[3];
		facelet[0] = facelet1;
		facelet[1] = facelet2;
		facelet[2] = facelet3;
	}

}