package com.anan.web;

import com.anan.web.domain.User;

/**
 * @author yanghaiyu
 * @date 2018/05/24
 **/
public class ThreadTest {
	public static void main(String[] args) {
		/*User user = new User();
		new Thread(() ->{
			synchronized (user){
				System.out.println(1+Thread.currentThread().getName());
				try {
					user.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() ->{
			synchronized (user){
				System.out.println(1+Thread.currentThread().getName());
				try {
					user.notify();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

*/
		User user = new User();
		user.setName("1");
		new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("T1:" + i);
			}
			user.setName("2");
			synchronized (user){
				user.notify();
			}
		}
		).start();
		new Thread(() -> {
			synchronized (user) {

				try {
					user.wait();
					if (!user.getName().equals("2")) {
						user.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 1000; i++) {
					System.out.println("T2:" + i);
				}
				user.setName("3");
				user.notify();

			}

		}
		).start();
		new Thread(() -> {
			synchronized (user){
				try {
					user.wait();
					if (!user.getName().equals("3")) {
						user.wait();
					}else {
						user.notify();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 1000; i++) {
					System.out.println("T3:" + i);
				}

			}

		}
		).start();
	}
}
