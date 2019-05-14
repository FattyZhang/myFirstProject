package functionDome;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

//函数式编程之线程相关FutureTask
/**
 * 即将开始的任务Demo
 * @author Administrator
 *
 */
public class FutuerTaskDome {
	// FutureTask  
	// 字面意思为即将开始的任务
	
	// Future 是一个接口,他定义了5个方法
	
	// 1. 取消一个任务，并返回取消结果。参数表示是否中断线程.
	// boolean cancel(boolean mayInterruptInRunning);
//	cancel方法用来取消任务，如果取消任务成功则返回true，如果取消任务失败则返回false。
//	参数mayInterruptIfRunning表示是否允许取消正在执行却没有执行完毕的任务，如果设置true，则表示可以取消正在执行过程中的任务。
//	如果任务已经完成，则无论mayInterruptIfRunning为true还是false，此方法肯定返回false，即如果取消已经完成的任务会返回false；
//	如果任务正在执行，若mayInterruptIfRunning设置为true，则返回true，若mayInterruptIfRunning设置为false，则返回false；
//	如果任务还没有执行，则无论mayInterruptIfRunning为true还是false，肯定返回true。
	
	// 2. 判断任务是否被取消
	// boolean isCancelled();
	
	// 3. 判断当前任务是否执行完毕，包括正常执行完毕、执行异常或者任务取消。
	// boolean isDone();
	
	// 4. 获取任务执行结果，任务结束之前会阻塞。
	// V get();
	
	// 5.在指定时间内尝试获取执行结果。若超时则抛出超时异常
	// V get(long timeout, TimeUnit unit);
	
	public static void main(String[] args) {
		int index = 2;
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			if(i == index) {
				flag = true;
			}else {
				flag = false;
			}
			System.out.println("for i :"+i);
			doTask(flag,i);
		}
	}
	
	private static void doTask(boolean flag,int i) {
		FutureTask<Integer> A = new FutureTask<Integer>( () -> {
			Thread.sleep(4000);
			System.out.println("FutureTask i:"+i);
			return i;
		});
		new Thread(A).start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		A.cancel(flag);
		boolean status = A.isCancelled();
		System.out.println("status:"+status);
	}
	
	
	@Test
	public void test1() throws Exception {
		Callable<Integer> call = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("call方法");
				Thread.sleep(3000);
				return 1;
			}
		};
		
		FutureTask<Integer> task = new FutureTask<Integer>(call);
		Thread th = new Thread(task);
		th.start();
		System.out.println("干点其他的..");
		Integer i = task.get();
		System.out.println("task:"+i);
		
		/* 运行结果为:
		 * 
		 * 干点其他的..
		 * call方法
		 * task:1
		 */
		
	}
	
	
}













