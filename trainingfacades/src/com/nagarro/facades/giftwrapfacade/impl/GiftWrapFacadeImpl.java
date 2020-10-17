/**
 *
 */
package com.nagarro.facades.giftwrapfacade.impl;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CalculationService;
import de.hybris.platform.order.CartService;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.core.enums.GiftWrappingOptionEnum;
import com.nagarro.core.model.GiftWrapModel;
import com.nagarro.core.service.GiftWrapService;
import com.nagarro.facades.giftwrapfacade.GiftWrapFacade;
import com.nagarro.facades.product.data.GiftWrapData;


/**
 * @author swetachaurasia
 *
 */
public class GiftWrapFacadeImpl implements GiftWrapFacade
{


	@Autowired
	private GiftWrapService giftWrapService;

	@Autowired
	private CartService cartService;

	@Autowired
	private ModelService modelService;

	@Autowired
	private CalculationService calculationService;

	private static final Logger LOG = Logger.getLogger(GiftWrapFacadeImpl.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see com.nagarro.facades.giftwrapfacade.GiftWrapFacade#getGiftWraps()
	 */
	@Override
	public List<GiftWrapData> getGiftWraps()
	{
		final List<GiftWrapModel> giftWrapModels = giftWrapService.getAllGiftOptions();
		giftWrapModels.get(0).getWrappingType();
		final List<GiftWrapData> giftWrapFacadeData = new ArrayList<>();
		for (final GiftWrapModel gwm : giftWrapModels)
		{
			final GiftWrapData gwd = new GiftWrapData();
			gwd.setCost(gwm.getCost());
			gwd.setDescription(gwm.getDescription());
			gwd.setWrappingType(gwm.getWrappingType());
			giftWrapFacadeData.add(gwd);


		}
		return giftWrapFacadeData;


	}

	/**
	 * @return the giftWrapService
	 */
	public GiftWrapService getGiftWrapService()
	{
		return giftWrapService;
	}

	/**
	 * @param giftWrapService
	 *           the giftWrapService to set
	 */
	public void setGiftWrapService(final GiftWrapService giftWrapService)
	{
		this.giftWrapService = giftWrapService;
	}

	@Override
	public void setGiftWrapCost(final GiftWrappingOptionEnum wrapType, final String entryNumber)
	{
		final AbstractOrderEntryModel entryModel = getEntryForCart(entryNumber);
		if (entryModel != null)
		{
			entryModel.setGiftWrap(wrapType);
			entryModel.setIsGiftWrapSet(true);
			modelService.save(entryModel);

			calculateCostForEntry();
		}

	}

	@Override
	public void removeGiftWrapCost(final String entryNumber)
	{
		final AbstractOrderEntryModel entryModel = getEntryForCart(entryNumber);
		if (entryModel != null)
		{
			entryModel.setGiftWrap(null);
			entryModel.setIsGiftWrapSet(false);
			modelService.save(entryModel);

			calculateCostForEntry();
		}

	}

	private AbstractOrderEntryModel getEntryForCart(final String entryNumber)
	{
		final CartModel cartModel = cartService.getSessionCart();
		final int entryNo = Integer.parseInt(entryNumber);
		AbstractOrderEntryModel entryModel = null;
		LOG.info(cartModel.getEntries().size() + "inside giftwrap service");
		for (final AbstractOrderEntryModel e : cartModel.getEntries())
		{
			LOG.info(e.getEntryNumber());
			if (entryNo == e.getEntryNumber())
			{
				entryModel = e;

				break;
			}

		}
		return entryModel;

	}

	private void calculateCostForEntry()
	{
		try
		{

			calculationService.recalculate(cartService.getSessionCart());

		}
		catch (final CalculationException e1)
		{
			// XXX Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
