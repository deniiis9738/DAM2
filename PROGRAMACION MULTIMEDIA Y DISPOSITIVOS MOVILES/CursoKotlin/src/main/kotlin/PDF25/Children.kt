package PDF25

import java.util.Scanner

class Children(quantChildren: IntArray) {
    var quantChildren = IntArray(5)

    init {
        this.quantChildren = quantChildren
    }

    fun laodYears() {
        var input = Scanner(System.`in`)

        for (i in 0 ..< quantChildren.size) {
            print("Edad: ")
            var age = input.nextInt()
            quantChildren[i] = age
        }
    }

    fun biggerYear(): Int {
        var bigger = quantChildren[0]
        for (i in 1 ..< quantChildren.size) {
            if (quantChildren[i] > bigger) {
                bigger = quantChildren[i]
            }
        }
        return bigger
    }

    fun averageAges(): Float {
        var average = 0f
        for (i in 0 ..< quantChildren.size) {
            average += quantChildren[i]
        }
        return average / quantChildren.size
    }
}