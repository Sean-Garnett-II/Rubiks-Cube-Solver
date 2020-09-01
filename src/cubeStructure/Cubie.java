package cubeStructure;

public class Cubie {
	Facelet[] face;
	
	public Cubie(){
		
	}
	
	public Cubie(Facelet face1) {
		face = new Facelet[1];
		face[0] = face1;
	}
	
	public Cubie(Facelet face1, Facelet face2) {
		face = new Facelet[2];
		face[0] = face1;
		face[1] = face2;

	}
	
	public Cubie(Facelet face1, Facelet face2, Facelet face3) {
		face = new Facelet[3];
		face[0] = face1;
		face[1] = face2;
		face[2] = face3;
	}
	
}