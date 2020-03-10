import org.junit.Test;

import cs3500.excellence.hw5.AnimationModel;
import cs3500.excellence.hw5.AnimationOperation;

import static org.junit.Assert.assertEquals;

public class AnimationModelTest {

  AnimationOperation animationOne = new AnimationModel();

//  @Test
//  public void testCheckValidAnimationNoMotions() {
//    // Create shapes
//    animationOne.createShape("rectangle", "R");
//    animationOne.createShape("oval", "O");
//    assertTrue(animationOne.checkValidAnimation());
//  }

//  @Test
//  public void testCheckInValidAnimationTeleport() {
//
//    // Create shapes
//    animationOne.createShape("rectangle", "R");
//    animationOne.createShape("oval", "O");
//    // R is valid
//    animationOne.addMotion("R", 1, 200, 200, 50,
//            100, 255, 0, 0, 15,
//            200, 200, 50, 100, 255, 0, 0);
//    animationOne.addMotion("R", 10, 200, 200, 50,
//            100, 255, 0, 0, 50,
//            300, 300, 50, 100, 255, 0, 0);
//    // O is invalid - teleport
//    animationOne.addMotion("O", 6, 440, 70, 120,
//            60, 0, 0, 255, 8,
//            440, 70, 120, 60, 0, 0, 255);
//    animationOne.addMotion("O", 18, 440, 70, 120,
//            60, 0, 0, 255, 50,
//            440, 250, 120, 60, 0, 0, 255);
//    assertFalse(animationOne.checkValidAnimation());
//  }
//
//  @Test
//  public void testCheckInValidAnimationOverlap() {
//    // Create shapes
//    animationOne.createShape("rectangle", "R");
//    animationOne.createShape("oval", "O");
//    // R is invalid - overlapping
//    animationOne.addMotion("R", 1, 200, 200, 50,
//            100, 255, 0, 0, 15,
//            200, 200, 50, 100, 255, 0, 0);
//    animationOne.addMotion("R", 10, 200, 200, 50,
//            100, 255, 0, 0, 50,
//            300, 300, 50, 100, 255, 0, 0);
//    // O is valid
//    animationOne.addMotion("O", 6, 440, 70, 120,
//            60, 0, 0, 255, 20,
//            440, 70, 120, 60, 0, 0, 255);
//    animationOne.addMotion("O", 20, 440, 70, 120,
//            60, 0, 0, 255, 50,
//            440, 250, 120, 60, 0, 0, 255);
//    assertFalse(animationOne.checkValidAnimation());
//  }
//
//  @Test
//  public void testCheckValidAnimation() {
//    // Create shapes
//    animationOne.createShape("rectangle", "R");
//    animationOne.createShape("oval", "O");
//    // O is valid
//    animationOne.addMotion("O", 6, 440, 70, 120,
//            60, 0, 0, 255, 20,
//            440, 70, 120, 60, 0, 0, 255);
//    animationOne.addMotion("O", 20, 440, 70, 120,
//            60, 0, 0, 255, 50,
//            440, 250, 120, 60, 0, 0, 255);
//    assertTrue(animationOne.checkValidAnimation());
//  }

  /**
   * createShape(shape, name) Invalid: shape = null/"", name = null/"" valid: create one given
   * shape, and create more than one shapes
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateShapeNull() {
    animationOne.createShape(null, "R");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateShapeEmptyString() {
    animationOne.createShape("", "R");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateShapeNameNull() {
    animationOne.createShape("rectangle", null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateShapeNameEmptyString() {
    animationOne.createShape("rectangle", "");
  }

  @Test
  public void testShapesNoMotionToString() {
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");
    assertEquals("Shape R rectangle\nShape O oval\n", animationOne.toString());
  }

  /**
   * removeShape(name) invalid: name does not exist in the animation valid: name exist in the
   * animation
   */

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRemoveEmpty() {
    animationOne.removeShape("C");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRemove() {
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");
    animationOne.removeShape("C");
  }

  @Test
  public void testValidRemove() {
    animationOne.createShape("rectangle", "R");
    animationOne.createShape("oval", "O");
    animationOne.removeShape("R");
    animationOne.removeShape("O");
    assertEquals("", animationOne.toString());
  }

  /**
   * AddMotion(...)
   */

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidName() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("C", 1, 200, 200, 50,
            100, 255, 0, 0, 10,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartTime() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", -1, 200, 200, 50,
            100, 255, 0, 0, 10,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndTime() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 50,
            100, 255, 0, 0, -1,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionStartTimeGreaterThanEndTime() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 100, 200, 200, 50,
            100, 255, 0, 0, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartX() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, -1, 200, 50,
            100, 255, 0, 0, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartY() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 0, -100, 50,
            100, 255, 0, 0, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndX() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 50,
            100, 255, 0, 0, 20,
            -200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndY() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 50,
            100, 255, 0, 0, 20,
            200, -200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartWidth() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 0.0,
            100, 255, 0, 0, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndWidth() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100, 255, 0, 0, 20,
            200, 200, -50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartHeight() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            -100.75, 255, 0, 0, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndHeight() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 255, 0, 0, 20,
            200, 200, 50, 0, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartColorRed1() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 700, 0, 0, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartColorRed2() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, -700, 0, 0, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartColorGreen1() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 0, -255, 0, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartColorGreen2() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 0, 256, 0, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartColorBlue1() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 0, 0, -1, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidStartColorBlue2() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 0, 0, 800, 20,
            200, 200, 50, 100, 255, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndColorRed1() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 255, 0, 0, 20,
            200, 200, 50, 100, -1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndColorRed2() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 255, 0, 0, 20,
            200, 200, 50, 100, 700, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndColorGreen1() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 0, 255, 0, 20,
            200, 200, 50, 100, 255, -2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndColorGreen2() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 0, 255, 0, 20,
            200, 200, 50, 100, 255, 800, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndColorBlue1() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 0, 0, 0, 20,
            200, 200, 50, 100, 255, 0, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMotionInvalidEndColorBlue2() {
    animationOne.createShape("rectangle", "R");
    animationOne.addMotion("R", 1, 200, 200, 200,
            100.75, 0, 0, 0, 20,
            200, 200, 50, 100, 255, 0, 900);
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
            + "motion O 6 440.0 70.0 120.0 60.0 0 0 255 20 440.0 70.0 120.0 60.0 0 0 255\n"
            + "motion O 20 440.0 70.0 120.0 60.0 0 0 255 50 440.0 250.0 120.0 60.0 0 0 255\n", animationOne.toString());
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
            + "motion O 6 440.0 70.0 120.0 60.0 0 0 255 20 440.0 70.0 120.0 60.0 0 0 255\n"
            + "motion O 20 440.0 70.0 120.0 60.0 0 0 255 50 440.0 250.0 120.0 60.0 0 0 255\n", animationOne.toString());
  }


}
