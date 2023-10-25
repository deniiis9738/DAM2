package PDF41.Problema1

class Vector {
    val intArray = IntArray(5) { (Math.random() * 11 + 1).toInt() }

    fun show() {
        for (i in intArray) {
            println(i)
        }
    }

    operator fun plus(vecotr2: Vector): Vector {
        var total = Vector()

        for (i in intArray.indices) {
            total.intArray[i] = intArray[i] + vecotr2.intArray[i]
        }
        return total
    }

    operator fun minus(vecotr2: Vector): Vector {
        var total = Vector()

        for (i in intArray.indices) {
            total.intArray[i] = intArray[i] - vecotr2.intArray[i]
        }
        return total
    }

    operator fun times(vecotr2: Vector): Vector {
        var total = Vector()

        for (i in intArray.indices) {
            total.intArray[i] = intArray[i] * vecotr2.intArray[i]
        }
        return total
    }

    operator fun div(vecotr2: Vector): Vector {
        var total = Vector()

        for (i in intArray.indices) {
            total.intArray[i] = intArray[i] / vecotr2.intArray[i]
        }
        return total
    }
}