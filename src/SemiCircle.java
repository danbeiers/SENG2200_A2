/*
Author: Daniel Beiers c3039134
Date:
Project: SENG2200 Assignment 2
Description:
*/
public class SemiCircle extends PlanarShape{

    private Point p0, p1;
    private double radius;

    public SemiCircle(Point p0_, Point p1_) {
        this.p0 = p0_;
        this.p1 = p1_;
        this.radius = Math.sqrt((Math.pow(this.p0.getX() - this.p1.getX(),2) + (Math.pow(this.p0.getY() - this.p1.getY(),2))));
    }

    public double area() {
        return (Math.PI * Math.pow(this.radius,2) / 2 );
    }

    //Compares the distance to the origin from the 4 points, and returns the shortest distance to the origin.
    public double originDistance() {
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

    public String toString() {
        double area = area();

        String output = String.format("SEMI=[%s%s]: %5.2f",this.p0.toString(),this.p1.toString(), area);

        return output;
    }
}
