/*
 * Copyright © Test Ltd. All Rights Reserved.
 */
package hmrc.shoppingcart.service;

import hmrc.shoppingcart.ShoppingCart;
import hmrc.shoppingcart.model.Fruit;
import java.util.List;

/**
 * ShoppingCartService interface
 * 
 * @author Naga
 *
 */
public interface ShoppingCartService {

	public ShoppingCart addToShoppingCart(List<Fruit> fruits);

}
