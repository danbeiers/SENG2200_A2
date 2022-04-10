/*
Author: Daniel Beiers c3039134
Date: 10.4.2022
Project: SENG2200 Assignment 2
Description: PlanarShapes is an abstract class. It ensures that all extended classes contain the necessary
methods to compare its children to one another. It also implements a comparable method to compare the area of planar shapes
that complies with the assignment spec.
 */
public abstract class PlanarShape implements Comparable<PlanarShape> {

    public abstract double area();

    public abstract double originDistance();

    public abstract String toString();

    //Pre-Condition: None
    //Post-Condition: Returns positive integer if this object area is greater than passed object area.
    //                 If within a 0.05% area tolerance, returns positive integer if smaller distance to origin object is the passed object parameter.
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
