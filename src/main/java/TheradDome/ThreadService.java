package TheradDome;

public class ThreadService {

	private boolean sign = false;
	private Thread t1 = null;
	public void execution(Runnable runnable) {
		t1 = new Thread(() -> {
			Thread t2 = new Thread(runnable);
			t2.setDaemon(true);
			t2.start();
			try {
				t2.join();
				sign = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
	}

	public void shutdown(long mills) {
		long startTime = System.currentTimeMillis();
		while (!sign) {
			if(System.currentTimeMillis()-startTime >= mills) {
				System.out.println("任务超时,结束线程....");
				t1.interrupt();
				break;
			}
			try {
				t1.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("执行线程被打断..");
				break;
			}
			
		}
		sign = false;
	}

}
