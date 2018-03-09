package general.threads.examples;

import general.thread.pool.worker.TestingMain.Task;

public class ThreadPoolTesting {
	
	volatile static int runnableCount = 0;
	
	public static void main(String[] args) {
		WorkQueue w = new WorkQueue(10);
		int counter = 0;
		boolean flag = true;
		long before = System.nanoTime();
		/*for (int i = 1; i < 100000; i++) {
			w.execute(new Task());
		}*/
		for (int i=0; i<=1000000; i++) {
			w.execute(new Runner());
		}
		/*while (flag) {
			//System.out.println("Start Execution ........");
			w.execute(new Runnable() {
				@Override
				public void run() {
					//System.out.println(Thread.currentThread().getName() + " thread is executing me, ME : " + runnableCount++);
					System.out.println(".");
				}
			});
			if (counter == 5) {
				try {
					System.out.println("Sleeping ...............");
					Thread.sleep(40000);
					System.out.println("Awaken .................");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (counter == 1000000) {
				flag = false;
			}
			counter++;
		}*/
		w.shutdown(before);
	}
	
	public static class Runner implements Runnable {
		@Override
		public void run() {
			//System.out.println(Thread.currentThread().getName() + " thread is executing me, ME : " + runnableCount++);
			System.out.println(".");
		}		
	}

}
