package com.ToxicBakey.apps.kotlin

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

























/**
 * Simple method showing method bodies can be skipped when the method can be written without needing multiple lines of
 * body.
 *
 * @param number to be doubled and then incremented by 1
 */
fun doubleAndAddOne(number: Int) = number * 2 + 1

























/**
 * Simple reuse of a method skipping the body.
 *
 * @param number to be doubled and then incremented by 1
 */
fun doubleAndAddOne(number: NumberObject) = doubleAndAddOne(number.value)

























/**
 * Simple reuse of a method skipping the body.
 *
 * @param number to be doubled and then incremented by 1
 */
fun addOne(number: NumberObject) = number + NumberObject(1)

























/**
 * Like switch, when allows you to handle multiple possibilities and results. Unlike switch, when allows you to skip
 * defining explicit returns.
 *
 * @param value to determine the returned value
 */
fun demoWhen(value: Int): Int = when (value) {
    0 -> 1
    1 -> 2
    2 -> 3
    3 -> 4
    else -> throw Exception("Unhandled value")
}

























/**
 * Demonstration of adding an extension to a class that would otherwise be unmodifiable.
 */
fun Int.tripleAndAddOne(): Int = this * 3 + 1

























/**
 * Basic lambda demonstration returning the first character of an array of strings as a new string. Empty values are
 * ignored to show filtering.
 *
 * @param strings array of strings to be condensed to a single string
 */
fun firstLetterOfEachElementAsString(strings: Array<String>): String = strings
        .filter(String::isNotEmpty)
        .map { it[0] }
        .joinToString("")

























/**
 * Parallel map implementation demonstrating how extension functions can be used to solve complicated problems
 * generically.
 *
 * @param numThreads the number of threads to use
 * @param exec the executor to be used for processing work
 * @param transform the function to run on each item
 */
fun <T, R> Iterable<T>.parallelMap(
        numThreads: Int = Runtime.getRuntime().availableProcessors(),
        exec: ExecutorService = Executors.newFixedThreadPool(numThreads),
        transform: (T) -> R): List<R>
        = this.map { exec.submit(java.util.concurrent.Callable { transform(it) }) }
        .toList()
        .map(Future<R>::get)