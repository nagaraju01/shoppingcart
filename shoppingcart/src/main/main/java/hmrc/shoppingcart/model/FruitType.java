/*
 * Copyright © Test Ltd. All Rights Reserved.
 */
package hmrc.shoppingcart.model;

/**
 * FruitType enum class
 * 
 * @author Naga
 *
 */
public enum FruitType {

    /**
     *
     */
    APPLE(1, "apple", 0.60d), 

    /**
     *
     */
    ORANGE(2, "orange", 0.25d);

	private final Integer id;
	private final String name;
	private final Double price;

	FruitType(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
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

    /**
     *
     * @return
     */
    public Double getPrice() {
		return price;
	}

}
