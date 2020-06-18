package com.whj.springbootcode.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;


public class OptionalTest {
    @Test
    public void testOptional() throws Exception {
        //构建空的Optional对象：
        Optional<String> empty = Optional.empty();
//        empty.get(); //报错
//        Optional<String> t1 = Optional.of(null);//报错，参数不能为空
        Optional<String> t2 = Optional.ofNullable(null); //不报错，允许传空值


        //使用Optional对象
//        String s = t2.get(); //t2如果是null,那么get的时候就会报错 ，机制不错! 比空指针异常这种潜在性错误要好很多！！！！！
        boolean x = t2.isPresent();//返回一个boolean值，t2不为空则返回true
        System.out.println(x);
        t2.ifPresent(t->System.out.println(123));//t2如果不为空就会执行里面的函数

        Optional<String> t3 = Optional.ofNullable("a");
        t3.ifPresent(t->System.out.println(123456));//t3如果不为空就会执行里面的函数
        t3.ifPresent(t->System.out.println(t));//参数t其实就是t3中包裹的"a"
        t3.ifPresent(System.out::println);//想打印参数t也可以这样写

        //orElse
        String s = t3.orElse("默认值");//t2如果为null,那么s就是"默认值",否则s就是t2的值
        System.out.println(s);

        //orElseThrow
//        t2.orElseThrow(()->
//            new Exception("t2现在是空值")
//        );

        /**
         * 注意：Optional对象的调用方法中，如果方法的参数是consumer或supplier或runnable,function,predicate ，
         * 那么方法的参数一定是一个lambda表达式，就是箭头函数
         * 有返回值就是supplier
         * 没有返回值就是consumer
         * 既无输入又无输出，那么就是runnable
         * 既有输入又有输出，那么就是function
         * 返回值是boolean值，那么就是predicate
         */
        //java可以借鉴Optional的思想，来写回调函数
        //看下面就知道了
//        t2.orElseGet(()->{ //supplier
//            return "12";
//        });
//        t2.ifPresent((t)->{ //consumer
//
//        });
//        t3.flatMap((t)->{//function  参数t就是字符串"a"
//            return Optional.ofNullable("a");
//        });
//        t3.filter((t)->{//predicate  参数t就是字符串"a"
//            return false;
//        });



        //Option的链式调用：
        Optional<String> str = t3.map(t->t+"b"); //返回的是Option类型
        String str2 = t3.map(t->t+"b").orElse("c");
        System.out.println(str2);

        
    }
}
