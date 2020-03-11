package cs3500.excellence.hw5;

import java.util.List;

/**
 * This is the interface of the main logic of this animation model. Animation model interface will
 *  can create a shape, remove a shape, add motions to a shape, check if a
 *  listOfMotion is valid, and convert current animation to strings.
 */
public interface AnimationOperation {

  /**
   * This function will create a shape (out of rectangle, oval).
   *  User will store this shape into two map data structures that will be used to represent the
   *  entire animation.
   *
   * @param shape This is a string that represents the shape user wants to create. This can be
   *              one of "rectangle", "oval".
   * @param name This is a custom name the user can assign to this shape.
   * @throws IllegalArgumentException This function will throw IAE if:
   *        1.shape is null or "".
   *        2.name is null or "".
   *        3.shape user wants to create does not exist.
   */
  void createShape(String shape, String name);

  /**
   * Removes a shape and its corresponding list of motions from the animation
   * @param name User can delete a shape by passing in the custom name that was assigned in the
   *             beginning.
   */
  void removeShape(String name);


  //void removeMotion(String name, int startTime, int endTime);

  /**
   * This function will add one motion (transition of attributes of a shape from a time to another)
   * to a corresponding shape.
   * @param name This is the custom name of the shape that user wants to add the motion to.
   * @param startTime Start time of the shape.
   * @param startX Start position X of the shape.
   * @param startY Start position Y of the shape.
   * @param startWidth Start width of the shape.
   * @param startHeight Start height of the shape.
   * @param startColorR Start red color of the shape.
   * @param startColorB Start blue color of the shape.
   * @param startColorG Start green color of the shape.
   * @param endTime End time of the shape.
   * @param endX End position X of the shape.
   * @param endY End position Y of the shape.
   * @param endWidth End width of the shape.
   * @param endHeight End height of the shape.
   * @param endColorR End red color of the shape.
   * @param endColorB End blue color of the shape.
   * @param endColorG End green color of the shape.
   */
  void addMotion(String name, int startTime, int startX, int startY, double startWidth,
                 double startHeight, int startColorR, int startColorB, int startColorG,
                 int endTime, int endX, double endY, double endWidth,
                 double endHeight, int endColorR,
                 int endColorB, int endColorG);

  /**
   * Return the complete animation as a string that discribes a shape and its list of motions.
   * It is formated as follow:
   * <pre>
   * F1:[b]f11,[b]f12,[b],...,[b]f1n1[n] (Cards in foundation pile 1 in order)
   * F2:[b]f21,[b]f22,[b],...,[b]f2n2[n] (Cards in foundation pile 2 in order)
   * ...
   * Fm:[b]fm1,[b]fm2,[b],...,[b]fmnm[n] (Cards in foundation pile m in
   * order)
   * O1:[b]o11[n] (Cards in open pile 1)
   * O2:[b]o21[n] (Cards in open pile 2)
   * ...
   * Ok:[b]ok1[n] (Cards in open pile k)
   * C1:[b]c11,[b]c12,[b]...,[b]c1p1[n] (Cards in cascade pile 1 in order)
   * C2:[b]c21,[b]c22,[b]...,[b]c2p2[n] (Cards in cascade pile 2 in order)
   * ...
   * Cs:[b]cs1,[b]cs2,[b]...,[b]csps (Cards in cascade pile s in order)
   *
   * where [b] is a single blankspace, [n] is newline.
   * </pre>
   *
   * @return the formated string as above.
   * @throws IllegalStateException if any shape in the Animation has overlapping attributes or
   * teleportation.
   */
  String toString();

  boolean checkValidAnimation(List<Motion> lom);

  List<IShape> getAnimation(int time);

}
