
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

public class OrderControllerTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    OrderService orderServiceMock;
    OrderDao orderDaoMock;
    Order orderMock;
    @Test
    public void createOrderShouldSaveTheOrderInTheDatabase(){
         orderDaoMock = mock(OrderDao.class);
         orderServiceMock = mock(OrderService.class);
         orderMock = mock(Order.class);
         doNothing().when(orderDaoMock).saveOrder(orderMock);
         doCallRealMethod().when(orderServiceMock).createOrder(orderMock);
         doCallRealMethod().when(orderServiceMock).setOrderDao(orderDaoMock);
         orderServiceMock.setOrderDao(orderDaoMock);
         OrderController orderController = new OrderController(orderServiceMock);
         orderController.createOrder(orderMock);
         verify(orderServiceMock).createOrder(orderMock);
         verify(orderDaoMock).saveOrder(orderMock);
    }
}
