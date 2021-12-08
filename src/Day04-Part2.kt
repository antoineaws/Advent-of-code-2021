fun main() {
    fun generateBoard(boardRows:MutableList<String>):Board{
        var board = Board(mutableListOf(),false)
        for (row in boardRows) {
            val rowRawValues = row.split("\\s+".toRegex())
            val rowSquares : MutableList<Square> = mutableListOf()
            for(rowValue in rowRawValues){
                if(rowValue.isEmpty()){
                    continue
                }
                val square = Square(rowValue, false)
                rowSquares.add(square)
            }
            board.squares.add(rowSquares)
        }
        return board
    }
    fun parseBoards(rawBoards:List<String>): List<Board> {
        var boards : MutableList<Board> = mutableListOf<Board>()

        var rows : MutableList<String> = mutableListOf()
        for (row in rawBoards) {
            if(row.isNotEmpty()){
                rows.add(row)
                continue
            }
            val board = generateBoard(rows)
            boards.add(board)
            rows = mutableListOf()
        }
        return boards
    }
    fun checkRowAndColumn(row:Int, column:Int, board:Board):Boolean{
        var isWinner = true
        for(rowTemp in board.squares.indices){
            if(!board.squares[rowTemp][column].drawn){
                isWinner = false
                break
            }
        }
        if(isWinner){
            return true
        }

        isWinner = true
        val rowToInspect = board.squares[row]
        for(column in rowToInspect.indices){
            if(rowToInspect[column].drawn == false){
                isWinner = false
                break
            }
        }
        if(isWinner){
            return true
        }
        return false
    }
    fun markAndCheckHZVTBoards(draw:String, boards: List<Board>):List<Board>{
        var boardsTemp = boards;
        for(board in boardsTemp){
            for(row in board.squares.indices){
                for(column in board.squares[row].indices){
                    if(draw == board.squares[row][column].value){
                        board.squares[row][column].drawn = true
                        val isWinner = checkRowAndColumn(row,column, board)
                        if(isWinner){
                            board.winner = true
                            return boardsTemp
                        }

                    }
                }
            }
        }

        return boardsTemp
    }
    fun findWinnerBoard(boards: List<Board>): Board? {
        for(board in boards){
            if(board.winner){
                return board
            }
        }
        return null
    }
    fun calculateTotalUnmarked(board:Board):Int{
        var sum = 0
        for(row in board.squares.indices) {
            for (column in board.squares[row].indices) {
                if(board.squares[row][column].drawn == false){
                    val draw = Integer.parseInt(board.squares[row][column].value)
                    sum+= draw
                }
            }
        }
        return sum
    }
    val drawsArray = readInput("Day04-Input-Draws")
    val rawBoards = readInput("Day04-Input-Boards")
//    val drawsArray = readInput("Day04-Input-Test-Draws")
//    val rawBoards = readInput("Day04-Input-Test-Boards")

    val drawsParsed = drawsArray[0].split(",")
    var boardsParsed: List<Board> = parseBoards(rawBoards)

    var winnerBoard = Board(mutableListOf(),false)
    var winnerDraw = ""
    for(draw in drawsParsed){
        boardsParsed = markAndCheckHZVTBoards(draw, boardsParsed)
        var winnerBoardTemp = findWinnerBoard(boardsParsed)
        if(winnerBoardTemp?.winner == true){
            winnerBoard = winnerBoardTemp
            winnerDraw = draw
            break;
        }
    }

    val totalUnmarked = calculateTotalUnmarked(winnerBoard)
    val result = totalUnmarked * Integer.parseInt(winnerDraw)
    println("winner board!! $totalUnmarked $winnerDraw")
    println("result $result")
    println("the end $drawsArray $rawBoards $drawsParsed $boardsParsed")
}