package general.thread.pool.worker;

import general.thread.pool.worker.TestingMain.Task;

public class WorkerThread extends Thread {

	/**
	 * True if this thread is currently processing.
	 */
	public boolean busy;
	
	/**
	 * The thread pool that this object belongs to.
	 */
	public ThreadPool owner;

	/**
	 * The constructor.
	 * 
	 * @param o the thread pool
	 */
	public WorkerThread(ThreadPool o) {
		owner = o;
	}

	/**
	 * Scan for and execute tasks.
	 */
	public void run() {
		String threadName = Thread.currentThread().getName();
		Runnable target = null;

		do {
			System.out.println(threadName + " thread asks for work");
			target = owner.getAssignment();
			if (target != null) {
				System.out.println(threadName + " thread performing work on Task : "+ ((Task)target).getTaskNumber());
				target.run();
				owner.threadTracker.workDone();
			}
		} while (target != null);
	}
}
