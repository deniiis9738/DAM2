package PDF31.Problema2

fun main() {
    val dice = object {
        val array = IntArray(5)

        fun generate() {
            for (i in array.indices) {
                array[i] = ((Math.random() * 6) + 1).toInt()
            }
        }

        fun showDice() {
            for (element in array) {
                println("$element")
            }
            println()
        }

        fun greater(): Int {
            var bigger = array[0]

            for (i in array.toString()) {
                if (array[i.code] > bigger) {
                    bigger = array[i.code]
                }
            }
            return bigger
        }
    }
}