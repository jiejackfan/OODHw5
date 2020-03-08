import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimationModelTest {

  AnimationOperation animationOne = new AnimationModel();

  @Test
  public void testNoShapeToString() {
    assertEquals("", animationOne.toString());
  }

  @Test
  public void testShapesNoMotionToString() {
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");
    assertEquals("Shape R rectangle\nShape O oval\n", animationOne.toString());
  }

  @Test
  public void testShapesMotionsToString() {
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");

    animationOne.addMotion("R", 1, 200, 200, 50,
            100, 255, 0, 0, 10,
            200, 200, 50, 100, 255, 0, 0);
    animationOne.addMotion("R", 10, 200, 200, 50,
            100, 255, 0, 0, 50,
            300, 300, 50, 100, 255, 0, 0);
    animationOne.addMotion("O", 6, 440, 70, 120,
            60, 0, 0, 255, 20,
            440, 70, 120, 60, 0, 0, 255);
    animationOne.addMotion("O", 20, 440, 70, 120,
            60, 0, 0, 255, 50,
            440, 250, 120, 60, 0, 0, 255);
    assertEquals("Shape R rectangle\n"
            + "motion R 1 200.0 200.0 50.0 100.0 255 0 0 10 200.0 200.0 50.0 100.0 255 0 0\n"
            + "motion R 10 200.0 200.0 50.0 100.0 255 0 0 50 300.0 300.0 50.0 100.0 255 0 0\n"
            + "Shape O oval\n"
            + "motion O 6 440.0 70.0 120.0 60.0 0 255 0 20 440.0 70.0 120.0 60.0 0 255 0\n"
            + "motion O 20 440.0 70.0 120.0 60.0 0 255 0 50 440.0 250.0 120.0 60.0 0 255 0\n", animationOne.toString());
  }

}
