package cs3500.excellence.hw5;

import java.awt.*;
import java.util.Objects;

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

  /**
   * Constructor of abstract shape that does not conduct assignment. This will be used when the
   * the system creates a shape without a list of motions.
   */
  public AShape() {
    //
  }

  /**
   * Constructor of abstract shape that conducts assignment. This will be used if system creates a
   *  shape with initialization values.
   * @param color value of the shape that should be initialized.
   * @param position value of the shape that should be initialized.
   * @param width value of the shape that should be initialized.
   * @param height value of the shape that should be initialized.
   */
  public AShape(Color color, Position2D position, double width, double height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The width and height must be positive");
    }
    this.color = color;
    this.position = position;
    this.width = width;
    this.height = height;
  }


  /**
   * Copy constructor of abstract shape so the user can make a copy of another shape.
   * @param shape the user wants to make a copy of.
   */
  public AShape(AShape shape) {
    this.color = shape.color;
    this.position = shape.position;
    this.width = shape.width;
    this.height = shape.height;
    this.shapeName = shape.shapeName;
  }


  @Override
  public String getShapeName() {
    return this.shapeName;
  }


  @Override
  public int hashCode() {
    return Objects.hash(color, position, width, height, shapeName);
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    } else {
      if (!(that instanceof AShape)) {
        return false;
      }
      return (this.color.equals(((AShape) that).color))
              && (this.position.equals(((AShape) that).position))
              && (Math.abs(this.width - ((AShape) (that)).width) < 0.1)
              && (Math.abs(this.height - ((AShape) (that)).height) < 0.1)
              && (this.shapeName.equals(((AShape) (that)).shapeName));
    }
  }

}
