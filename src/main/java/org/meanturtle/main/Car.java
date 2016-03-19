package org.meanturtle.main;

public class Car {
	
	private String color;
	private String name;
	private Speed speed;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Speed getSpeed() {
		return speed;
	}
	@Override
	public String toString() {
		return "Car [color=" + color + ", name=" + name + "]";
	}
	public void setMaxSpeed(Speed speed) {
		this.speed = speed;
	}

	
	public boolean doService(String context) {
		if(context == null) {
			return false;
		} else {
			this.color = "Yellow";
		}
		return true;
	}
}
