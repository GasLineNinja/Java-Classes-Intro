import junit.framework.TestCase;

public class TestClass extends TestCase{
	
	public void setUp() {
	}
	
	
	//testing Ride Constructors
	public void test00() {
		Ride tiltAWhirl = new Ride();
		
		assertEquals(3, tiltAWhirl.getAgeReq());
		assertEquals(30.0, tiltAWhirl.getHeightReq());
		assertEquals(3, tiltAWhirl.getTicketReq());
		
		
		Ride rollerDerby = new Ride(100,10,6);
		assertEquals(10, rollerDerby.getAgeReq());
		assertEquals(100.0, rollerDerby.getHeightReq());
		assertEquals(6, rollerDerby.getTicketReq());
	}
	
	//testing ride getters and setters
	public void test01() {
		Ride screamer = new Ride(100,12,7);
		
		screamer.setAgeReq(6);
		assertEquals(6, screamer.getAgeReq());
		
		screamer.setAgeReq(2);
		assertEquals(3, screamer.getAgeReq());

		screamer.setHeightReq(200);
		assertEquals(200.0, screamer.getHeightReq());

		screamer.setHeightReq(-15);
		assertEquals(30.0, screamer.getHeightReq());
		
		screamer.setTicketReq(5);
		assertEquals(5, screamer.getTicketReq());
		
		screamer.setTicketReq(0);
		assertEquals(3, screamer.getTicketReq());
	}
	
	
	//testing Person constructors
	public void test02() {
		Person jeff = new Person(87.5,11,20);
		
		assertEquals(87.5, jeff.getHeight());
		assertEquals(11, jeff.getAge());
		assertEquals(20, jeff.getTickets());
		
		
		Person jane = new Person(83,9);
		assertEquals(83.0, jane.getHeight());
		assertEquals(9, jane.getAge());
		assertEquals(0, jane.getTickets());
		
		//test negatives
	}

	//testing Person constructors with negative values
	public void test03() {
		Person jeff = new Person(-87.5,-11,-20);
		
		assertEquals(87.5, jeff.getHeight());
		assertEquals(11, jeff.getAge());
		assertEquals(20, jeff.getTickets());
		
		
		Person jane = new Person(-83,-9);
		assertEquals(83.0, jane.getHeight());
		assertEquals(9, jane.getAge());
		assertEquals(0, jane.getTickets());
		
		Person xuhai = new Person(66.3, -44, 9);
		assertEquals(66.3, xuhai.getHeight());
		assertEquals(44, xuhai.getAge());
		assertEquals(9, xuhai.getTickets());
		
		
	}
	
	//testing buyTickets
	public void test04() {
		Person jeff = new Person(87.5,11,20);
		
		assertTrue(jeff.buyTickets(0));
		assertEquals(20, jeff.getTickets());
		
		assertTrue(jeff.buyTickets(12));
		assertEquals(32, jeff.getTickets());
		
		assertFalse(jeff.buyTickets(-4));
		assertEquals(32, jeff.getTickets());
		
	}
	
	//testing growth
	public void test05() {
		Person jack = new Person(30,1);
		
		assertTrue(jack.growth(15.5,2));
		assertEquals(3, jack.getAge());
		assertEquals(45.5, jack.getHeight());
		
		assertFalse(jack.growth(-1, 12));
		assertFalse(jack.growth(9, -2));
		assertFalse(jack.growth(-3, -3));
		
		assertEquals(3, jack.getAge());
		assertEquals(45.5, jack.getHeight());
		
		assertTrue(jack.growth(2.4,0));
		
		assertEquals(3, jack.getAge());
		assertEquals(47.9, jack.getHeight());
		
	}
	
	//testing attemptToRide
	public void test06() {
		Ride ferrisWheel = new Ride(70,6,3);
		Person joe = new Person(67,7,10);
		
		assertFalse(joe.attemptToRide(ferrisWheel));
		assertEquals(10,joe.getTickets());
		
		ferrisWheel.setHeightReq(65);
		assertTrue(joe.attemptToRide(ferrisWheel));
		
		assertEquals(7,joe.getTickets());
		
		ferrisWheel.setTicketReq(10);
		assertFalse(joe.attemptToRide(ferrisWheel));
		
		joe.buyTickets(50);
		ferrisWheel.setAgeReq(88);
		assertFalse(joe.attemptToRide(ferrisWheel));
		
	}
	
	
	//testing giveTickets
	public void test07() {
		Person jill = new Person(89,10,25);
		Person john = new Person(70.5,8);
		
		assertFalse(john.giveTickets(jill, 3));
		
		assertEquals(25, jill.getTickets());
		assertEquals(0,john.getTickets());
		
		jill.giveTickets(john, 10);
		
		assertEquals(15, jill.getTickets());
		assertEquals(10,john.getTickets());
		
		assertFalse(jill.giveTickets(john, -20));
		assertFalse(jill.giveTickets(john, 200));
		
		assertEquals(15, jill.getTickets());
		assertEquals(10,john.getTickets());
		
		assertTrue(jill.giveTickets(john, -2));
		
		assertEquals(17, jill.getTickets());
		assertEquals(8,john.getTickets());
	}
	
	//testing nulls
	public void test08() {
		Person arjin = new Person(66.0, 16, 12);
		
		assertFalse(arjin.giveTickets(null, 6));
		assertFalse(arjin.giveTickets(null, -1));
		assertEquals(12, arjin.getTickets());
		
		assertFalse(arjin.attemptToRide(null));
		assertEquals(12, arjin.getTickets());
	}
	
	//testing identical input
	public void test09() {
		Person anton = new Person(20, 19, 10);
		assertTrue(anton.giveTickets(anton, 0));
		assertEquals(10, anton.getTickets());
		assertTrue(anton.giveTickets(anton, 8));
		assertEquals(10, anton.getTickets());
		assertTrue(anton.giveTickets(anton, -5));
		assertEquals(10, anton.getTickets());
		assertFalse(anton.giveTickets(anton, 15));
		assertEquals(10, anton.getTickets());
	}
	
	
	//cumulative tests
	public void test10() {
		Ride brainBuster = new Ride(100,12,7);
		Ride kiddyKoaster = new Ride(50,6,3);
		Person sally = new Person(60,7);
		Person sarah = new Person(110,14,20);
		
		
		assertTrue(sarah.attemptToRide(brainBuster));
		assertFalse(sally.attemptToRide(brainBuster));
		
		sally.buyTickets(3);
		assertTrue(sally.attemptToRide(kiddyKoaster));
		
		sally.growth(30.6, 3);
		sarah.giveTickets(sally, 8);
	
		assertEquals(5,sarah.getTickets());
		
		assertFalse(sally.attemptToRide(brainBuster));
		
		sally.growth(9.4, 2);
		assertTrue(sally.attemptToRide(brainBuster));
		
		assertEquals(1,sally.getTickets());
		
		assertTrue(sarah.attemptToRide(kiddyKoaster));
		assertFalse(sarah.attemptToRide(kiddyKoaster));
		
		assertEquals(2,sarah.getTickets());
		

	}
	
}
