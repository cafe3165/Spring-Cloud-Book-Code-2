package com.cxytiandi.hystrix_native_demo.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class CacheCleanApp {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		HystrixRequestContext context = HystrixRequestContext.initializeContext();
		String result = new ClearCacheHystrixCommand("yinjihuan").execute();
		System.out.println(result);
		Thread.sleep(1000);
//		ClearCacheHystrixCommand.flushCache("yinjihuan");
		Future<String> future = new ClearCacheHystrixCommand("yinjihuan").queue();
//		String result2 = new ClearCacheHystrixCommand("yinjihuan").execute();

		System.out.println(future.get());
		context.shutdown();

	}
}
