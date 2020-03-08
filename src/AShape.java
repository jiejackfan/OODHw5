import java.awt.*;

/**
 * This abstract class represents a generic geometric shape and contains common fields and
 * operations.
 */
public abstract class AShape implements IShape {

  protected Color color;
  protected Position2D position;
  protected double width;
  protected double height;
  protected String shapeName;

  public AShape() {
    //
  }

  public AShape(Color color, Position2D position, double width, double height, String shapeName) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The width and height must be positive");
    }
    this.color = color;
    this.position = position;
    this.width = width;
    this.height = height;
    this.shapeName = shapeName;
  }

  @Override
  public String getShapeName() {
    return this.shapeName;
  }

}
