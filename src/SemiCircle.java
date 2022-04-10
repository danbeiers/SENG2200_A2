/*
Author: Daniel Beiers c3039134
Date: 10.4.2022
Project: SENG2200 Assignment 2
Description: A child class of PlanarShape, SemiCircle takes a center point and a coordinate perpendicular to the center point and diameter line.
*/
public class SemiCircle extends PlanarShape{
    //Private variables of the two initial points and the calculable radius
    private Point p0, p1;
    private double radius;

    //Constructor accepting two Point objects as parameters
    public SemiCircle(Point p0_, Point p1_) {
        this.p0 = p0_;
        this.p1 = p1_;
        this.radius = Math.sqrt((Math.pow(this.p0.getX() - this.p1.getX(),2) + (Math.pow(this.p0.getY() - this.p1.getY(),2))));
    }

    //Constructor accepting the initial parameters via a double array
    public SemiCircle(double[] d) {
        this.p0 = new Point(d[0],d[1]);
        this.p1 = new Point(d[2],d[3]);
        this.radius = Math.sqrt((Math.pow(this.p0.getX() - this.p1.getX(),2) + (Math.pow(this.p0.getY() - this.p1.getY(),2))));
    }

    //Abstract implementation of super class specific to SemiCircle.
    //Pre-Condition: None
    //Post-Condition: The area of the semi-circle returned as a double.
    public double area() {
        return (Math.PI * Math.pow(this.radius,2) / 2 );
    }

    //Compares the distance to the origin from the 4 points, and returns the shortest distance to the origin.
    //Abstract implementation of super class specific to SemiCircle.
    //Pre-Condition: None
    //Post-Condition: The shortest distance to the origin from 4 points on the semi-circle returned as a double.
    public double originDistance() {
        //Define the two points on the circumference and diameter line.
        Point p2 = new Point((this.p0.getX() - Math.abs(this.p0.getY() - this.p1.getY())),(this.p0.getY() + Math.abs(this.p0.getX() - this.p1.getX())));
        Point p3 = new Point((this.p0.getX() + Math.abs(this.p0.getY() - this.p1.getY())),(this.p0.getY() - Math.abs(this.p0.getX() - this.p1.getX())));

        Point[] pointArray = {this.p0,this.p1,p2,p3};
        double shortestDist = 0;
        for(Point p:pointArray){
            double distance = p.distanceToOrigin();
            if(distance <= shortestDist)
                shortestDist = distance;
        }

        return shortestDist;
    }

    //Abstract implementation of super class specific to SemiCircle.
    //Pre-Condition: None
    //Post-Condition: String representation returned in spec format.
    public String toString() {
        double area = area();

        String output = String.format("SEMI=[%s%s]: %5.2f",this.p0.toString(),this.p1.toString(), area);

        return output;
    }
}
