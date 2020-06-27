package com.cxytiandi.hystrix_native_demo.mydemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;

/**
 * Author:cafe3165
 * Date:2020-05-24
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        String res=new HstrixTest("cafe").execute();
        Future<String> fres=new HstrixTest("cafe").queue();
        System.out.println(fres.get());
    }
}
