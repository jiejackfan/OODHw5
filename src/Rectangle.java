import java.awt.*;

public class Rectangle extends AShape {

  public Rectangle() {
    super();
    this.shapeName = "rectangle";
  }

  public Rectangle(Color color, Position2D position, double width, double height, String shapeName) {
    super(color, position, width, height, "rectangle");
  }

}
