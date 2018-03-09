package general.thread.pool.worker;

import java.security.acl.Owner;

public class ThreadTracker {

	/**
	 * The number of Worker object threads that are currently working on something.
	 */
	private int _activeThreads = 0;
	
	private int total_Threads = 0;

	/**
	 * This boolean keeps track of if the very first thread has started or not. This
	 * prevents this object from falsely reporting that the ThreadPool is done, just
	 * because the first thread has not yet started.
	 */
	private boolean _started = false;

	public ThreadTracker(int size) {
		total_Threads = size;
	}

	public synchronized void startWorker() {
		_activeThreads++;
		_started = true;
		notify();
	}

	/**
	 * This method can be called to block the current thread until the ThreadPool is
	 * done.
	 */

	synchronized public void waitDone() {
		try {
			while (_activeThreads > 0) {
				wait();
			}
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Called to wait for the first thread to start. Once this method returns the
	 * process has begun.
	 */

	synchronized public void waitBegin() {
		try {
			while (!_started) {
				wait();
			}
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Called by a Worker object to indicate that it has completed a workload.
	 */
	synchronized public void workDone() {
		_activeThreads--;
		if (_activeThreads >= ((total_Threads)/2)) {
			System.out.println("****************************************************************");
		}
		notify();
	}

	/**
	 * Called to reset this object to its initial state.
	 */
	synchronized public void reset() {
		_activeThreads = 0;
	}
}
