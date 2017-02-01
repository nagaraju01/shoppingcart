/*
 * Copyright © Test Ltd. All Rights Reserved.
 */
package hmrc.shoppingcart;

import hmrc.shoppingcart.model.FruitType;
import java.util.Collections;
import static java.util.Collections.unmodifiableMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * ShoppingCart Class - holds itemised fruit info plus total
 *
 * @author Nagaraju
 *
 */
public class ShoppingCart {

    private Map<FruitType, Integer> fruitItems;

    private Double total;

    /**
     *
     * @return
     */
    public Map<FruitType, Integer> getFruitItems() {
        return unmodifiableMap(fruitItems);
    }

    /**
     *
     * @param fruitItems
     */
    public void setFruitItems(Map<FruitType, Integer> fruitItems) {
        this.fruitItems = fruitItems;
    }

    /**
     *
     * @return
     */
    public Double getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(Double total) {
        this.total = total;
    }
    private static final Logger LOG = Logger.getLogger(ShoppingCart.class.getName());

}
