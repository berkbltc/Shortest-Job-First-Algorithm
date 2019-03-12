
public class Process implements Cloneable{

	private int waitingTime;
	private int burstTime;
	public int arrivalTime;
	public String pName;
	
	public Process( String pName,int arrivalTime,int burstTime ) {
		this.waitingTime = 0;
		this.burstTime = burstTime;
		this.arrivalTime = arrivalTime;
		this.pName = pName;
	}
	
	@Override
	protected Process clone() throws CloneNotSupportedException {
		Process clone;
		clone = new Process(pName,arrivalTime,burstTime);
		clone.setWaitingTime(getWaitingTime());
		return clone;
	}

	public int getBurstTime() {
		return burstTime;
	}
	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
	public int getWaitingTime() {
		return waitingTime;
	}
	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	@Override
	public String toString() {
		return pName + "\t\t" +arrivalTime +"\t\t" +burstTime+"\t\t"+waitingTime;
	}

}
