import java.awt.*;

/**
 * This abstract class represents a generic geometric shape and contains common fields and
 * operations.
 */
public abstract class AShape implements IShape {

  protected String name;
  protected Color color;
  protected Position2D position;
  protected double width;
  protected double height;

  public AShape(String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("The name cannot be null or empty.");
    }
    this.name = name;
  }

  public AShape(String name, Color color, Position2D position, double width, double height) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("The name cannot be null or empty.");
    }

    this.name = name;
    this.color = color;
    this.position = position;
    this.width = width;
    this.height = height;
  }

}
