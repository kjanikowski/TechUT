package test;


import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import pl.kjanikowski.hibernate.domain.City;
import pl.kjanikowski.hibernate.domain.Competition;
import pl.kjanikowski.hibernate.domain.SkiJump;
import pl.kjanikowski.hibernate.domain.SkiType;
import pl.kjanikowski.hibernate.service.SkiJumpManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class SkiJumpManagerTest {
	@Autowired
	SkiJumpManager sjm;
	
	
	//przechodzi tylko na czystej bazie, id nie sa ponownie uzywane przez db
	@Test
	public void removeAndGetByIDSkiJumpTest() { 
		Competition c = new Competition("PS");
		List<Competition> list = new ArrayList<Competition>();
		list.add(c);
		SkiJump Zak = new SkiJump("Wielka krokiew", 123, new Date(123), true, new City("Zakopane"), new SkiType("small"), list);
		SkiJump Wisla = new SkiJump("Skocznia im Adama Malysza", 123, new Date(123), true, new City("Wisla"), new SkiType("big"), list);
		sjm.addSkiJump(Zak);
		Competition a = new Competition("AA");

		list.add(a);
		sjm.addSkiJump(Wisla);
		
		
		
		sjm.removeSkiJump(Zak.getId());
		assertEquals(1, sjm.getAllSkiJumps().size());
		SkiJump sj = sjm.getSkiJump(Wisla.getId());
		assertEquals("Skocznia im Adama Malysza", sj.getName());

	}

	
	@Test()
	public void getAllSkiJumpsTest() {
		pop();
		assertEquals(2, sjm.getAllSkiJumps().size());
		assertEquals("Wielka krokiew", sjm.getAllSkiJumps().get(0).getName());
	}
	

	
	@Test
	public void getByNameTest() {
		pop();
		SkiJump sj = sjm.getByName("Wielka krokiew");
		assertEquals("Wielka krokiew", sj.getName());
	}
	
	@Test
	public void getBySkiTypeTest() {
		pop();
		List<SkiJump> sj = new ArrayList<SkiJump>();
		sj = sjm.getAllByType("small");
		assertEquals("Wielka krokiew", sj.get(0).getName());
	}
	
	@Test
	public void getByCity() {
		pop();
		
		assertEquals("Wielka krokiew", sjm.getByCity("Zakopane").getName());
	}
	
	
	public void pop() {
		Competition c = new Competition("PS");
		List<Competition> list = new ArrayList<Competition>();
		list.add(c);
		sjm.addSkiJump(new SkiJump("Wielka krokiew", 123, new Date(123), true, new City("Zakopane"), new SkiType("small"), list));
		Competition a = new Competition("AA");

		list.add(a);
		sjm.addSkiJump(new SkiJump("Skocznia im Adama Malysza", 123, new Date(123), true, new City("Wisla"), new SkiType("big"), list));
	}
	
	
}
