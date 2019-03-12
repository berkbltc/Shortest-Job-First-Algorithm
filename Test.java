import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		SJFScheduler myScheduler =new SJFScheduler();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the total no of processes: ");
		int totalProcessNumber=scan.nextInt();
		ArrayList<Process> Processes =new ArrayList<Process>();
		int i,pArrival,pBurst;
		String pName;
		for(i=0;i<totalProcessNumber;i++) {
			scan.nextLine();
			System.out.println("Enter p_name: ");
			pName=scan.nextLine();
			System.out.println("Enter p_arrival: ");
			pArrival=scan.nextInt();
			System.out.println("Enter p_burst: ");
			pBurst=scan.nextInt();
			Process a=new Process(pName,pArrival,pBurst);
			Processes.add(a);

		}
		myScheduler.Schedule(Processes);
		scan.close();
	}
	
}
