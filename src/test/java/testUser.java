import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testUser {

	@Test
	void 이름테스트() {
		
		User user=new User("상엽","현정","웅휘");
		User user2=new User("상엽","현정","웅휘");
		assertSame(user, user2);
				
	}

}
