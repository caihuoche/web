package com.anan.web;

/**
 * @author yanghaiyu
 * @date 2018/05/25
 **/
public class ThreadFor {
	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (ThreadFor.class){
				for (int i = 0; i < 1000; i++) {
					try {
						ThreadFor.class.wait();
						System.out.println("T2        :" + i);
						ThreadFor.class.notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		}
		).start();

		new Thread(() -> {
			synchronized (ThreadFor.class){
				for (int i = 0; i < 1000; i++) {
					try {
						System.out.println("T1:" + i);
						ThreadFor.class.notify();
						ThreadFor.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		}
		).start();
	}
}
