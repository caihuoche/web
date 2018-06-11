package com.anan.web;

import com.anan.web.domain.User;

/**
 * @author yanghaiyu
 * @date 2018/06/07
 **/
public class DeadlockTest {

	public static void main(String[] args) {
		User user = new User();
		User user2 = new User();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true){
					synchronized (user){
						System.out.println("1号开饭了");
						synchronized (user2){
							System.out.println("1好吃完了");
						}
					}

				}

			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true){
					synchronized (user2){
						System.out.println("2号开饭了");
						synchronized (user){
							System.out.println("2好吃完了");
						}
					}

				}

			}
		}).start();
	}
}
