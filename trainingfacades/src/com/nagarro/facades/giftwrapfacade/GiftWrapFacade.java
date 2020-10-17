/**
 *
 */
package com.nagarro.facades.giftwrapfacade;

import java.util.List;

import com.nagarro.core.enums.GiftWrappingOptionEnum;
import com.nagarro.facades.product.data.GiftWrapData;




/**
 * @author swetachaurasia
 *
 */
public interface GiftWrapFacade


{

	List<GiftWrapData> getGiftWraps();

	void setGiftWrapCost(GiftWrappingOptionEnum wrapType, String entryNumber);

	void removeGiftWrapCost(String entryNumber);

}
