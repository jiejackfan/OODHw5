import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimationModel implements AnimationOperation {

  private final Map<String, IShape> nameMap;
  private final Map<IShape, List<Motion>> animation;
  //private final List<IShape> currentAnimation;

  public AnimationModel() {
    this.nameMap = new HashMap<>();
    this.animation = new HashMap<>();
    //this.currentAnimation = new ArrayList<>();
  }

  private boolean isTimeInListOfMotion(List<Motion> listOfMotion, int time) {
    int startTime = listOfMotion.get(0).getStartTime();
    int endTime = listOfMotion.get(listOfMotion.size() - 1).getEndTime();

    return (time >= startTime && time <= endTime);

  }

  @Override
  public List<IShape> getAnimation(int time) {

    List<IShape> shapesAtTime = new ArrayList<>();

    if (time < 0) {
      throw new IllegalArgumentException("Invalid time.");
    }

    //go through all shapes in map, add to shapeAtTime if we find a shape that have motion at the
    //  exact time
    for (Map.Entry mapPair : animation.entrySet()) {
      if (isTimeInListOfMotion((List<Motion>) mapPair.getValue(), time)) {
        IShape tmpShape = (IShape) mapPair.getKey();
        Motion tmpMotion;
        tmpMotion = findMotion((List<Motion>) mapPair.getValue(), time);

        shapesAtTime.add(buildShape(((IShape) mapPair.getKey()).getShapeName(), tmpMotion, time));
      }
    }
    return shapesAtTime;
  }

  private IShape buildShape(String shapeName, Motion tmpMotion, int time) {
    double ratio = (time - tmpMotion.getStartTime())
            / (tmpMotion.getEndTime() - tmpMotion.getStartTime());
    Color color = new Color(
            (int) ratio * (tmpMotion.getEndColor().getRed() - tmpMotion.getStartColor().getRed())
                    + tmpMotion.getStartColor().getRed(),
            (int) ratio * (tmpMotion.getEndColor().getGreen()
                    - tmpMotion.getStartColor().getGreen())
                    + tmpMotion.getStartColor().getGreen(),
            (int) ratio * (tmpMotion.getEndColor().getBlue()
                    - tmpMotion.getStartColor().getBlue())
                    + tmpMotion.getStartColor().getBlue());
    Position2D position = new Position2D(
            ratio * (tmpMotion.getEndPosition().getX() - tmpMotion.getStartPosition().getX())
                    + tmpMotion.getStartPosition().getX(),
            ratio * (tmpMotion.getEndPosition().getY() - tmpMotion.getStartPosition().getY())
                    + tmpMotion.getStartPosition().getY());
    double width = ratio * (tmpMotion.getEndWidth() - tmpMotion.getStartWidth())
            + tmpMotion.getStartWidth();
    double height = ratio * (tmpMotion.getEndHeight() - tmpMotion.getStartHeight())
            + tmpMotion.getStartHeight();

    switch (shapeName) {
      case "rectangle":
        return new Rectangle(color, position, width, height);
      case "oval":
        return new Oval(color, position, width, height);
      // More shapes can be implemented here.
      default:
        throw new IllegalArgumentException("Please provide a valid shape name.");
    }
  }

  private Motion findMotion(List<Motion> listOfMotion, int time) {
    for (Motion tmpMotion : listOfMotion) {
      int startTime = tmpMotion.getStartTime();
      int endTime = tmpMotion.getEndTime();

      if (time <= startTime && time >= endTime) {
        return new Motion(tmpMotion);
      }
    }
    throw new IllegalArgumentException("Should not reach this point.");
  }

  private Motion findMutatableMotion(List<Motion> listOfMotion, int time) {
    for (Motion tmpMotion : listOfMotion) {
      int startTime = tmpMotion.getStartTime();
      int endTime = tmpMotion.getEndTime();

      if (time <= startTime && time >= endTime) {
        return tmpMotion;
      }
    }
    throw new IllegalArgumentException("Should not reach this point.");
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
  public void removeShape(String name) {
    // Check whether the shape exist in the animation
    if (!nameMap.containsKey(name)) {
      throw new IllegalArgumentException("The given shape is not in the animation.");
    }
    animation.remove(nameMap.get(name));
    nameMap.remove(name);

  }

  @Override
  public void removeMotion(String name, int startTime, int endTime) {


    if (!nameMap.containsKey(name)) {
      throw new IllegalArgumentException("The given shape is not in the animation.");
    }

    /*
    if (!(isTimeInListOfMotion(animation.get(nameMap.get(name)), startTime) &&
            isTimeInListOfMotion(animation.get(nameMap.get(name)), endTime))) {
      throw new IllegalArgumentException("Time not within the range.");
    }
    */

    List<Motion> listOfMotion = animation.get(nameMap.get(name));

    // start time must be less or equal to end time
    if (startTime == endTime) {
      if (startTime == listOfMotion.get(0).getStartTime()) {
        if (listOfMotion.get(0).getStartTime() == listOfMotion.get(0).getEndTime()) {
          listOfMotion.remove(0);
        } else {
          //listOfMotion.get(0).changeStartTime(startTime + 1);
          changeStartingMotion(startTime, listOfMotion);
        }
      } else if (startTime == listOfMotion.get(listOfMotion.size() - 1).getEndTime()) {
        if (listOfMotion.get(listOfMotion.size() - 1).getStartTime()
                == listOfMotion.get(listOfMotion.size() - 1).getEndTime()) {
          listOfMotion.remove(listOfMotion.size() - 1);
        } else {
          //listOfMotion.get(listOfMotion.size() - 1).changeEndTime(endTime - 1);
          changeEndingMotion(endTime, listOfMotion);
        }
      } else {
        throw new IllegalStateException("Can't remove time in middle of motion.");
      }
    } else if (startTime > endTime) {
      throw new IllegalStateException("Start time can't be larger than end time.");
    }

    //if we want to remove from beginning
    else if (startTime <= listOfMotion.get(0).getStartTime()) {
      findMutatableMotion(listOfMotion, endTime).changeStartTime();
      changeStartingMotion();
    }

    //if we want to remove from end
    else if (startTime > listOfMotion.get(0).getStartTime()
            && endTime >= listOfMotion.get(listOfMotion.size() - 1).getEndTime()) {
      changeEndingMotion();
    }


  }

  private Motion changeMotion(Motion tmpMotion, int time, boolean start) {
    double ratio = (time - tmpMotion.getStartTime())
            / (tmpMotion.getEndTime() - tmpMotion.getStartTime());
    Color color = new Color(
            (int) ratio * (tmpMotion.getEndColor().getRed() - tmpMotion.getStartColor().getRed())
                    + tmpMotion.getStartColor().getRed(),
            (int) ratio * (tmpMotion.getEndColor().getGreen()
                    - tmpMotion.getStartColor().getGreen())
                    + tmpMotion.getStartColor().getGreen(),
            (int) ratio * (tmpMotion.getEndColor().getBlue()
                    - tmpMotion.getStartColor().getBlue())
                    + tmpMotion.getStartColor().getBlue());
    Position2D position = new Position2D(
            ratio * (tmpMotion.getEndPosition().getX() - tmpMotion.getStartPosition().getX())
                    + tmpMotion.getStartPosition().getX(),
            ratio * (tmpMotion.getEndPosition().getY() - tmpMotion.getStartPosition().getY())
                    + tmpMotion.getStartPosition().getY());
    double width = ratio * (tmpMotion.getEndWidth() - tmpMotion.getStartWidth())
            + tmpMotion.getStartWidth();
    double height = ratio * (tmpMotion.getEndHeight() - tmpMotion.getStartHeight())
            + tmpMotion.getStartHeight();

    //if we are changing start time
    if (start == true) {

    }

    //if we are changing end time
    else if (start == false) {

    }
  }

  private void changeStartingMotion(int startTime, List<Motion> listOfMotion) {

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
    for (Map.Entry mapPair : nameMap.entrySet()) {
      String name = (String) mapPair.getKey();
      output = output + "Shape " + name + " " + nameMap.get(name).getShapeName() + "\n";
      output = output + listOfMotionsToString(name, animation.get(nameMap.get(name)));
    }
    return output;
  }

  @Override
  public boolean checkValidAnimation() {
    boolean result = true;
    // If there is no motion, the animation is valid
    if (animation.entrySet().isEmpty()) {
      return true;
    }
    // Check whether the list of motions for each shape is valid
    // and combine all results
    // SORT if needed
    for (Map.Entry mapPair : animation.entrySet()) {
      List<Motion> valueList = new ArrayList<>((List<Motion>) mapPair.getValue()); // a shallow copy
//      if (valueList.isEmpty()) {
//        result = result && true;
//      }
      // Check "teleport"
      for (int i = 0; i < (valueList.size() - 1); i++) {
        result = result && (valueList.get(i + 1).getStartTime() == valueList.get(i).getEndTime());
      }
    }
    return result;
  }

  private String listOfMotionsToString(String name, List<Motion> motions) {
    if (!checkValidAnimation()) {
      throw new IllegalStateException("The animation is invalid.");
    }
    String result = "";
    for (Motion m : motions) {
      result = result + "motion " + name + " " + m.toString() + "\n";
    }
    return result;
  }
}
