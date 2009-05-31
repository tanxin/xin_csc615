package edu.nu.csc615.lab5;

import java.awt.Point;

public class Parallelogram extends Trapezoid{
	public Parallelogram(Point p1, Point p2, Point p3, Point p4){
		super(p1, p2, p3, p4);
	}

	public double getWidth(){
		return (getP1().getY()==getP2().getY())?Math.abs(getP1().getX()-getP2().getX()):Math.abs(getP2().getX()-getP3().getX());
	}

	@Override
	public String toString(){
		return String.format("Width:%s, Height:%s, Area:%s", getWidth(), getHeight(), getArea());
	}
}