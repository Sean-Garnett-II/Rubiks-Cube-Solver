package cubeStructure;

public class Cubie {
	Facelet[] facelet;

	public Cubie() {

	}

	public Cubie(Facelet face1) {
		facelet = new Facelet[1];
		facelet[0] = face1;
	}

	public Cubie(Facelet face1, Facelet face2) {
		facelet = new Facelet[2];
		facelet[0] = face1;
		facelet[1] = face2;

	}

	public Cubie(Facelet face1, Facelet face2, Facelet face3) {
		facelet = new Facelet[3];
		facelet[0] = face1;
		facelet[1] = face2;
		facelet[2] = face3;
	}

}