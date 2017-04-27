package com.ToxicBakey.apps.kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class SampleTest {

    @Test
    fun doubleAndAddOne() {
        assertEquals(3, doubleAndAddOne(1))
        assertEquals(5, doubleAndAddOne(2))
        assertEquals(-3, doubleAndAddOne(-2))
    }

























    @Test
    fun doubleAndAddOne2() {
        assertEquals(3, doubleAndAddOne(NumberObject(1)))
        assertEquals(5, doubleAndAddOne(NumberObject(2)))
        assertEquals(-3, doubleAndAddOne(NumberObject(-2)))
    }

























    @Test
    fun addOne() {
        assertEquals(NumberObject(2), addOne(NumberObject(1)))
        assertEquals(NumberObject(3), addOne(NumberObject(2)))
        assertEquals(NumberObject(-1), addOne(NumberObject(-2)))
    }

























    @Test
    fun whenTest() {
        assertEquals(1, demoWhen(0))
        assertEquals(2, demoWhen(1))
        assertEquals(3, demoWhen(2))
        assertEquals(4, demoWhen(3))
    }

























    @Test(expected = Exception::class)
    fun whenTest1() {
        demoWhen(Int.MAX_VALUE)
    }

























    @Test
    fun tripleAndAddOne() {
        assertEquals(1, 0.tripleAndAddOne())
        assertEquals(4, 1.tripleAndAddOne())
        assertEquals(-4, -1.tripleAndAddOne())
        assertEquals(-2, (-1).tripleAndAddOne())
    }

























    @Test
    fun operatorFunctions() {
        assertEquals(NumberObject(3), NumberObject(1) + NumberObject(2))
        assertEquals(NumberObject(-3), NumberObject(-1) + NumberObject(-2))
    }

























    @Test
    fun firstLetterOfEachElementAsStringTest() {
        assertEquals("ABC 123",
                firstLetterOfEachElementAsString(
                        arrayOf("Apple", "Banana", "", "Coconut", " ", "1", "2", "3")))
    }

























    @Test
    fun parallelMapTest() {
        val source = 1..999
        assertEquals(source.map { it * 2 }, source.parallelMap { it * 2 })
        assertEquals(source.map { it * 2 }, source.parallelMap(numThreads = 20, transform = { it * 2 }))

        // How to reuse functions
        val inlineFunction: (Int) -> Int = { it * 2 }
        assertEquals(source.map(transform = inlineFunction), source.parallelMap(transform = inlineFunction))

        // Who needs RX anyways?
        val delayedFunction: (Int) -> Int = {
            Thread.sleep(1) // Sleep to emulate time consuming work
            it * 2
        }
        var time = System.currentTimeMillis()
        val mapLinear = source.map(delayedFunction)
        println("Linear Map Time: ${System.currentTimeMillis() - time}")

        time = System.currentTimeMillis()
        val mapParallel = source.parallelMap(numThreads = 50, transform = delayedFunction)
        println("Parallel Map Time: ${System.currentTimeMillis() - time}")
        assertEquals(mapLinear, mapParallel)
    }

}
