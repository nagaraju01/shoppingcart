/*
 * Copyright © Test Ltd. All Rights Reserved.
 */
package hmrc.shoppingcart.model;

/**
 * OfferType enum class
 *
 * @author Naga
 *
 */
public enum OfferType {

    /**
     *
     */
    BUYONE_GETONE(1, "buy 1 get 1"), 

    /**
     *
     */
    THREE_FOR_PRICE_OF_TWO(2, "3 for the price of 2");

    private final Integer id;
    private final String name;

    OfferType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

}
