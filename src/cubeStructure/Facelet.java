package cubeStructure;

public class Facelet {
	private char color;
	int[] pointer = new int[3];

	public Facelet(char color, int x, int y, int z) {
		this.color = color;
		this.pointer[0] = x;
		this.pointer[1] = y;
		this.pointer[2] = z;

	}

	public char getColor() {
		return this.color;
	}

	public void setColor(char color) {
		this.color = color;
	}

}
