package entity;

import org.example.entity.Calculatrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// méthode de test sont void et n'acceptent aucun argument
public class CalculatriceTest {
    @Test
    void testAddition() {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Act
        double result = calculatrice.addition(10,40);

        //Assert
        Assertions.assertEquals(50, result);

    }

    @Test
    void testDivison1() {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Act
        double result = calculatrice.division(10,2);

        //Assert
        Assertions.assertEquals(5, result);

    }

    @Test
    void testDivison2() {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Act and Assert
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            calculatrice.division(10,0);
        });


    }

}
