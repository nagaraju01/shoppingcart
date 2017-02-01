/*
 * Copyright © Test Ltd. All Rights Reserved.
 */
package hmrc.shoppingcart;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hmrc.shoppingcart.model.Fruit;
import hmrc.shoppingcart.model.FruitType;
import hmrc.shoppingcart.service.ShoppingCartService;
import hmrc.shoppingcart.service.ShoppingCartServiceImpl;

/**
 * ShoppingCartTest class
 *
 * @author Naga
 *
 */
public class ShoppingCartTest {

    ShoppingCartService shoppingCartService;
    List<Fruit> fruits;

    @Before
    public void setUp() throws Exception {
        shoppingCartService = new ShoppingCartServiceImpl();
        fruits = new ArrayList<>();
    }

    // part 1
    @Test
    public void shoppingCartTest_OneApple() {
        fruits.add(new Fruit(FruitType.APPLE, 1));
        ShoppingCart shoppingCart = shoppingCartService
                .addToShoppingCart(fruits);
        assertTrue(shoppingCart.getTotal() == 0.60d);
    }

    @Test
    public void shoppingCartTest_OneOrange() {
        fruits.add(new Fruit(FruitType.ORANGE, 1));
        ShoppingCart shoppingCart = shoppingCartService
                .addToShoppingCart(fruits);
        assertTrue(shoppingCart.getTotal() == 0.25d);
    }

    @Test
    public void shoppingCartTest_OneAppleAndTwoOrange() {
        fruits.add(new Fruit(FruitType.APPLE, 1));
        fruits.add(new Fruit(FruitType.ORANGE, 2));
        ShoppingCart shoppingCart = shoppingCartService
                .addToShoppingCart(fruits);
        assertTrue(shoppingCart.getTotal() == 1.10d);
    }

    // part -2
    @Test
    public void shoppingCartTest_TwoAppleAndThreeOrange_applyOffers() {
        fruits.add(new Fruit(FruitType.APPLE, 2));
        fruits.add(new Fruit(FruitType.ORANGE, 3));
        ShoppingCart shoppingCart = shoppingCartService
                .addToShoppingCart(fruits);
        assertTrue(shoppingCart.getTotal() == 1.10d);
    }
    
    @Test
    public void shoppingCartTest_ThreeAppleAndOneOrange_applyOffers() {
        fruits.add(new Fruit(FruitType.APPLE, 3));
        fruits.add(new Fruit(FruitType.ORANGE, 1));
        ShoppingCart shoppingCart = shoppingCartService
                .addToShoppingCart(fruits);
        assertTrue(shoppingCart.getTotal() == 1.45d);
    }

    @Test
    public void shoppingCartTest_FourAppleAndSixOrange_applyOffers() {
        fruits.add(new Fruit(FruitType.APPLE, 2));
        fruits.add(new Fruit(FruitType.APPLE, 2));
        fruits.add(new Fruit(FruitType.ORANGE, 3));
        fruits.add(new Fruit(FruitType.APPLE, 2));
        fruits.add(new Fruit(FruitType.ORANGE, 3));
        ShoppingCart shoppingCart = shoppingCartService
                .addToShoppingCart(fruits);
        assertTrue(shoppingCart.getTotal() == 2.80d);
    }

    @Test
    public void shoppingCartTest_TwoAppleAndFourOrange_applyOffers() {
        fruits.add(new Fruit(FruitType.APPLE, 1));
        fruits.add(new Fruit(FruitType.ORANGE, 1));
        fruits.add(new Fruit(FruitType.APPLE, 1));
        fruits.add(new Fruit(FruitType.ORANGE, 2));
        fruits.add(new Fruit(FruitType.APPLE, 5));
        fruits.add(new Fruit(FruitType.ORANGE, 1));
        ShoppingCart shoppingCart = shoppingCartService
                .addToShoppingCart(fruits);
        assertTrue(shoppingCart.getTotal() == 3.15d);
    }

}
