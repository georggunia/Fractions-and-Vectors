
import org.junit.*;
import static org.junit.Assert.*;

public class FractionTest {
    /**
     * Tests the Default Constructor
     * denom cant be 0, so exception should be thrown
     */
    //Assert
    @Test (expected = IllegalStateException.class)
    public void testDefaultConstructorException() {
        //Arrange & Act
        Fraction f = new Fraction(1, 0); //expected exception cuz denom cant be 0
    }

    /**
     * Tests the Default Constructor
     */
    @Test
    public void testDefaultConstructor() {
        Fraction f = new Fraction(2,1);

        assertEquals(2,f.getNom());
        assertEquals(1,f.getDenom());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCopyConstructorException() {
        Fraction f = new Fraction(null); //expected exception
    }

    @Test
    public void testCopyConstructor() {
        //Arrange & Act
        Fraction f = new Fraction(2, 1);
        Fraction v = new Fraction(f);
        //Assert
        assertEquals(f.getNom(),v.getNom());
        assertEquals(f.getDenom(),v.getDenom());
    }

    @Test
    public void testSetNom() {
        //Arrange
        Fraction f = new Fraction(2, 1);

        //Act
        f.setNom(5);

        //Assert
        assertEquals(5, f.getNom());

    }

    /**
     * Tests setting denom
     */
    @Test
    public void testSetDenom() {
        //Arrange
        Fraction f = new Fraction(2,1);

        //Act
        f.setDenom(10);

        //Assert
        assertEquals(10, f.getDenom());

    }

    @Test
    public void testSetDenomZero(){
        //Arrange & Act
        Fraction f = new Fraction(2,1);

        //Assert
        try {
            f.setDenom(0);
            fail();
        }catch (IllegalStateException e){
            assertEquals(2, f.getNom());
            assertEquals(1, f.getDenom());
        }
    }

    @Test
    public void testNormalizeSignNegDenom(){
        //Arrange
        Fraction f = new Fraction(2,-1);

        //Act
        f.normalizeSign();

        //Assert
        assertEquals(-2, f.getNom());
        assertEquals(1, f.getDenom());
    }

    @Test
    public void testNormalizeSignBothNeg(){
        //Arrange
        Fraction f = new Fraction(-2,-1);

        //Act
        f.normalizeSign();

        //Assert
        assertEquals(2, f.getNom());
        assertEquals(1, f.getDenom());
    }

    @Test
    public void testNormalizeSignDenom1neg(){
        //Arrange
        Fraction f = new Fraction(0,-5);

        //Act
        f.normalizeSign();

        //Assert
        assertEquals(0, f.getNom());
        assertEquals(1, f.getDenom());
    }

    @Test
    public void testNormalizeSignDenom1pos(){
        //Arrange
        Fraction f = new Fraction(0,5);

        //Act
        f.normalizeSign();

        //Assert
        assertEquals(0, f.getNom());
        assertEquals(1, f.getDenom());
    }

    @Test
    public void testAsReducedPos() {
        //Arrange & Act
        Fraction f = new Fraction(4,6);
        Fraction v = new Fraction(f.asReduced());

        //Assert
        assertEquals(2, v.getNom());
        assertEquals(3, v.getDenom());
    }

    @Test
    public void testAsReducedNeg() {
        //Arrange & Act
        Fraction f = new Fraction(4,-6);
        Fraction v = f.asReduced();

        //Assert
        assertEquals(2, v.getNom());
        assertEquals(-3, v.getDenom());
    }

    @Test
    public void testValuePos() {
        //Arrange
        Fraction f = new Fraction (1,2);

        //Act & Assert
        assertEquals(0.5, f.value(), 1e-10);
    }

    @Test
    public void testValueNeg() {
        //Arrange
        Fraction f = new Fraction (1,-2);

        //Act & Assert
        assertEquals(-0.5, f.value(), 1e-10);
    }

    @Test
    public void testEqualsTrue() {
        //Arrange
        Fraction f = new Fraction(1,4);
        Fraction v = new Fraction(1,4);

        //Act & Assert
        assertTrue(f.equals(v));
    }
    @Test
    public void testEqualsFalseNeg() {
        //Arrange
        Fraction f = new Fraction(1,4);
        Fraction v = new Fraction(1,-4);

        //Act & Assert
        assertFalse(f.equals(v));
    }

    @Test
    public void testEqualsFalse() {
        //Arrange
        Fraction f = new Fraction(1,4);
        Fraction v = new Fraction(1,5);

        //Act & Assert
        assertFalse(f.equals(v));
    }

    @Test
    public void testEqualsNull(){
        //Arrange
        Fraction f = new Fraction(1,4);
        Fraction v = null;

        //Act & Assert
        assertFalse(f.equals(v));
    }


    @Test
    public void testValueEqualsTrue() {
        //Arrange
        Fraction f = new Fraction(1,4);
        Fraction v = new Fraction(2,8);

        //Act & Assert
        assertTrue(f.valueEquals(v));
    }

    @Test
    public void testValueEqualsFalseNeg() {
        //Arrange
        Fraction f = new Fraction(1,4);
        Fraction v = new Fraction(2,-8);

        //Act & Assert
        assertFalse(f.valueEquals(v));
    }

    @Test
    public void testValueEqualsTrueNegPos() {
        //Arrange
        Fraction f = new Fraction(1,4);
        Fraction v = new Fraction(-2,-8);

        //Act & Assert
        assertTrue(f.valueEquals(v));
    }

    @Test
    public void testValueEqualsFalse() {
        //Arrange
        Fraction f = new Fraction(1,4);
        Fraction v = new Fraction(1,5);

        //Act & Assert
        assertFalse(f.valueEquals(v));
    }

    @Test
    public void testValueEqualsNull(){
        //Arrange
        Fraction f = new Fraction(1,4);
        Fraction v = null;

        //Act & Assert
        assertFalse(f.equals(v));
    }
}
