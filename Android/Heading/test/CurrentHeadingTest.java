package HeadingTest;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Heading.CurrentHeading;

class CurrentHeadingTest {
    
    Float answerHeading;
    String answerDirection;
    List<String> returnValue = new ArrayList<String>();

    /**
     * Testing Strategy
     * ================
     * Tested with a required heading in all four quadrants. The required heading must not be
     * 45, 135, 225 or 315 degrees, as they may lead to ambiguity.
     * 
     * For required direction in a quadrant, tested with current heading in all four quadrants.
     *
     * Tested the special cases of required heading of 0, 90, 180 or 270 degrees.
     */

    // Tests currentHeading = 0 degree
    //       requiredHeading = 60 degree
    @Test
    void firstQuadrant0() {
        returnValue.clear();
        answerHeading = 60f;
        answerDirection = "Right";
        
        returnValue = CurrentHeading.getHeading(0.0010f, 0.00058f, 0f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 90 degree
    //       requiredHeading = 60 degree
    @Test
    void firstQuadrant90() {
        returnValue.clear();
        answerHeading = 30f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(0.0010f, 0.00058f, 90f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 180 degree
    //       requiredHeading = 60 degree
    @Test
    void firstQuadrant180() {
        returnValue.clear();
        answerHeading = 120f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(0.0010f, 0.00058f, 180f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 270 degree
    //       requiredHeading = 60 degree
    @Test
    void firstQuadrant270() {
        returnValue.clear();
        answerHeading = 150f;
        answerDirection = "Right";
        
        returnValue = CurrentHeading.getHeading(0.0010f, 0.00058f, 270f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 0 degree
    //       requiredHeading = 150 degree
    @Test
    void secondQuadrant0() {
        returnValue.clear();
        answerHeading = 150f;
        answerDirection = "Right";
        
        returnValue = CurrentHeading.getHeading(0.0010f, -0.00058f, 0f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 90 degree
    //       requiredHeading = 150 degree
    @Test
    void secondQuadrant90() {
        returnValue.clear();
        answerHeading = 60f;
        answerDirection = "Right";
        
        returnValue = CurrentHeading.getHeading(0.0010f, -0.00058f, 90f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 180 degree
    //       requiredHeading = 150 degree
    @Test
    void secondQuadrant180() {
        returnValue.clear();
        answerHeading = 30f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(0.0010f, -0.00058f, 180f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 270 degree
    //       requiredHeading = 150 degree
    @Test
    void secondQuadrant270() {
        returnValue.clear();
        answerHeading = 120f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(0.0010f, -0.00058f, 270f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 0 degree
    //       requiredHeading = 240 degree
    @Test
    void thirdQuadrant0() {
        returnValue.clear();
        answerHeading = 120f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(-0.0010f, -0.00058f, 0f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 90 degree
    //       requiredHeading = 240 degree
    @Test
    void thirdQuadrant90() {
        returnValue.clear();
        answerHeading = 150f;
        answerDirection = "Right";
        
        returnValue = CurrentHeading.getHeading(-0.0010f, -0.00058f, 90f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 180 degree
    //       requiredHeading = 240 degree
    @Test
    void thirdQuadrant180() {
        returnValue.clear();
        answerHeading = 60f;
        answerDirection = "Right";
        
        returnValue = CurrentHeading.getHeading(-0.0010f, -0.00058f, 180f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 270 degree
    //       requiredHeading = 240 degree
    @Test
    void thirdQuadrant270() {
        returnValue.clear();
        answerHeading = 30f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(-0.0010f, -0.00058f, 270f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 0 degree
    //       requiredHeading = 330 degree
    @Test
    void fourthQuadrant0() {
        returnValue.clear();
        answerHeading = 30f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(-0.0010f, 0.00058f, 0f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 90 degree
    //       requiredHeading = 330 degree
    @Test
    void fourthQuadrant90() {
        returnValue.clear();
        answerHeading = 120f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(-0.0010f, 0.00058f, 90f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Tests currentHeading = 180 degree
    //       requiredHeading = 330 degree
    @Test
    void fourthQuadrant180() {
        returnValue.clear();
        answerHeading = 150f;
        answerDirection = "Right";
        
        returnValue = CurrentHeading.getHeading(-0.0010f, 0.00058f, 180f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }

    // Tests currentHeading = 270 degree
    //       requiredHeading = 330 degree
    @Test
    void fourthQuadrant270() {
        returnValue.clear();
        answerHeading = 60f;
        answerDirection = "Right";
        
        returnValue = CurrentHeading.getHeading(-0.0010f, 0.00058f, 270f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Test currentHeading = 310 degree
    //      requiredHeading = 0 degree
    @Test
    void perfect0() {
        returnValue.clear();
        answerHeading = 50f;
        answerDirection = "Right";
        
        returnValue = CurrentHeading.getHeading(0.000005f, 0.0010f, 310f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Test currentHeading = 270 degree
    //      requiredHeading = 90 degree
    @Test
    void perfect90() {
        returnValue.clear();
        answerHeading = 180f;
        
        returnValue = CurrentHeading.getHeading(0.0010f, 0.000005f, 270f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertTrue(returnValue.get(1).equals("Left") || returnValue.get(1).equals("Right"));
    }
    
    // Test currentHeading = 246 degree
    //      requiredHeading = 180 degree
    @Test
    void perfect180() {
        returnValue.clear();
        answerHeading = 66f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(0.000005f, -0.0010f, 246f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }
    
    // Test currentHeading = 45 degree
    //      requiredHeading = 270 degree
    @Test
    void perfect270() {
        returnValue.clear();
        answerHeading = 135f;
        answerDirection = "Left";
        
        returnValue = CurrentHeading.getHeading(-0.0010f, 0.000005f, 45f);
        
        assertEquals(answerHeading, new Float(returnValue.get(0)), 0.2);
        assertEquals(answerDirection, returnValue.get(1));
    }

}
