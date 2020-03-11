package cs3500.excellence.hw5;

import cs3500.excellence.hw5.AShape;
import cs3500.excellence.hw5.Position2D;
import java.awt.*;


public class Rectangle extends AShape {

  public Rectangle() {
    super();
    this.shapeName = "rectangle";
  }

  public Rectangle(Color color, Position2D position, double width, double height) {
    super(color, position, width, height);
    this.shapeName = "rectangle";
  }

}
