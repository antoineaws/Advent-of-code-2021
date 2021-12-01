fun main() {
    var numberOfTimesIncreased = 0
    var previousMeasurement = -1
    val inputMeasurements = readInput("Day01-Input")
    for (item in inputMeasurements) {
        if(previousMeasurement == -1){
            previousMeasurement = Integer.parseInt(item)
            continue
        }
        if(Integer.parseInt(item) <= previousMeasurement){
            previousMeasurement = Integer.parseInt(item)
            continue
        }

        previousMeasurement = Integer.parseInt(item)
        numberOfTimesIncreased += 1

    }
    println("the end" + numberOfTimesIncreased)
}
