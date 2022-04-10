/*
Author: Daniel Beiers c3039134
Date:
Project: SENG2200 Assignment 2
Description: PlanarShapes is an abstract class. It ensures that all extended classes contain the necessary
methods to compare its children to one another.
 */
public abstract class PlanarShape implements Comparable<PlanarShape> {

    public abstract double area();

    public abstract double originDistance();

    public abstract String toString();

    @Override
    public int compareTo(PlanarShape p) {

        double tolerance;
        double tolerance_factor = 0.0005;

        if (this.area() <= p.area()) {
            tolerance = this.area() * tolerance_factor;
        } else {
            tolerance = p.area() * tolerance_factor;
        }

        if (Math.abs(p.area() - this.area()) <= tolerance) {
            if (this.originDistance() == p.originDistance())
                return 0;
            else if (this.originDistance() < p.originDistance())
                return -1;
            else if (this.originDistance() > p.originDistance())
                return 1;
        }
        else if(this.area() < p.area())
            return -1;

        return 1;
    }
}
