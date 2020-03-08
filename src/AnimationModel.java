import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimationModel implements AnimationOperation {

  private final Map<String, IShape> nameMap;
  private final Map<IShape, List<Motion>> animation;

  public AnimationModel() {
    this.nameMap = new HashMap<>();
    this.animation = new HashMap<>();
  }

  @Override
  public void createShape(String shape, String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("The name cannot be null or empty.");
    }
    if (shape == null || shape.equals("")) {
      throw new IllegalArgumentException("Invalid shape input.");
    }
    switch (shape.toLowerCase()) {
      case "rectangle":
        nameMap.put(name, new Rectangle());
        animation.put(nameMap.get(name), new ArrayList<>());
        break;
      case "oval":
        nameMap.put(name, new Oval());
        animation.put(nameMap.get(name), new ArrayList<>());
        break;
      // More shapes can be implemented here.
      default:
        throw new IllegalArgumentException("Please provide a valid shape.");
    }
  }

  @Override
  public void addMotion(String name, int startTime, int startX, int startY, double startWidth,
                        double startHeight, int startColorR, int startColorB, int startColorG,
                        int endTime, int endX, double endY, double endWidth,
                        double endHeight, int endColorR,
                        int endColorB, int endColorG) {
    // Check whether the given parameters of color are valid, if they are valid, pass into the color
    // constructor, if not, throw an illegal argument exception.
    if (startColorR < 0 || startColorR > 255 || endColorR < 0 || endColorR > 255
            || startColorG < 0 || startColorG > 255 || endColorG < 0 || endColorG > 255
            || startColorB < 0 || startColorB > 255 || endColorB < 0 || endColorB > 255) {
      throw new IllegalArgumentException("The RGB value must be within the range.");
    }
    // Other parameters are check when constructing the motion, and the parameters of position are
    // checked in the position2D in the constructor of class position2D.
    animation.get(nameMap.get(name)).add(
            new Motion(startTime, new Position2D(startX, startY), startWidth, startHeight,
                    new Color(startColorR, startColorG, startColorB), endTime,
                    new Position2D(endX, endY), endWidth, endHeight,
                    new Color(endColorR, endColorG, endColorB)));
  }

  @Override
  public String toString() {
    String output = "";
    // If there is no shapes on the animation, print an empty string
    if (nameMap.entrySet().isEmpty()) {
      return output;
    }
    for (Map.Entry mapKey : nameMap.entrySet()) {
      String name = (String) mapKey.getKey();
      output = output + "Shape " + name + " " + nameMap.get(name).getShapeName() + "\n";
      output = output + listOfMotionsToString(name, animation.get(nameMap.get(name)));
    }
    return output;
  }

  private String listOfMotionsToString(String name, List<Motion> motions) {
    String result = "";
    for (Motion m : motions) {
      result = result + "motion " + name + " " + m.toString() + "\n";
    }
    return result;
  }
}
