package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.experimental.theories.internal.BooleanSupplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HaushaltsroboternTest {
	private Haushaltroboter roboter;
	String[] farbe = {"gelb", "weiss"};
	@BeforeEach
	void setUp() {
		roboter = new Haushaltroboter(39235, 590, "Fensterputzer", "passiv", farbe);
	}
	
	@AfterEach
	void reset() {
		this.roboter = null;
	}

	@Test
	void test() {
		assertTrue( ()-> roboter.getSeriennummer() == 39235 ,"This is true");
		
		//Test when Farbe is null
		Throwable exp = (IllegalArgumentException.class, ()->{roboter.setFarbeAusStringArray(null);});
		assertThrows(IllegalArgumentException, exp.getMessage());
	}

}

//39235 590 Fensterputzer passic gelb, weiss