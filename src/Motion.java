import java.awt.*;


// DO WE NEED AN INTERFACE FOR MOTION?
public class Motion {

  private int startTime;
  private int endTime;
  private Position2D startPosition;
  private Position2D endPosition;

  private double startWidth;
  private double endWidth;
  private double startHeight;
  private double endHeight;

  private Color startColor;
  private Color endColor;

  public Motion(int startTime, Position2D startPosition, double startWidth, double startHeight,
                Color startColor, int endTime, Position2D endPosition, double endWidth, double endHeight,
                Color endColor) {
    // Check whether the given times are valid.
    if (startTime < 1 || endTime < 1) {
      throw new IllegalArgumentException("Invalid time.");
    }
    // Check whether the given sizes are valid.
    if (startWidth <= 0 || startHeight <= 0 || endWidth <= 0 || endHeight <= 0) {
      throw new IllegalArgumentException("The size must be positive.");
    }

    this.startTime = startTime;
    this.startPosition = startPosition;
    this.startWidth = startWidth;
    this.startHeight = startHeight;
    this.startColor = startColor;

    this.endTime = endTime;
    this.endPosition = endPosition;
    this.endWidth = endWidth;
    this.endHeight = endHeight;
    this.endColor = endColor;
  }

  @Override
  public String toString() {
    String output;
    output = String.join(" ", Integer.toString(startTime),
            Double.toString(startPosition.getX()),
            Double.toString(startPosition.getY()),
            Double.toString(startWidth), Double.toString(startHeight),
            Integer.toString(startColor.getRed()),
            Integer.toString(startColor.getGreen()),
            Integer.toString(startColor.getBlue()),
            Integer.toString(endTime),
            Double.toString(endPosition.getX()),
            Double.toString(endPosition.getY()),
            Double.toString(endWidth), Double.toString(endHeight),
            Integer.toString(endColor.getRed()),
            Integer.toString(endColor.getGreen()),
            Integer.toString(endColor.getBlue()));
    return output;
  }

  public int getStartTime() {
    return startTime;
  }

  public int getEndTime() {
    return endTime;
  }

}
