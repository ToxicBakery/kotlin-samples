package com.ToxicBakey.apps.kotlin

























data class NumberObject(
        val value: Int
) {




































    operator fun plus(other: NumberObject): NumberObject = NumberObject(value + other.value)

}