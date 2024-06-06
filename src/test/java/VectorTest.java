
import org.junit.*;
import static org.junit.Assert.*;

public class VectorTest {
    /**
     * Tests the default Constructor
     */
    @Test
    public void testDefaultConstructorInitialize() {
        // Arrange & Act
        Vector v = new Vector();
        Vector vgl = new Vector(0, 0);

        //Assert
        assertEquals(vgl.getX(), v.getX(), 1e-10);
        assertEquals(vgl.getY(), v.getY(),1e-10);
    }

    /**
     * Tests initialization with doubles
     * Also tests the get functions
     * One of them is wrong if test fails!
     */
    @Test
    public void testInitializeWithDoubles() {
        //Arrange & Act
        Vector v = new Vector(2.5, 6);

        //Assert
        assertEquals(2.5, v.getX(), 1e-10);
        assertEquals(6, v.getY(), 1e-10);
    }

    /**
     * Tests copy constructor
     */
    @Test
    public void testCopyConstructor() {
        //Arrange & Act
        Vector v = new Vector(2.5, 6);
        Vector vgl = new Vector(v);

        //Assert
        assertEquals(vgl.getX(), v.getX(), 1e-10);
        assertEquals(vgl.getY(), v.getY(),1e-10);

    }

    /**
     * Tests copy constructor but when copying nullvector
     */
    //Assert
    @Test (expected = IllegalArgumentException.class)
    public void testCopyConstructorNullException() {
        //Arrange & Act
        Vector v = null;
        Vector vgl = new Vector(v);
    }

    /**
     * Tests setting X
     */
    @Test
    public void testSetX() {
        //Arrange
        Vector v = new Vector(2.5, 6);

        //Act
        v.setX(5);

        //Assert
        assertEquals(5, v.getX(), 1e-10);

    }

    /**
     * Tests setting Y
     */
    @Test
    public void testSetY() {
        //Arrange
        Vector v = new Vector(2.5, 6);

        //Act
        v.setY(10);

        //Assert
        assertEquals(10, v.getY(), 1e-10);

    }

    /**
     * Tests getMagnitude function
     */
    @Test
    public void testGetMagnitude(){
        //Arrange
        Vector v = new Vector(4, 4);

        //Act & Assert
        assertEquals(5.656854249492381, v.getMagnitude(), 1e-10);
    }

    /*
    @Test
    public void testGetMagnitudeException() {
        //Arrange
        Vector v = new Vector();

        try {
            //Act
            v.getMagnitude();
            fail(); //if the test lets us get the magnitude, it didnt manage to catch the exception
        } catch (IllegalArgumentException e) {
            //Assert
            assertEquals(0, v.getMagnitude(),1e-10); //pretty unnecessary but you gotta assert
        }
    }
    */

    /**
     *  Tests asNormalized function
     * Magnitude here is 16
     * final result should be a Vector with 0.25 as x and y
     */
    @Test
    public void testAsNormalized(){
        //Arrange
        Vector v = new Vector(4,4); // 4^2+4^2 = 32 dann wurzel ziehen = 16 (magnitude)
        Vector res = new Vector(0.7071067811865475,0.7071067811865475); // koordinaten(x,y)/Magnitude () = ( 0.25 , 0.25 )

        //Act & Assert
        assertEquals(res.getX(), v.asNormalized().getX(), 1e-10);
        assertEquals(res.getY(), v.asNormalized().getY(),1e-10);
    }

    /**
     * Tests the exception in the asNormalized method
     * Exception when Magnitude is 0
     */
    //Assert
    @Test(expected = IllegalStateException.class) // expected exception occuring ends the test
    public void testAsNormalizedException(){
        //Arrange
        Vector v = new Vector(); // causes 0 magnitude

        //Act
        v.asNormalized(); // expected exception
    }

    /**
     * Tests Add method with positive numbers
     */
    @Test
    public void testAddWithPlus(){
        //Arrange
        Vector v = new Vector(2.5,6);
        Vector added = new Vector (1,2);
        Vector sum = new Vector (3.5,8); // sum of the two vectors "v" and "added"

        //Act
        v.add(added); //adds "added" vector to vector v

        //Assert
        assertEquals(sum.getX(),v.getX(),1e-10);
        assertEquals(sum.getY(),v.getY(),1e-10);

    }

    /**
     * Tests add function with negative vectos
     */
    @Test
    public void testAddWithMinus(){
        //Arrange
        Vector v = new Vector(2.5,6);
        Vector added = new Vector (-3,2);
        Vector sum = new Vector (-0.5,8); // sum of the two vectors "v" and "added"

        //Act
        v.add(added); //adds "added" vector to vector v

        //Assert
        assertEquals(sum.getX(),v.getX(),1e-10);
        assertEquals(sum.getY(),v.getY(),1e-10);
    }

    /**
     * Tests Exception in fromPolar
     * exception is caused by negative magnitude
     */
    //Assert
    @Test (expected = IllegalArgumentException.class)
    public void testFromPolarExceptionMagnitudeNegative(){
        //Arrange
        Vector v = new Vector();

        //Act
        v.fromPolar(2, -1); //expected exception
    }

    /* Wenn Angle nicht 0 sein darf:
    //Assert
    @Test (expected = IllegalArgumentException.class)
    public void testFromPolarExceptionAngleZero(){
        //Arrange
        Vector v = new Vector();

        //Act
        v.fromPolar(0, 2); //expected exception
    }
     */

    /**
     * Tests Exception in fromPolar
     * exception is caused by negative angle
     */
    //Assert
    @Test (expected = IllegalArgumentException.class)
    public void testFromPolarExceptionAngleNegative(){
        //Arrange
        Vector v = new Vector();

        //Act
        v.fromPolar(-2, 1); //expected exception
    }

    /**
     * Tests Exception in fromPolar
     * exception is caused if angle value is bigger than 2*PI
     */
    //Assert
    @Test (expected = IllegalArgumentException.class)
    public void testFromPolarExceptionAngleTooBig(){
        //Arrange
        Vector v = new Vector();

        //Act
        v.fromPolar(8, 1); //expected exception
    }

    /**
     * Testing the Edge-Cases of the function
     * using 0 for the magnitude
     */
    @Test
    public void testFromPolarZeroMagnitude() {
        //Arrange
        Vector v = new Vector();

        //Assert & Act
        assertEquals(v.getX(), v.fromPolar(4,0).getX(),1e-10); //since everything is multiplied with  magnitude it makes everything 0
        assertEquals(v.getY(), v.fromPolar(4,0).getY(),1e-10);
    }

    /**
     * Tests the Edge-Cases of the function
     * using 0 for the angle
     */
    @Test
    public void testFromPolarZeroAngle() {
        //Arrange
        Vector v = new Vector(1,0); //cos(0) = 1, sin (0) = 0

        //Assert & Act
        assertEquals(v.getX(), v.fromPolar(0,1).getX(),1e-10);
        assertEquals(v.getY(), v.fromPolar(0,1).getY(),1e-10);
    }

}
