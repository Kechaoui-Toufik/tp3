
import org.example.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    ProductApiClient productApiClientMock;
    Product productMock;
    @Test
    public void getProductShouldReturnTheProductBasedOnTheProductId(){
        String productId= "A123";
        productApiClientMock = mock(ProductApiClient.class);
        productMock = mock(Product.class);
        ProductService productService = new ProductService(productApiClientMock);
        when(productApiClientMock.getProduct(productId)).thenReturn(productMock);
        when(productApiClientMock.checkIdProduct(productId)).thenReturn(true);
        Assertions.assertEquals(productMock,productService.getProduct(productId) );
        verify(productApiClientMock).getProduct(productId);

    }
    @Test
    public void getProductShouldThrowAnExceptionIfTheFormatOfProductIdIsWrong(){
        String productId= "A123";
        productApiClientMock = mock(ProductApiClient.class);
        productMock = mock(Product.class);
        ProductService productService = new ProductService(productApiClientMock);
        when(productApiClientMock.getProduct(productId)).thenReturn(productMock);
        when(productApiClientMock.checkIdProduct(productId)).thenReturn(false);
        Assertions.assertThrows(IllegalArgumentException.class, ()->productService.getProduct(productId));
        verify(productApiClientMock,never()).getProduct(productId);
    }

}
