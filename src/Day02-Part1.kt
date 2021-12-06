fun main() {
    var horizontalMovements = 0
    var depthMovements = 0
    val inputMeasurements = readInput("Day02-Input")
//    val inputMeasurements = readInput("Day02-Input-Test")
    for (item in inputMeasurements) {
//        println(item)
        val itemSplitted = item.split(" ")
        val direction = itemSplitted[0]
        val unit = Integer.parseInt(itemSplitted[1])

        if(direction == "forward"){
            horizontalMovements+= unit;
            continue;
        }
        if(direction == "down"){
            depthMovements += unit;
            continue;
        }
        if(direction == "up"){
            depthMovements -= unit;
            continue;
        }
        println("$item: $direction-$unit?")
    }
    val sum = horizontalMovements * depthMovements
    println("the end $sum")
}
