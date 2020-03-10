package cs3500.excellence.hw5;

import cs3500.excellence.hw5.AShape;
import java.awt.*;

public class Oval extends AShape {

  public Oval() {
    super();
    this.shapeName = "oval";
  }

  public Oval(Color color, Position2D position, double width, double height) {
    super(color, position, width, height);
    this.shapeName = "oval";
  }

}
