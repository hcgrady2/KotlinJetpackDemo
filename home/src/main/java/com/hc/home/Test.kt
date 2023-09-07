package com.hc.home

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

/**
 * @Author: wanghaichao
 * @Date: 2023/8/17
 * @Description:
 * @Copyright: all rights reserved.
 */
class Test {
    fun main() = runBlocking {
        val flow1 = flowOf("a")
        val flow2 = flowOf(1)

        flow1.zip(flow2) { a, b ->
            a + b.toString()
        }.collect { result ->
            println("Result: $result")
        }
    }
}