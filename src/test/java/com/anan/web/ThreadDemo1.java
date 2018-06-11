package com.anan.web;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.anan.web.domain.User;

/**
 * @author yanghaiyu
 * @date 2018/05/29
 **/
public class ThreadDemo1 {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		User user = new User();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int j = 0; j < 50; j++) {
					try {
						lock.lock();
						for (int i = 0; i <= 10; i++) {
							System.out.println(i + "  " + Thread.currentThread().getName() + "  ci第几次" + j);
						}
						user.setName(""+j);
						condition.signal();
						condition.await();
					}catch (Exception e){

					}finally {
						lock.unlock();
					}

				}
			}
		}).start();
		for (int j = 0; j < 50; j++) {
		try {
			lock.lock();
			if (user.getName()==null){
				condition.await();
			}
			for (int i = 0; i <= 100; i++) {
				System.out.println(i + "  " + Thread.currentThread().getName() + "  zhu第几次" + j);
			}
			condition.signal();
			if (!user.getName().equals("49")){
				condition.await();
			}
		}finally {
			lock.unlock();
		}


		}
	}
}
