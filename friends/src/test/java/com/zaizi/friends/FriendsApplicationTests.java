package com.zaizi.friends;

import com.zaizi.friends.controllers.FriendController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendsApplicationTests {

	@Autowired
	FriendController friendController;
	@Test
	public void contextLoads() {
		//Smoke and Sanity Test
		//Check to see if the Friend controller is 'alive'
		Assert.assertNotNull(friendController);
	}

}
