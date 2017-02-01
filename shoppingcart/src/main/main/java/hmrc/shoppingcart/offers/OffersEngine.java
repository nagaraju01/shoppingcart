/*
 * Copyright © Test Ltd. All Rights Reserved.
 */
package hmrc.shoppingcart.offers;

import hmrc.shoppingcart.model.FruitType;
import static hmrc.shoppingcart.model.FruitType.APPLE;
import static hmrc.shoppingcart.model.FruitType.ORANGE;
import hmrc.shoppingcart.model.OfferType;
import static hmrc.shoppingcart.model.OfferType.BUYONE_GETONE;
import static hmrc.shoppingcart.model.OfferType.THREE_FOR_PRICE_OF_TWO;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Nagaraju
 */
public class OffersEngine {

    // valid offers
    private static final Map<FruitType, ArrayList<OfferType>> map = new EnumMap<>(FruitType.class);

    static {
        // apple offer
        ArrayList<OfferType> appleOfferList = new ArrayList<>();
        appleOfferList.add(BUYONE_GETONE);
        map.put(APPLE, appleOfferList);

        // apple offer
        ArrayList<OfferType> orangeOfferList = new ArrayList<>();
        orangeOfferList.add(THREE_FOR_PRICE_OF_TWO);
        map.put(ORANGE, orangeOfferList);
    }

    /**
     * applyOffer to get the quantity to charge
     *
     * @param type
     * @param qty
     * @return reduced quantity to price
     */
    public static Integer applyOffers(FruitType type, Integer qty) {

        // TODO: in case multiple offer have to applied at the same time
        OfferType offer = map.get(type).get(0);

        if (BUYONE_GETONE.ordinal() == offer.ordinal()) {

            return qty == 0 ? qty : (qty / 2) + (qty % 2);

        } else if (THREE_FOR_PRICE_OF_TWO.ordinal() == offer
                .ordinal()) {
            return qty <= 2 ? qty : qty - (qty / 3);
        }

        return qty;
    }
    private static final Logger LOG = Logger.getLogger(OffersEngine.class.getName());

}
