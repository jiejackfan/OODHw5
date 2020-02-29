public interface AnimationOperation {

  void createShape(String shape, String name);

  void addMotion(String name, int startTime, int startX, int startY, double startWidth,
                 double startHeight, int startColorR, int startColorB, int startColorG,
                 int endTime, int endX, double endY, double endWidth,
                 double endHeight, int endColorR,
                 int endColorB, int endColorG);

  String toString();

}
