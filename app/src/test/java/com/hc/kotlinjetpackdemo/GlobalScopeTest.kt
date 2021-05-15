package com.hc.kotlinjetpackdemo

import kotlinx.coroutines.*
import org.junit.Test
import kotlin.system.measureTimeMillis

/**
 * Created by hcw  on 2021/3/5
 * 类描述：
 * all rights reserved
 */
class GlobalScopeTest  {

@Test
fun testTtCoroutines(){
    testLaunch();
}


    //异步、步阻塞线程
    private fun testLaunch(){

        var time:Long = measureTimeMillis {
            GlobalScope.launch {
                Thread.sleep(1000);
                println("test ,${Thread.currentThread() },fine");
            }


            GlobalScope.launch {
                Thread.sleep(1000);
                println("testLaunche,${Thread.currentThread() },hhh");
            }

            println("hello,${Thread.currentThread()}");


            Thread.sleep(2200)
        }

        println("函数耗时，$time");

    }



    //异步，不阻塞
    private fun testAsync(){

        var time:Long = measureTimeMillis {
            GlobalScope.async {
                Thread.sleep(1000);
                println("test ,${Thread.currentThread() },fine");
            }


            GlobalScope.async {
                Thread.sleep(1000);
                println("testLaunche,${Thread.currentThread() },hhh");
            }

            println("hello,${Thread.currentThread()}");


            Thread.sleep(2200)
        }

        println("函数耗时，$time");



    }


    //会阻塞,按照代码顺序执行，包括 runBlocking 外面
    private fun testRunBlacking(){


        val time:Long = measureTimeMillis {

            runBlocking {
                //顺序执行，会阻塞
            }

            println("这里是不会先执行的");
        }

    }



    private fun testCancelJob() = runBlocking {
        val time:Long = measureTimeMillis {
            val L1:Job = launch {
                println("");
            }


            val L12:Job = launch {

            }


            var a1:Deferred<Unit> = async {
                repeat(20){
                    delay(200)
                }
            }

            val a2:Deferred<Unit> = async {
                L1.cancel();

            }


        }


    }



    private fun testTimeOut(){

//        withTimeout(200){
//
//        }

    }


    private fun testAwait() = runBlocking {

//        val time: Long = measureTimeMillis {
//            val a2:Deferred<Int> = async {
//                delay(3000)
//                println("test")
//            }
//
//            a2.await()
//        }


    }

}