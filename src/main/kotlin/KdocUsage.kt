/**
 * Calculates the sum of two numbers, [a] and [b]
 */

fun sum (a: Int, b: Int) = a + b

/**
 * Adding an Integer [number] to a mutableList and return it
 */

fun addNumberToMList (number: Int): MutableList<Int>{
    val list = mutableListOf<Int>()
    list.add(number)
    return list
}

/**
 * Performs a complicated operation
 *
 * @param remote if true, executes operation remotely
 * @return the result of executing the operator
 * @throws IOException if remote connection fails
 * @sample com.mycompany.SomethingTest.simple
 */

fun somethingComplicated(remote: Boolean): ComplicatedResult {
    return ComplicatedResult()
}

class ComplicatedResult
