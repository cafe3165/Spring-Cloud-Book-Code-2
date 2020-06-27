package com.cxytiandi.hystrix_native_demo.mydemo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * Author:cafe3165
 * Date:2020-05-24
 */
public class HstrixTest extends HystrixCommand<String> {
    private final String name;

    protected HstrixTest(String name) {
//        super(HystrixCommandGroupKey.Factory.asKey("cafeGroup"));
        super(HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionIsolationStrategy(
                                        HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE

                                )
                )
        );
//     super(HystrixCommand.Setter.withGroupKey(
//             HystrixCommandGroupKey.Factory.asKey("MyGroup"))
//             .andCommandPropertiesDefaults(
//            HystrixCommandProperties.Setter().withExecutionIsolationStrategy(
//            HystrixCommandProperties.ExecutionIsolationStrategy.THREAD
//            )).andThreadPoolPropertiesDefaults(
//            HystrixThreadPoolProperties.Setter()
//		               .withCoreSize(10)
//		 	       .withMaxQueueSize(100)
//		       	       .withMaximumSize(100)
//		         )
//                         );
        this.name = name;
    }


    @Override
    protected String run() throws Exception {
        try {
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name + " " + Thread.currentThread().getName();

    }

    @Override
    protected String getFallback() {
        return "failed";
    }
}
