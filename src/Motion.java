

public class Motion {

  private int startTime;
  private int endTime;
  private Position2D startPosition;
  private Position2D endPosition;

  public Motion(int startTime, int endTime, Position2D startPosition, Position2D endPosition) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.startPosition = startPosition;
    this.endPosition = endPosition;
  }

}
