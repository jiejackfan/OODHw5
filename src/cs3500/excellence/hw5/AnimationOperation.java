package cs3500.excellence.hw5;

import java.util.List;

public interface AnimationOperation {

  void createShape(String shape, String name);

  void removeShape(String name);

  void addMotion(String name, int startTime, int startX, int startY, double startWidth,
                 double startHeight, int startColorR, int startColorG, int startColorB,
                 int endTime, int endX, double endY, double endWidth,
                 double endHeight, int endColorR,
                 int endColorG, int endColorB);

  String toString();

  List<IShape> getAnimation(int time);

  //void removeMotion(String name, int startTime, int endTime);

}
