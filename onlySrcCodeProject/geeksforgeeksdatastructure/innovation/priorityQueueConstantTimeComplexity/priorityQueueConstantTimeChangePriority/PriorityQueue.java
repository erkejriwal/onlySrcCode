package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.innovation.priorityQueueConstantTimeComplexity.priorityQueueConstantTimeChangePriority;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * a priority queue data structure for fixed no of priorities in which all process can be done in constant time
 * @author rakeshkejriwal
 */
public class PriorityQueue {
	
	private SinglePriorityProcesses[] processes;
	private int size;
	private int priorities;
	private int minPriority;
	
	public int getSize() {
		return size;
	}

	public int getPriorities() {
		return priorities;
	}

	public int getMinPriority() {
		return minPriority;
	}

	public static void main(String[] arg){
		PriorityQueue priorityQueue = new PriorityQueue(100);
		priorityQueue.insertUpdate(new Process(1), 50);
		priorityQueue.insertUpdate(new Process(2), 25);
		priorityQueue.insertUpdate(new Process(3), 75);
		priorityQueue.insertUpdate(new Process(4), 35);
		priorityQueue.insertUpdate(new Process(5), 65);
		priorityQueue.insertUpdate(new Process(6), 15);
		priorityQueue.insertUpdate(new Process(7), 90);
		priorityQueue.insertUpdate(new Process(8), 50);
		priorityQueue.insertUpdate(new Process(9), 50);
		priorityQueue.insertUpdate(new Process(10), 50);
		priorityQueue.printAllLiveProcess();
		priorityQueue.changePriority(9, 50, 75);
		priorityQueue.printAllLiveProcess();
		System.out.println("min priority process id is"+priorityQueue.getMinPriorityProcess().getId());
		priorityQueue.extractMinPriorityProcess();
		
		priorityQueue.printAllLiveProcess();
		System.out.println("min priority process id is:- "+priorityQueue.getMinPriorityProcess().getId() + " and priority is:- "+priorityQueue.getMinPriority());
		
		priorityQueue.changePriority(2, 25, 75);
		priorityQueue.printAllLiveProcess();

		System.out.println("min priority process id is:- "+priorityQueue.getMinPriorityProcess().getId() + " and priority is:- "+priorityQueue.getMinPriority());


	}
	
	public PriorityQueue(int priorities){
		this.processes = new SinglePriorityProcesses[priorities];
		for (int i = 0; i < processes.length; i++) {
			this.processes[i] = new SinglePriorityProcesses();
		}
		this.size = 0;
		this.priorities = priorities;
		this.minPriority = priorities-1;
	}
	
	public boolean insertUpdate(Process process,int priority){
		if(priority < 0 || priority >= this.priorities || process == null || process.isDeleted()){
			System.out.println("wrong priority - process entered");
			return false;
		}	
		if(this.minPriority > priority){
			this.minPriority = priority;
		}
		boolean newInsert = this.processes[priority].insertUpdate(process);
		if(newInsert){
			this.size++;
		}
		return newInsert;
	}
	
	public Process getMinPriorityProcess(){
//		Process process = null;
//		for (int i = 0; i < processes.length; i++) {
//			if(processes[i].getSize() > 0){
//				return processes[i].peek();
//			}
//		}
		return this.processes[this.minPriority].peek();
	}
	
	public Process extractMinPriorityProcess(){
		Process process = null;
		int i;
		for (i = 0; i < processes.length; i++) {
			if(processes[i].getSize() > 0){
				process  = processes[i].poll();
				break;
			}
		}
		this.setNextMinPriorityToMinPriority();
		return process;
	}
	
	private void setNextMinPriorityToMinPriority(){
		if(this.processes[this.minPriority].getSize() == 0){
			int i = this.minPriority+1;
			while(i < this.priorities && processes[i].getSize()==0){
				i++;
			}
			this.minPriority = i;
		}
	}
	
	public boolean changePriority(int processId,int currentPriority, int newPriority){
		Object processData = processes[currentPriority].deleteAndGetProcessData(processId);
		if(processData != null){
			processes[newPriority].insertUpdate(new Process(processId,processData));
			if(this.minPriority > newPriority){
				this.minPriority = newPriority;
			}else{
				this.setNextMinPriorityToMinPriority();		
			}
			return true;
		}
		return false;
	}
	
	public void printAllLiveProcess(){
		System.out.println("\npriority queue process priorities are:-");
		for (int i = 0; i < processes.length; i++) {
			if(processes[i].getSize() > 0 ){
				System.out.print("priority "+i+" has process ids are:- ");
				processes[i].printAllProcess();
				System.out.println();
			}
		}
	}
}

/**
 * this class is a process class which has an id attribute and in deleted attribute it has information 
 * regarding current process is active or it is finished/deleted.
 * @author rakeshkejriwal
 *
 */
class Process{
	//process unic id
	private int id;
	//process is active or not, is it deleted or not
	private boolean deleted;
	/**
	 * this attibute contains all required data of perticular process, this is created so that while we delete some process from 
	 * map but it will be there in queue and it will consume space so to reduce space complexity while removing from map we will 
	 * assign "processData" to null so that no such space complexity issue will occur.
	 */
	private Object processData;
			
	public Process(int id){
		this.id = id;
		this.processData = new String(id+" process data exists");
	}
	
	public Process(int id,Object processData){
		this.id = id;
		this.processData = processData;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Object getProcessData() {
		return processData;
	}
	public void setProcessData(Object processData) {
		this.processData = processData;
	}
}

/**
 * this class contains all processes with single priority, it stores one process reference in queue and in hashmap
 * so that data can be retrieved in constant time.
 * @author rakeshkejriwal
 *
 */
class SinglePriorityProcesses{
	private Queue<Process> queue = new LinkedList<Process>();
	private Map<Integer, Process> map = new HashMap<Integer, Process>();
	private int size;
	
	public int getSize() {
		return size;
	}

	public SinglePriorityProcesses(){
		this.queue = new LinkedList<Process>();
		this.map = new HashMap<Integer, Process>();
		this.size = 0;
	}
	
	public boolean insertUpdate(Process process){
		if(!this.map.containsKey(process.getId())){
			this.map.put(process.getId(), process);
			this.queue.add(process);
			this.size++;
			return true;
		}else{
			this.map.get(process.getId()).setProcessData(process.getProcessData());
			return false;
		}
	}
	
	public Object deleteAndGetProcessData(int id){
		Object processData = null;
		if(this.map.containsKey(id)){
			//process data set to null to reduces memory miss use/ to reduce space complexity
			processData = this.map.get(id).getProcessData();
			this.map.get(id).setProcessData(null);
			// set flag deleted to true to specify this process is not in use
			this.map.get(id).setDeleted(true);
			this.map.remove(id);
			this.size--;
			return processData;
		}
		return processData;
	}
	
	/**
	 * this method peeks active process and returns if exists, if deleted process comes up it removes it from queue
	 * if no active process exists then return null
	 * @return process
	 */
	public Process peek(){
		Process process = null;
		while((process = queue.peek()) != null){				 
			if(process.isDeleted()){
				queue.poll();
			}else{
				break;
			}
		}
		if(process != null && process.isDeleted() == false){
			return process;
		}else{
			return null;
		}
	}
	
	/**
	 * this method polls active process from queue and returns if exists, if deleted process comes up it removes it from queue
	 * if no active process exists then return null
	 * @return process
	 */
	public Process poll(){
		Process process = null;
		while((process = queue.poll()) != null){
			if(!process.isDeleted()){
				break;
			}
		}
		if(process != null && process.isDeleted() == false){
			this.map.remove(process.getId());
			this.size--;
			return process;
		}else{
			return null;		
		}		
	}
	
	public void printAllProcess(){
		for (Process process : queue) {
			if(!process.isDeleted()){
				System.out.print(process.getId()+",");
			}
		}
	}
	
}