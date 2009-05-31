package edu.nu.csc615.lab5;

import java.awt.Point;

public class Trapezoid extends Quadrilateral{

	public Trapezoid(Point p1, Point p2, Point p3, Point p4){
		super(p1, p2, p3, p4);
	}

	public double getHeight(){
		return (getP1().getY()==getP2().getY())?Math.abs(getP2().getY()-getP3().getY()):Math.abs( getP1().getY()-getP2().getY());
	}

	public double getArea(){
		double height = getHeight();
		double base = (getP1().getY()==getP2().getY())?Math.abs(getP1().getX()-getP2().getX())+Math.abs(getP3().getX()-getP4().getX()):Math.abs(getP2().getX()-getP3().getX())+Math.abs(getP4().getX()-getP1().getX());
		return height * base / 2.;
	}

	@Override
	public String toString(){
		return String.format("Height:%s, Area:%s", getHeight(), getArea());
	}
}
