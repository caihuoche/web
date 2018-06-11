package com.anan.web;

import com.anan.web.domain.User;

/**
 * @author yanghaiyu
 * @date 2018/05/25
 **/
public class Consumer implements Runnable {
	private User user;

	public Consumer() {
	}


	public Consumer(User user) {
		this.user = user;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (user) {
				if (user.getName() != null && !user.getName().equals("")) {
					System.out.println("消费这个消息:" + user.getName());
					user.setName(null);
				}
				try {
					user.notify();
					user.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
