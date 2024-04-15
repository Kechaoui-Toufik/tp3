
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


public class UserRepositoryTest {

   UserRepository userRepositoryMock;
   Utilisateur utilisateurMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
   @Test
    public void getUserByIDShouldReturnTheUsercorrepondingToID(){
        final long ID = 123;
        userRepositoryMock = mock(UserRepository.class);
        utilisateurMock = mock(Utilisateur.class);
        when(userRepositoryMock.findUserByID(ID)).thenReturn(utilisateurMock);
        when(utilisateurMock.toString()).thenReturn("Toufik Kechaoui 24yo");
        UserService userService = new UserService(userRepositoryMock);
       Assertions.assertEquals("Toufik Kechaoui 24yo", userService.getUserByID(ID).toString());
       verify(userRepositoryMock).findUserByID(ID);
   }

}
