package mast.testSideScroller.entites;

import org.newdawn.slick.geom.Rectangle;

public abstract class Moveable {

	private int x = 0, y = 0;
	public Rectangle hitbox;
	private double dY = 0;
	private EntityID ID;
	
	public Moveable(int x, int y, EntityID id){
		this.x = x;
		this.y = y;
		ID = id;
		hitbox = new Rectangle(x, y, 32, 32);
	}

	abstract void tick(int delta);
	
	private void moveableTick(int delta){
		tick(delta);
	}
	
	protected void addToX(int i){
		x += i;
	}
	
	protected void addToY(double d){
		y += d;
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

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getdY() {
		return dY;
	}

	public void setdY(double dY) {
		this.dY = dY;
	}
	
	public void addTodY(double a){
		this.dY += a;
	}
	
}
