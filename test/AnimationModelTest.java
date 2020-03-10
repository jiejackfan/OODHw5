import cs3500.excellence.hw5.AnimationOperation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnimationModelTest {

  AnimationOperation animationOne = new AnimationModel();

  @Test
  public void testCheckValidAnimationNoMotions() {
    // Create shapes
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");
    assertTrue(animationOne.checkValidAnimation());
  }

  @Test
  public void testCheckInValidAnimationTeleport() {

    // Create shapes
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");
    // R is valid
    animationOne.addMotion("R", 1, 200, 200, 50,
            100, 255, 0, 0, 15,
            200, 200, 50, 100, 255, 0, 0);
    animationOne.addMotion("R", 10, 200, 200, 50,
            100, 255, 0, 0, 50,
            300, 300, 50, 100, 255, 0, 0);
    // O is invalid - teleport
    animationOne.addMotion("O", 6, 440, 70, 120,
            60, 0, 0, 255, 8,
            440, 70, 120, 60, 0, 0, 255);
    animationOne.addMotion("O", 18, 440, 70, 120,
            60, 0, 0, 255, 50,
            440, 250, 120, 60, 0, 0, 255);
    assertFalse(animationOne.checkValidAnimation());
  }

  @Test
  public void testCheckInValidAnimationOverlap() {
    // Create shapes
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");
    // R is invalid - overlapping
    animationOne.addMotion("R", 1, 200, 200, 50,
            100, 255, 0, 0, 15,
            200, 200, 50, 100, 255, 0, 0);
    animationOne.addMotion("R", 10, 200, 200, 50,
            100, 255, 0, 0, 50,
            300, 300, 50, 100, 255, 0, 0);
    // O is valid
    animationOne.addMotion("O", 6, 440, 70, 120,
            60, 0, 0, 255, 20,
            440, 70, 120, 60, 0, 0, 255);
    animationOne.addMotion("O", 20, 440, 70, 120,
            60, 0, 0, 255, 50,
            440, 250, 120, 60, 0, 0, 255);
    assertFalse(animationOne.checkValidAnimation());
  }

  @Test
  public void testCheckValidAnimation() {
    // Create shapes
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");
    // O is valid
    animationOne.addMotion("O", 6, 440, 70, 120,
            60, 0, 0, 255, 20,
            440, 70, 120, 60, 0, 0, 255);
    animationOne.addMotion("O", 20, 440, 70, 120,
            60, 0, 0, 255, 50,
            440, 250, 120, 60, 0, 0, 255);
    assertTrue(animationOne.checkValidAnimation());
  }

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

  @Test(expected = IllegalStateException.class)
  public void testInvalidAnimationToString() {
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");

    animationOne.addMotion("R", 1, 200, 200, 50,
            100, 255, 0, 0, 10,
            200, 200, 50, 100, 255, 0, 0);
    animationOne.addMotion("R", 10, 200, 200, 50,
            100, 255, 0, 0, 50,
            300, 300, 50, 100, 255, 0, 0);
    // O is invalid - teleport
    animationOne.addMotion("O", 6, 440, 70, 120,
            60, 0, 0, 255, 8,
            440, 70, 120, 60, 0, 0, 255);
    animationOne.addMotion("O", 18, 440, 70, 120,
            60, 0, 0, 255, 50,
            440, 250, 120, 60, 0, 0, 255);
    assertEquals("Shape R rectangle\n"
            + "motion R 1 200.0 200.0 50.0 100.0 255 0 0 10 200.0 200.0 50.0 100.0 255 0 0\n"
            + "motion R 10 200.0 200.0 50.0 100.0 255 0 0 50 300.0 300.0 50.0 100.0 255 0 0\n"
            + "Shape O oval\n"
            + "motion O 6 440.0 70.0 120.0 60.0 0 255 0 20 440.0 70.0 120.0 60.0 0 255 0\n"
            + "motion O 20 440.0 70.0 120.0 60.0 0 255 0 50 440.0 250.0 120.0 60.0 0 255 0\n", animationOne.toString());
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
