package mast.testSideScroller.entites;

public class Moveable {

	private int dX = 0, dY = 0, x = 0, y = 0;
	private EntityID ID;
	
	public Moveable(EntityID id){
		ID = id;
	}
	
	public Moveable(int x, int y, EntityID id){
		this.x = x;
		this.y = y;
		ID = id;
	}

	
	//getters and setters for variables
	public EntityID getID() {
		return ID;
	}

	public void setID(EntityID iD) {
		ID = iD;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getdX() {
		return dX;
	}

	public void setdX(int dX) {
		this.dX = dX;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getdY() {
		return dY;
	}

	public void setdY(int dY) {
		this.dY = dY;
	}
	
}
