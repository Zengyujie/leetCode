package test1;

public class RunnerFactory {
	
	public static final String CURRPACK = "test1.";
	
	public static Base getClass(String className) {
		
		Base base = null;
		try {
			Class currClass = Class.forName(CURRPACK+className);
			Object o = currClass.newInstance();
			if(o instanceof Base) {
				base = (Base)o;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return base;
	}
	
	public static Base getClassByOrder (int order) {
		return getClass("Solution" + order);
	}
	
}


