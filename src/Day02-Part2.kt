fun main() {
    var horizontalMovements = 0
    var depthMovements = 0
    var aim = 0
    val inputMeasurements = readInput("Day02-Input")
//    val inputMeasurements = readInput("Day02-Input-Test")
    for (item in inputMeasurements) {
//        println(item)
        val itemSplitted = item.split(" ")
        val direction = itemSplitted[0]
        val unit = Integer.parseInt(itemSplitted[1])

        println("Previous values h,d,a: $horizontalMovements-$depthMovements-$aim, $item")
        if(direction == "forward"){
            horizontalMovements+= unit;
            val depthDelta = aim * unit
            depthMovements += depthDelta
            println("New values h,d,a: $horizontalMovements-$depthMovements-$aim-$depthDelta")
            continue;
        }
        if(direction == "down"){
//            depthMovements += unit;
            aim += unit;
            println("New values h,d,a: $horizontalMovements-$depthMovements-$aim")
            continue;
        }
        if(direction == "up"){
//            depthMovements -= unit;
            aim -= unit;
            println("New values h,d,a: $horizontalMovements-$depthMovements-$aim")
            continue;
        }
    }
    println("horizontal: $horizontalMovements, depth: $depthMovements")
    val sum = horizontalMovements * depthMovements
    println("the end $sum")
}
