fun main() {
    fun computeArraySum(array:MutableList<Int>):Int{
        var sum = 0
        for (item in array) {
            sum+= item
        }
        return sum
    }

    var numberOfTimesIncreased = 0
    val activeArray: MutableList<Int> = mutableListOf()
    val measurementsArray : MutableList<Int> = mutableListOf()
    val inputMeasurements = readInput("Day01-Input")

    for (item in inputMeasurements) {
        val newItemParsed = item.toInt()
        activeArray.add(newItemParsed)

        if(activeArray.size < 3){
            continue
        }
        if(activeArray.size == 3){
            val sum = computeArraySum(activeArray)
            measurementsArray.add(sum)
            activeArray.removeAt(0)
        }
    }
    println("measurements array: $measurementsArray")

    var previousMeasurement = -1
    for (item in measurementsArray) {
        if(previousMeasurement == -1){
            previousMeasurement = item
            continue
        }
        if(item <= previousMeasurement){
            previousMeasurement = item
            continue
        }

        previousMeasurement = item
        numberOfTimesIncreased += 1
    }
    println("the end $numberOfTimesIncreased")
}
