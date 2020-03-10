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

  public AShape(Color color, Position2D position, double width, double height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The width and height must be positive");
    }
    this.color = color;
    this.position = position;
    this.width = width;
    this.height = height;
  }


  //copy constructor
  public AShape(AShape shape) {
    this.color = shape.color;
    this.position = shape.position;
    this.width = shape.width;
    this.height = shape.height;
    this.shapeName = shape.shapeName;
  }


  @Override
  public void changeAttributes(Color color, Position2D pos, double width, double height) {
    this.color = color;
    this.position = pos;
    this.width = width;
    this.height = height;
  }


  @Override
  public String getShapeName() {
    return this.shapeName;
  }


}
