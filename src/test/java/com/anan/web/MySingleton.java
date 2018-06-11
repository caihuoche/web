package com.anan.web;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum MySingleton {
	INSTANCE;
	private ExecutorService executorService;
     MySingleton() {
        System.out.println("Here");
		  executorService =  Executors.newFixedThreadPool(2);
	 }
	 public ExecutorService getExecutorService(){
     	return executorService;
	 }
}
