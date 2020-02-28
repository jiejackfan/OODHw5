import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimationModel implements AnimationOperation {

  private final Map<IShape, List<Motion>> animation = new HashMap<>();

  @Override
  public void createShape(String shape, String name) {
    if (shape == null || shape.equals("")) {
      throw new IllegalArgumentException("Invalid shape input.");
    }
    switch (shape.toLowerCase()) {
      case "rectangle":
        animation.put(new Rectangle(name), null); // What should be the value?
        break;
      case "Oval":
        animation.put(new Oval(name), null);
        break;
      // More shapes can be implemented here.
      default:
        throw new IllegalArgumentException("Please provide a valid shape.");
    }
  }

  @Override
  public void addMotion(int startTime, int endTime, Position2D startPosition, Position2D endPosition,
                        double startWidth, double endWidth, double startHeight, double endHeight,
                        Color startColor, Color endColor) {

  }
}
