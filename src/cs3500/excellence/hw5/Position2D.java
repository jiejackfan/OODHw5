package cs3500.excellence.hw5;

import java.util.Objects;

/**
 * Position class that will store where the animation is currently at.
 */
public class Position2D {

  private double x;
  private double y;


  public Position2D(double x, double y) {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("The coordinates cannot be negative.");
    }
    this.x = x;
    this.y = y;
  }

  public Position2D(Position2D position) {
    this(position.x, position.y);
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Position2D)) {
      return false;
    }
    Position2D that = (Position2D) o;
    return ((Math.abs(this.x - that.x) < 0.01) && (Math.abs(this.y - that.y) < 0.01));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }

  @Override
  public String toString() {
    return String.format("(%f, %f)", this.x, this.y);
  }

}
