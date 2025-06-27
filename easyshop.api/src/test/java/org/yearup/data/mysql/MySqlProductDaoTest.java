package org.yearup.data.mysql;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.yearup.models.Product;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class MySqlProductDaoTest extends BaseDaoTestClass
{
    private MySqlProductDao dao;

    @BeforeEach
    public void setup()
    {
        dao = new MySqlProductDao(dataSource);
    }

    @Test
    public void getById_shouldReturn_theCorrectProduct()
    {
        // arrange
        int productId = 1;
        Product expected = new Product()
        {{
            setProductId(1);
            setName("Smartphone");
            setPrice(new BigDecimal("499.99"));
            setCategoryId(1);
            setDescription("A powerful and feature-rich smartphone for all your communication needs.");
            setColor("Black");
            setStock(50);
            setFeatured(false);
            setImageUrl("smartphone.jpg");
        }};

        // act
        var actual = dao.getById(productId);

        // assert
        assertEquals(expected.getPrice(), actual.getPrice(), "Because I tried to get product 1 from the database.");
    }

    @Test
    public void getProductsWithAMinAndMaxPrice_ShouldReturnCorrectNumberOfPrice() {
        BigDecimal minPrice = BigDecimal.valueOf(700);
        BigDecimal maxPrice = BigDecimal.valueOf(1500);

        List<Product> product =dao.search(-1, minPrice, maxPrice, "");

        assertEquals(1, product.size());

    }

    @Test
    public void makeSureUpdatedProductDoesntCreateNewProduct() {

        //create new product
        Product product = new Product();

        product.setName("Old Product");
        product.setCategoryId(1);
        product.setPrice(new BigDecimal("43.33"));
        product.setDescription("Test Description");
        product.setColor("");
        product.setImageUrl("");
        product.setStock(1);
        product.setFeatured(true);

        product = dao.create(product);
        int testId = product.getProductId();

        //update product
        product.setName("new Product");

        dao.update(product.getProductId(), product);

        Product updateProduct = dao.getById(testId);

        assertEquals("new Product", product.getName());

    }

}