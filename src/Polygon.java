/*
Author: Daniel Beiers c3039134
Date:
Project: SENG2200 Assignment 2
Description:    This class is an object designed to hold information regarding the vertices of a polygon.
                An array is initialised, and each element is a Point object.
                The points of the polygon are fed into the array by addPoint(Point p).
                This class also has methods to find the area of the polygon and return a double,
                the distance to origin as a double and to output the points of the polygon as a string.
*/
public class Polygon extends PlanarShape{

    //Private variables
    //'originPoint' holds a Point that is determined to be closest to the origin. Updated as every Point is added.
    //'vertices' is an array that holds the vertices of the polygon.
    //'TOLERANCE_FACTOR' is the value by which polygons are compared and attributed to be the same area.
    private Point originPoint;
    private Point[] vertices;

    public Polygon(){
        originPoint = null;
        vertices = new Point[0];
    }
    public Polygon(double[] coords){
        originPoint = null;
        vertices = new Point[0];
        if(coords[0] == 0){
            originPoint = null;
            vertices = new Point[0];
        }

        for(int i = 1; i < coords.length; i += 2) {
            Point p = new Point(coords[i],coords[i+1]);
            this.addPoint(p);
        }
    }

    //Standard getters and setters
    public Point getOriginPoint() {
        return originPoint;
    }

    public void setOriginPoint(Point originPoint) {
        this.originPoint = originPoint;
    }


    public Point[] getVertices() {
        return vertices;
    }

    public void setVertices(Point[] vertices) {
        this.vertices = vertices;
    }

    //This method takes a Point object as a parameter. The current 'vertices' array is replicated and size incremented.
    //The new Point is then added to the last index of the array.
    //The new Point's distance to the origin is calculated and compared to the current lowest value. If less, new Point is stored in 'originPoint'.
    public void addPoint(Point point_){
        if(vertices.length == 0) {
            Point[] tempPoly = new Point[1];
            tempPoly[0] = point_;
            vertices = tempPoly;
            originPoint = point_;
        }
        else {
            Point[] tempPoly = new Point[vertices.length + 1];
            int i=0;
            for(Point p:vertices) {
                tempPoly[i] = p;
                i++;
            }
            tempPoly[i] = point_;
            vertices = tempPoly;
            if(point_.distanceToOrigin() < originPoint.distanceToOrigin())
                originPoint = point_;
        }
    }

    //This method uses the shoelace theorem to calculate the area of the polygon.
    //If the polygon contains less than 2 points, the method returns zero, else returns the area as a double floating point.
    public double area(){
        double sum = 0;
        if(vertices.length > 1) {
            for (int i = 0; i < vertices.length - 1; i++) {

                double x1 = vertices[i].getX();
                double y1 = vertices[i].getY();
                double x2 = vertices[i + 1].getX();
                double y2 = vertices[i + 1].getY();

                sum = sum + ((x2 + x1) * (y2 - y1));
                if (i == vertices.length - 2) {
                    sum += ((vertices[0].getX() + x2) * (vertices[0].getY() - y2));
                }
            }
        }
        sum = Math.abs(sum) / 2;

        return sum;
    }

    public double originDistance(){

        return originPoint.distanceToOrigin();
    }

    //The toString method is overridden to return the array elements as a string with the area appended to the end to two decimal places.
    public String toString(){
        area();
        String output = "POLY=[";
        String area = "0.00";
        if(vertices.length != 0) {
            for (Point point_ : vertices) {
                output += point_.toString();
            }
            area = String.format("%5.2f", this.area());
        }
        output = output + "]: " + area;

        return output;
    }
}
