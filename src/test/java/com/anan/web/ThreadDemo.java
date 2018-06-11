package com.anan.web;

import com.anan.web.domain.User;

/**
 * @author yanghaiyu
 * @date 2018/05/29
 **/
public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		User user = new User();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int j = 0; j < 50; j++) {
					synchronized (user) {
						for (int i = 0; i <= 10; i++) {
							System.out.println(i + "  " + Thread.currentThread().getName()+"  ci第几次"+j);
						}
						user.setName("1");
						user.notify();
						try {
							user.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}).start();
		for (int j = 0; j < 50; j++) {

			synchronized (user){
				if (user.getName()==null){
					user.wait();
				}
				for (int i = 0; i <= 100; i++) {
					System.out.println(i + "  " + Thread.currentThread().getName()+"  zhu第几次"+j);
				}
				user.notify();
				user.wait();
			}

		}

	}
}
