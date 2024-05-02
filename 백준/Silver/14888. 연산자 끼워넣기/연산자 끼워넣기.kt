import kotlin.math.max
import kotlin.math.min

var min = 1000000000
var max = -1000000000
var n = 0
lateinit var arr: List<Int>
lateinit var cal: MutableList<Int>
fun main() = with(System.`in`.bufferedReader()){

    n = readln().toInt()
    arr = readln().split(" ").map { it.toInt() }
    cal = readln().split(" ").map { it.toInt() }.toMutableList()

    dfs(1,arr[0])

    println("$max\n$min")
}
fun dfs(index: Int,sum: Int){

    if(index == n){
        min = min(min,sum)
        max = max(max,sum)
    }
    for (i in 0..3){
        if(cal[i] != 0){
            cal[i]--
            when(i){
                0 -> dfs(index + 1,sum + arr[index])
                1 -> dfs(index + 1,sum - arr[index])
                2 -> dfs(index + 1,sum * arr[index])
                3 -> dfs(index + 1,sum / arr[index])
            }
            cal[i]++
        }
    }
}