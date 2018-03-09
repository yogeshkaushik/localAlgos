package general.threads.examples;

import java.util.LinkedList;

public class WorkQueue {
	
	private final int noOfThreds;
	private LinkedList<Runnable> queue;
	private WorkerThread[] threads;
	volatile static long pendingTasks;
	
	public WorkQueue(int nThreads) {
		noOfThreds = nThreads == 0 ? 1 : nThreads;
		queue = new LinkedList<Runnable>();
		threads = new WorkerThread[nThreads];
		createThreadPool();
	}

	private void createThreadPool() {
		for (int i=0; i<noOfThreds; i++) {
			String n = "KAUSHIK-"+i;
			threads[i] = new WorkerThread();
			threads[i].setName(n);
			//System.out.println(n + " thread got created.");
			threads[i].start();
		}
	}
	
	public void execute(Runnable r) {
		synchronized (queue) {
			pendingTasks++;
			//System.out.println("## Work Queue status before --> pending work : " + queue.size());
			queue.addLast(r);
			queue.notify();
			//queue.notifyAll();
			//System.out.println("@@ Work Queue status after--> pending work : " + queue.size());
		}
	}
	
	public void shutdown(long before) {
		while (pendingTasks != 0 ) {
		}
		System.out.println("Total time taken = " + -(before - System.nanoTime())/1000000 + " mili second");
		/*for (int i=0; i<noOfThreds; i++) {
			threads[i]
			threads[i].setName(n);
			System.out.println(n + " thread got created.");
			threads[i].start();
		}	*/	
	}
	
	private class WorkerThread extends Thread {
		
		@Override
		public void run() {
			final String name = Thread.currentThread().getName();
			Runnable r = null;
			for (;;) {
				//System.out.println(name + " thread is inside for-ever loop now and running...");
				synchronized (queue) {
					//System.out.println(name + " thread has aquired the monitor");
					while (queue.isEmpty()) {
						try {
							//System.out.println(name + " thread is going to wait-set");
							queue.wait();
							//System.out.println(name+" thread is awaken and owns monitor, going to complete task");
						} catch (Throwable e) {
							System.out.println("### : ");
							e.printStackTrace();
						}
					}
					r = queue.removeFirst();
					pendingTasks--;
				}
				
				try {
					r.run();
				} catch (Throwable e) {
					System.out.println("@@@ : ");
					e.printStackTrace();
				}
			
			}
		}
	}
}
