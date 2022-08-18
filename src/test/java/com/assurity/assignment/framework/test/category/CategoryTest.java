package com.assurity.assignment.framework.test.category;

import com.assurity.assignment.framework.business.api.category.CategoryFunctions;
import com.assurity.assignment.framework.model.api.response.category.Category;
import com.assurity.assignment.framework.model.api.response.category.Promotion;
import com.assurity.assignment.framework.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryTest extends TestBase {

    private CategoryFunctions categoryFunctions;

    @BeforeClass
    public void beforeClass() {
        categoryFunctions = new CategoryFunctions();
    }

    @Test
    public void readCategoryTest() {
        Category category = categoryFunctions.getCategory("6327", false);
        softAssert.assertEquals(category.getName(), "Carbon credits");
        softAssert.assertTrue(category.getCanRelist());
        validatePromotion(category.getPromotions(), "Gallery", "Good position in category");
        softAssert.assertAll();
    }

    private void validatePromotion(List<Promotion> promotionList, String searchKey, String valueToBePresent) {
        for (Promotion p : promotionList) {
            if (p.getName().equals(searchKey)) {
                softAssert.assertTrue(p.getDescription().contains(valueToBePresent));
            }
        }
    }

}
