package parking

fun main() {

    var lot: Lot? = null

    while (true) {
        val command = readln().split(" ")
        when (command[0]) {
            "create" -> {
                val i = command[1].toInt()
                lot = Lot(i)
                println("Created a parking lot with $i spots.")
            }
            "park" -> {
                lot?.park(Car(command[2], command[1])) ?: println("Sorry, a parking lot has not been created.")
            }
            "leave" -> lot?.leave(command[1].toInt()) ?: println("Sorry, a parking lot has not been created.")
            "status" -> lot?.status() ?: println("Sorry, a parking lot has not been created.")
            "reg_by_color" -> lot?.regByColor(command[1]) ?: println("Sorry, a parking lot has not been created.")
            "spot_by_color" -> lot?.spotByColor(command[1]) ?: println("Sorry, a parking lot has not been created.")
            "spot_by_reg" -> lot?.spotByReg(command[1]) ?: println("Sorry, a parking lot has not been created.")
            "exit" -> break
            else -> println("Error")
        }
    }
}

