import java.util.List;

public interface AnimationOperation {

  void createShape(String shape, String name);

  void removeShape(String name);

  void removeMotion(String name, int startTime, int endTime);

  void addMotion(String name, int startTime, int startX, int startY, double startWidth,
                 double startHeight, int startColorR, int startColorB, int startColorG,
                 int endTime, int endX, double endY, double endWidth,
                 double endHeight, int endColorR,
                 int endColorB, int endColorG);

  String toString();

  boolean checkValidAnimation();

  List<IShape> getAnimation(int time);

}
