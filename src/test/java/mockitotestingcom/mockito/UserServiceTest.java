package mockitotestingcom.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mockito.User;
import com.mockito.UserRepository;
import com.mockito.UserService;

public class UserServiceTest {
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getUserNameTest() {
		when(userRepository.findUserById(2)).thenReturn(new User(2,"Lokesh"));
		String name = userService.getUserName(2);
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		verify(userRepository).findUserById(2);
		assertEquals("Lokesh",name);
	}
}
