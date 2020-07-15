package test1;

public class Operator {

	private long startTime;
	
	private long endTime;
	
	private long runTime;
	
	public void setStartTime() {
		this.startTime = System.currentTimeMillis();
	}
	
	public void setEndTime() {
		this.endTime = System.currentTimeMillis();
	}
	
	public long getStartTime() {
		return this.startTime;
	}
	
	public long getEndTime() {
		return this.endTime;
	}
	
	public long getRunTime() {
		if(this.endTime <= this.runTime) {
			return -1;
		}
		return this.endTime - this.startTime;
	}
	
	public double getRunTimeBySecond() {
		if(this.getRunTime() == -1) {
			return -1.0;
		}
		return ((double)this.runTime) / 1000;
	}
	
	public void processSolution(Base base) {
		this.prefixDivider(base);
		this.setStartTime();
		base.runFunc();
		this.setEndTime();
		System.out.println("run time is: " + this.getRunTimeBySecond());
		this.postDivider(base);
		
	}
	
	public void printInfo(Base base) {
		// TODO Auto-generated method stub
		System.out.println(base.getInfo());
	}
	
	public void prefixDivider(Base base) {
		StringBuffer sb = new StringBuffer();
		sb.append("*******");
		sb.append(base.getClass().getName());
		sb.append("*******");
		sb.append("\r\n");
		System.out.println(sb.toString());
	}
	
	public void postDivider(Base base) {
		StringBuffer sb = new StringBuffer();
		sb.append("*******");
		sb.append("end");
		sb.append("*******");
		System.out.println(sb.toString());
	}
	
}
