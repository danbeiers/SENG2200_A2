/*
Author: Daniel Beiers c3039134
Date: 10.4.2022
Project: SENG2200 Assignment 2
Description: A child class of the PlanarShape class to record the center and radius of a circle.
*/
public class Circle extends PlanarShape{
    //Private variables to store specific parameters associated with a circle on the cartesian plane.
    private Point centre;
    private double radius;

    //Default constructor
    public Circle(){
        this.centre = new Point();
        this.radius = 0;
    }

    //Constructor with explicitly passed parameter values
    public Circle(double xVal, double yVal, double radius_) {
        this.centre = new Point(xVal,yVal);
        this.radius = radius_;
    }

    //Constructor the parameters passed within a double array.
    public Circle(double[] d) {
        this.centre = new Point(d[0],d[1]);
        this.radius = d[2];
    }

    //Parent class interface implementation to calculate the area.
    //Pre-Condition: None
    //Post-Condition: Area of the circle returned as a double.
    public double area() {
        return (Math.PI * Math.sqrt(this.radius));
    }

    //Parent class interface implementation to calculate the shortest distance to the origin from any point around circumference.
    //Pre-Condition: None
    //Post-Condition: Distance to origin from circumference edge returned as a double.
    public double originDistance() {
        return Math.abs(centre.distanceToOrigin() - this.radius);
    }

    //Parent class interface implementation to return a formatted string representing the circle.
    //Pre-Condition: None
    //Post-Condition: String representation of a circle returned.
    public String toString() {
        double area = area();

        String output = String.format("CIRC=[%s %3.2f]: %5.2f",centre.toString(),this.radius, area);

        return output;
    }
}
