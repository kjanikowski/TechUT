package test;


import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import pl.kjanikowski.hibernate.domain.SkiJump;
import pl.kjanikowski.hibernate.service.SkiJumpManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class SkiJumpManagerTest {
	@Autowired
	SkiJumpManager sjm;
	
	
	
	@Test
	public void addClientTest() {
		
		sjm.addSkiJump(new SkiJump("aaa", 123, new Date(123), true));
		
	}
	
	
	@Test
	public void deleteSkiJump() {
		sjm.deleteSkiJump(new SkiJump("aaa", 123, new Date(123), true));
	}
	
	
	
	
	
	
	
	
}
