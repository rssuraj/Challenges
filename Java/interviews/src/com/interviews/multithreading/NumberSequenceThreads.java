package com.interviews.multithreading;

/**
 * Spawns 3 threads performing following tasks:
 * 	- Thread1: Increments a number variable
 * 	- Thread2: Prints the value of number variable when its odd
 * 	- Thread3: Prints the value of number variable when its even
 * The numbers must be printed in sequence
 * 
 * @author rssuraj
 *
 */
public class NumberSequenceThreads {

	int i = 0;
	boolean odd = true;
	boolean even  = true;
	boolean incremented =  false;
	Object lock = new Object();
	
	public static void main(String[] args) {
		NumberSequenceThreads t = new NumberSequenceThreads();
		Thread t1 = new Thread(t.new IncrementThread());
		Thread tOdd = new Thread(t.new OddThread());
		Thread tEven = new Thread(t.new EvenThread());
		
		t1.start();
		tOdd.start();
		tEven.start();
		
	}
	
	class IncrementThread implements Runnable {		
		@Override
		public void run() {
			while(i < 10) {
				synchronized (lock) {
					while(incremented)
					{
						try {
							lock.wait();
						} 
						catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					i++;
					incremented = true;
					odd = i % 2 != 0;
					even = i % 2 == 0;
					lock.notifyAll();
				}
			}
		}
	}
	
	class OddThread implements Runnable {		
		@Override
		public void run() {
			while(i < 10) {
				synchronized (lock) {
					while(even)
					{
						try {
							lock.wait();
						} 
						catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("OddThread = " + i);
					incremented = false;
					even = true;
					lock.notifyAll();
				}
			}
		}
	}
	
	class EvenThread implements Runnable {		
		@Override
		public void run() {
			while(i < 10) {
				synchronized (lock) {
					while(odd)
					{
						try {
							lock.wait();
						} 
						catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("EvenThread = " + i);
					incremented = false;
					odd = true;
					lock.notifyAll();
				}
			}
		}
	}
}
