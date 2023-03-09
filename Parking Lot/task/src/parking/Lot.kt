package parking

class Lot(n: Int) {

    private val lot: MutableList<Car?> = MutableList(n) {null}

    fun park(car: Car) {
        var parked = false
        for (i in lot.indices) {
            if (lot[i] == null) {
                lot[i] = car
                println("${car.color} car parked in spot ${i + 1}.")
                parked = true
                break
            }
        }
        if (!parked) println("Sorry, the parking lot is full.")
    }

    fun leave(n: Int) {
        if (lot[n - 1] == null) {
            println("There is no car in spot $n.")
        } else {
            lot[n - 1] = null
            println("Spot $n is free.")
        }
    }

    fun status() {
        if (lot.count { it == null } == lot.size) {
            println("Parking lot is empty.")
        } else {
            for (i in lot.indices) {
                if (lot[i] != null) println("${i + 1} ${lot[i]?.number} ${lot[i]?.color}")
            }
        }
    }

    fun regByColor(color: String) {
        val list = lot.filter { it?.color?.lowercase() == color.lowercase() }.map { it?.number }.toList()
        if (list.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(list.joinToString ( ", " ))
        }
    }

    fun spotByColor(color: String) {
        val list = mutableListOf<Int>()
        lot.indices.forEach{
            if (lot[it]?.color?.lowercase() == color.lowercase()) list.add(it + 1)
        }
        if (list.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(list.joinToString ( ", " ))
        }
    }

    fun spotByReg(reg: String) {
        val spot = lot.indexOfFirst { it?.number == reg }
        println(if (spot == -1) {
            "No cars with registration number $reg were found."
        } else spot + 1)
    }

}