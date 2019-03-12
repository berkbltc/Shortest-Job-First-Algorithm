import java.util.ArrayList;
import java.util.Collections;

public class SJFScheduler {
	
	public void Schedule(ArrayList<Process> pList) throws CloneNotSupportedException {

		Collections.sort(pList, (p1, p2) -> p1.arrivalTime - p2.arrivalTime);
		ArrayList<Process> readyList=new ArrayList<Process>();
		ArrayList<Process> pList2=new ArrayList<Process>();// Update waiting times
		int totalWaitingTime=0;
		for(Process p : pList) {
			pList2.add(p.clone());
		}

		int time=0;
		while(!pList.isEmpty() || !readyList.isEmpty()) {
			time++;
			for( int i=0; i<pList.size(); i++ ) {
				if(pList.get(i).arrivalTime==time) { // coming process are added to   
					readyList.add(pList.get(i).clone()); 				//readyList.
					pList.remove(pList.get(i)); //
					i--;
				}
			}
			if(!readyList.isEmpty()) {
				Collections.sort(readyList, (p1, p2) -> p1.getBurstTime() - p2.getBurstTime());
				readyList.get(0).setBurstTime((readyList.get(0).getBurstTime())-1);
				if(readyList.get(0).getBurstTime()==0) {	// if process is terminated				
					readyList.remove(0);			
					for(int i=0; i<readyList.size(); i++) {
						for(Process j:pList2) {
							if(j.pName.equals(readyList.get(i).pName)) {
								j.setWaitingTime((j.getWaitingTime()) + 1);
								totalWaitingTime++;
							}
						}
					}
				}else {
					for(int i=1; i<readyList.size(); i++) { //if process is not terminated
						for(Process j:pList2) {
							if(j.pName.equals(readyList.get(i).pName)) {
								j.setWaitingTime((j.getWaitingTime()) + 1);
								totalWaitingTime++;
							}
						}
					}
				}
			}
		}
		System.out.println("ProcessName ArrivalTime     BurstTime      WaitingTime");
		for(Process p : pList2) 
			System.out.println(p);			

		System.out.println("Total waiting time: "+totalWaitingTime);
		System.out.println("Average waiting time: "+(double)totalWaitingTime/(double)pList2.size());
	}
	
}
