import java.awt.*;

public interface AnimationOperation {

  void createShape(String shape, String name);

  void addMotion(int startTime, int endTime, Position2D startPosition, Position2D endPosition,
                 double startWidth, double endWidth, double startHeight, double endHeight,
                 Color startColor, Color endColor);

}
