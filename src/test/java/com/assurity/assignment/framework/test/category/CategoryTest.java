package com.assurity.assignment.framework.test.category;

import com.assurity.assignment.framework.business.api.category.CategoryFunctions;
import com.assurity.assignment.framework.model.api.response.category.Category;
import com.assurity.assignment.framework.model.api.response.category.Promotion;
import com.assurity.assignment.framework.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryTest extends TestBase {

    private static final String CATEGORY_ID = "6327" ;
    private static final String CATEGORY_NAME = "Carbon credits" ;
    private static final String PROMOTION_NAME = "Gallery" ;
    private static final String PROMOTION_DESCRIPTION = "Good position in category" ;

    private CategoryFunctions categoryFunctions;

    @BeforeClass
    public void beforeClass() {
        categoryFunctions = new CategoryFunctions();
    }

    @Test
    public void readCategoryTest() {
        Category category = categoryFunctions.getCategory(CATEGORY_ID, false);
        softAssert.assertEquals(category.getName(), CATEGORY_NAME, "Expected category name not found!");
        softAssert.assertTrue(category.getCanRelist(), "Can relist value is false!");
        validatePromotion(category.getPromotions(), PROMOTION_NAME, PROMOTION_DESCRIPTION);
        softAssert.assertAll();
    }

    private void validatePromotion(List<Promotion> promotionList, String searchKey, String valueToBePresent) {
        for (Promotion promotion : promotionList) {
            if (promotion.getName().equals(searchKey)) {
                softAssert.assertTrue(promotion.getDescription().contains(valueToBePresent), "Promotion description is invalid!");
            }
        }
    }

}
