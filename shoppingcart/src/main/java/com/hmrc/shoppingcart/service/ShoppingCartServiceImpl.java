package hmrc.shoppingcart.service;

import hmrc.shoppingcart.ShoppingCart;
import hmrc.shoppingcart.model.Fruit;
import hmrc.shoppingcart.model.FruitType;
import hmrc.shoppingcart.offers.OffersEngine;
import static hmrc.shoppingcart.offers.OffersEngine.applyOffers;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * ShoppingCartServiceImpl class
 *
 * @author Naga
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCart shoppingCart = new ShoppingCart();

    /**
     *
     * @param fruits
     * @return
     */
    @Override
    public ShoppingCart addToShoppingCart(List<Fruit> fruits) {

        Double total = 0.0d;

        Map<FruitType, Integer> fruitTypeQtyMap = new EnumMap<>(FruitType.class);

        fruits.stream().forEach((fruit) -> {
            if (fruitTypeQtyMap.containsKey(fruit.getName())) {
                fruitTypeQtyMap.merge(fruit.getName(), fruit.getQuantity(), Integer::sum);
            } else {
                fruitTypeQtyMap.put(fruit.getName(), fruit.getQuantity());
            }
        });

        //apply offers and sum up price
        total = fruitTypeQtyMap.entrySet().stream().map((Map.Entry<FruitType, Integer> entry) -> {
            FruitType key = entry.getKey();
            Integer value = entry.getValue();
            return applyOffers(key, value) * key.getPrice();           
        }).reduce(total, (accumulator,  _item) -> {
            return _item + accumulator;
        });

        shoppingCart.setFruitItems(fruitTypeQtyMap);
        shoppingCart.setTotal(total);

        return shoppingCart;
    }
    private static final Logger LOG = Logger.getLogger(ShoppingCartServiceImpl.class.getName());
}
/*
 * Copyright © Test Ltd. All Rights Reserved.
 */
