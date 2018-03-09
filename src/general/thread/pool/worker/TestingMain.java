package general.thread.pool.worker;

public class TestingMain {

	public static void main(String[] args) {
		
		ThreadPool pool = new ThreadPool(2);
		long begin = System.nanoTime();
		for (int i = 1; i < 100000; i++) {
			pool.assign(new Task());
		}
		pool.complete();
		System.out.println("All tasks are done.");
		System.out.println("Time consumed is : " + (System.nanoTime() - begin)/1000000 + " mili second");
	}
	
	/**
	 * This class shows an example worker thread that can be used with the thread
	 * pool. It demonstrates the main points that should be included in any worker
	 * thread. Use this as a starting point for your own threads.
	 *
	 */
	public static class Task implements Runnable {
		static private int count = 0;
		private int taskNumber;

		public Task() {
			count++;
			taskNumber = count;
		}

		public void run() {
			/*for (int i = 0; i <= 100; i += 5) {
				System.out.println("Task number: " + taskNumber + ",percent complete by thread ( "+Thread.currentThread().getName()+" ) = " + i );
				try {
					Thread.sleep((int) (Math.random() * 500));
				} catch (InterruptedException e) {
				}
			}*/
			System.out.println("Hi");
		}
		
		public int getTaskNumber() {
			return taskNumber;
		}
	}
}
