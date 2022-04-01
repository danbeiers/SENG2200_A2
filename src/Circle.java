/*
Author: Daniel Beiers c3039134
Date:
Project: SENG2200 Assignment 2
Description:
*/
public class Circle extends PlanarShape{
    private Point centre;
    private double radius;

    public Circle(){
        this.centre = new Point();
        this.radius = 0;
    }

    public Circle(double xVal, double yVal, double radius_) {
        this.centre = new Point(xVal,yVal);
        this.radius = radius_;
    }

    public Circle(double[] d) {
        this.centre = new Point(d[0],d[1]);
        this.radius = d[2];
    }
    public double area() {
        return (Math.PI * Math.sqrt(this.radius));
    }

    public double originDistance() {
        return Math.abs(centre.distanceToOrigin() - this.radius);
    }

    public String toString() {
        double area = area();

        String output = String.format("CIRC=[%s %3.2f]: %5.2f",centre.toString(),this.radius, area);

        return output;
    }
}
