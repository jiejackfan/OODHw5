package cs3500.excellence.hw5;
import java.awt.*;

/**
 * This interface represents a geometric shape and contains a lists of operations.
 */
public interface IShape {

  String getShapeName();

  void changeAttributes(Color color, Position2D pos, double width, double height);

}
