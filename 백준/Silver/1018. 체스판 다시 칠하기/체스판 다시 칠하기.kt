import kotlin.math.min
fun main(){
    val (n,m) = readln().split(' ').map { it.toInt() }
    val board = arrayListOf<String>()
    var ans = n.times(m)
    for (i in 1..n){
        board.add(readln())
    }
    for (i in 0..n-8){
        for (j in 0..m-8){
            val temp = min(cal2(i,j,board),cal(i,j,board))
            ans = min(ans, temp)
        }
    }
    println(ans)

}
fun cal(x:Int,y:Int,board:ArrayList<String>): Int {
    var count = 0
    var firstChar = 'B'
    for (i in x..x+7){
        var index = 1
        for (j in y..y+7){
            if(index % 2 != 0){
                if(firstChar != board[i][j]){
                    count++
                }
            }
            else{
                if(firstChar == board[i][j]){
                    count++
                }
            }
            index++
        }
        firstChar = if(firstChar == 'W') 'B' else 'W'
    }
    return count
}
fun cal2(x:Int,y:Int,board:ArrayList<String>): Int {
    var count = 0
    var firstChar = 'W'
    for (i in x..x+7){
        var index = 1
        for (j in y..y+7){
            if(index % 2 != 0){
                if(firstChar != board[i][j]){
                    count++
                }
            }
            else{
                if(firstChar == board[i][j]){
                    count++
                }
            }
            index++
        }
        firstChar = if(firstChar == 'W') 'B' else 'W'
    }
    return count
}