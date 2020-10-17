package com.nagarro.facades.populators;



import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

public class TrainingSearchResultVariantProductPopulator extends SearchResultVariantProductPopulator
{

    @Override
    public void populate(final SearchResultValueData source, final ProductData target)
    {
        super.populate(source, target);
        //Adding wrap available to product data
        final Object obj = this.getValue(source, "wrapAvailable");
        if (obj != null)
        {
            target.setWrapAvailable(this.<Boolean> getValue(source, "wrapAvailable").booleanValue());
        }
        else
        {
            target.setWrapAvailable(true);
        }


    }
}