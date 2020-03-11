package cs3500.excellence.hw5;

import cs3500.excellence.hw5.AShape;
import cs3500.excellence.hw5.Position2D;
import java.awt.*;

/**
 * A rectangle shape implementation that is extending the abstract shape class. This class will be
 *  used mainly during initialization. The purpose is to assign "rectange" to shapeName variable in
 *  the abstract class so later on we know this shape is a rectangle.
 */
public class Rectangle extends AShape {

  /**
   * Constructor to a rectangle that assigns "rectangle" to the shapeName variable in the abstract
   * class.
   */
  public Rectangle() {
    super();
    this.shapeName = "rectangle";
  }

  /**
   * Constructor to a rectangle that assigns the "rectangle: to the shapeName variable and also
   * assign some characteristics to this shape and store all of these variable to the abstract
   * class.
   * @param color
   * @param position
   * @param width
   * @param height
   */
  public Rectangle(Color color, Position2D position, double width, double height) {
    super(color, position, width, height);
    this.shapeName = "rectangle";
  }

}
