package edu.nu.csc615.lab5;

import java.awt.Point;

public class Quadrilateral{
	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;

	public Quadrilateral( Point p1, Point p2, Point p3, Point p4 ){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		System.out.println(getInfo());
	}
	
	@Override
	public String toString(){
		return getInfo();
	}
	
	private String getInfo(){
		String string = String.format( "%s: %s, %s, %s, %s", this.getClass().getName(), p1, p2, p3, p4 );
		return string;
	}

	/* getters and setters */
	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}

	public Point getP4() {
		return p4;
	}

	public void setP4(Point p4) {
		this.p4 = p4;
	}

}