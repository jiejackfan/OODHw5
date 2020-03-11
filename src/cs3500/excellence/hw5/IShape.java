package cs3500.excellence.hw5;

/**
 * This interface represents a geometric shape and contains a lists of operations.
 */
public interface IShape {

  String getShapeName();

  // void changeAttributes(Color color, Position2D pos, double width, double height);

  int hashCode();

  boolean equals(Object that);
}
