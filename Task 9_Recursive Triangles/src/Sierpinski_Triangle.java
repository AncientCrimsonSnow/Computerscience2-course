public class Sierpinski_Triangle {
	
	private Point p1;
	private Point p2;
	private Point p3;
	public Point getP1() {
		return p1;
	}
	public Point getP2() {
		return p2;
	}
	public Point getP3() {
		return p3;
	}
	public int[] getXpoints(){
		int[]xpoints = {
				getP1().getX(),
				getP2().getX(),
				getP3().getX()
		};
		return xpoints;
	}
	public int[] getYpoints(){
		int[]ypoints = {
				getP1().getY(),
				getP2().getY(),
				getP3().getY()
		};
		return ypoints;
	}
	
	//Safeing the lower Triangles.
	private Sierpinski_Triangle st1;
	private Sierpinski_Triangle st2;
	private Sierpinski_Triangle st3;
	
	public Sierpinski_Triangle getSt1() {
		return st1;
	}
	public Sierpinski_Triangle getSt2() {
		return st2;
	}
	public Sierpinski_Triangle getSt3() {
		return st3;
	}
	
	private int depth;
	public int getDepth() {
		return depth;
	}
	
	public Sierpinski_Triangle(int depth, Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.depth = depth;
		if(depth != 0) {
			depth--;
			Point midP1 = UM.getMidpoint(p1, p2);
			Point midP2 = UM.getMidpoint(p2, p3);
			Point midP3 = UM.getMidpoint(p1, p3);
			st1 = new Sierpinski_Triangle(depth, p1, midP1, midP3);
			st2 = new Sierpinski_Triangle(depth, midP1, p2, midP2);
			st3 = new Sierpinski_Triangle(depth, midP3, midP2, p3);		
		}
	}
}
