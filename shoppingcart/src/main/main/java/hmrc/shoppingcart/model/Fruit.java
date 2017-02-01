/*
 * Copyright © Test Ltd. All Rights Reserved.
 */
package hmrc.shoppingcart.model;

import java.util.logging.Logger;

/**
 * Fruit class
 *
 * @author Naga
 *
 */
public class Fruit {

    private FruitType name;

    private Integer quantity;

    /**
     *
     * @param name
     * @param quantity
     */
    public Fruit(FruitType name, Integer quantity) {
        super();
        this.name = name;
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public FruitType getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(FruitType name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    private static final Logger LOG = Logger.getLogger(Fruit.class.getName());

}
