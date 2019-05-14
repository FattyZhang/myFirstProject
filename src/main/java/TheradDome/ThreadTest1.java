package TheradDome;

public class ThreadTest1 {
	public static void main(String[] args) {
		ThreadService ts = new ThreadService();
		long start = System.currentTimeMillis();
		ts.execution(()->{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		ts.shutdown(8000);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		

	}
}






