package PDF29.Problema2

data class Person(var name: String, var age: Int) {
    override fun toString(): String {
        return "Se llama $name y tiene $age años"
    }
}
