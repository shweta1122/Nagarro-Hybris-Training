//package org.training.storefront.controllers.pages;
//
//
//import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
//import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
//import de.hybris.platform.cms2.model.pages.ContentPageModel;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import com.nagarro.nagarro.models.GiftWrapComponentModel;
//
//
//@Controller("GiftWrapComponentController")
//@Scope("tenant")
//@RequestMapping("/gifts")
//public class GiftWrapComponentController extends AbstractPageController
//{
//
//    protected void fillModel(final HttpServletRequest request, final Model model, final GiftWrapComponentModel component)
//    {
//
////        private static final String GIFTWRAP_CMS_PAGE = "MyCustomPage";
////        @RequestMapping(method = RequestMethod.GET)
////        public String getData(final Model model) throws CMSItemNotFoundException
////        {
////            final ContentPageModel giftWrapCMSPage = getContentPageForLabelOrId(GIFTWRAP_CMS_PAGE);
////            storeCmsPageInModel(model, giftWrapCMSPage);
////            setUpMetaDataForContentPage(model, giftWrapCMSPage);
////            return getViewForPage(model);
////        }
//
//
