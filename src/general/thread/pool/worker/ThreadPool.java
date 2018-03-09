package general.thread.pool.worker;

import java.util.LinkedList;

public class ThreadPool {

	/**
	 * The threads in the pool.
	 */
	protected Thread threads[];

	/**
	 * The backlog of assignments, which are waiting for the thread pool.
	 */
	LinkedList<Runnable> pendingWorkList;

	/**
	 * A ThreadTracker object that is used to track when the thread pool is done,
	 * that is has no more work to perform.
	 */
	protected ThreadTracker threadTracker;

	/**
	 * The constructor.
	 * 
	 * @param size
	 *            How many threads in the thread pool.
	 */
	public ThreadPool(int size) {
		pendingWorkList = new LinkedList<Runnable>();
		threadTracker = new ThreadTracker(size);
		threads = new WorkerThread[size];
		System.out.println(size + " threads are getting created");
		for (int i = 0; i < threads.length; i++) {
			String name = "KAUSHIK-" + (i+1) ;
			threads[i] = new WorkerThread(this);
			threads[i].setName(name);
			threads[i].start();
		}
	}

	/**
	 * Add a task to the thread pool. Any class which implements the Runnable
	 * interface may be assienged. When this task runs, its run method will be
	 * called.
	 * 
	 * @param r
	 *            An object that implements the Runnable interface
	 */
	public synchronized void assign(Runnable r) {
		threadTracker.startWorker();
		pendingWorkList.addLast(r);
		System.out.println("---------Added Task in worklist------- total 	: " + pendingWorkList.size());
		notify();
	}

	/**
	 * Get a new work assignment.
	 * 
	 * @return A new assignment
	 */
	public synchronized Runnable getAssignment() {
		String threadName = Thread.currentThread().getName();
		try {
			while (pendingWorkList.isEmpty()) {
				System.out.println(threadName + " No work, going into wait-set");
				wait();
				System.out.println(threadName + " thread got notified");
			}
			System.out.println(threadName + " thread got the task");
			return pendingWorkList.removeFirst();
		} catch (InterruptedException e) {
			System.out.println("@@@ - Exception");
			threadTracker.workDone();
			return null;
		}
	}

	/**
	 * Called to block the current thread until the thread pool has no more work.
	 */
	public void complete() {
		threadTracker.waitBegin();
		threadTracker.waitDone();
	}

	@SuppressWarnings("deprecation")
	protected void finalize() {
		threadTracker.reset();
		for (int i = 0; i < threads.length; i++) {
			threads[i].interrupt();
			threadTracker.startWorker();
			threads[i].destroy();
		}
		threadTracker.waitDone();
	}
}
