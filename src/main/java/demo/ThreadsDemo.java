package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsDemo {

	public static void main(String[] args) {
		String name = Thread.currentThread().getName();
		System.out.println("main-name: "+name);
		testThread();
		System.out.println("22222");
	}

	
	public static void testThread() {
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 5; i++) {
			executor.execute(new Thread(() -> {
				System.out.println("11111-->");
				try {
					String name = Thread.currentThread().getName();
					System.out.println("name: "+name);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}));
		}
		
//		executor.shutdown();
//		try {
//			boolean awaitTermination = executor.awaitTermination(5, TimeUnit.SECONDS);
//			System.out.println("没有关闭");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("关闭");
	}

}
