package test1;

import org.junit.Test;

public class Runner {
	
	public static Operator o;
	
	static {
		o = new Operator();
	}
	
	@Test
	public void solutionTest() {
		int currOrder = 54;
		o.processSolution(RunnerFactory.getClassByOrder(currOrder));
	}

}
