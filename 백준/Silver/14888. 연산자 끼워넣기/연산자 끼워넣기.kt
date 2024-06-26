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
    //dfsMax(1,arr[0])
    //dfsMin(1,arr[0])

    println("$max\n$min")
}
fun dfs(index: Int,sum: Int){

    if(index == n){
        min = min(min,sum)
        max = max(max,sum)
        return
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
fun dfsMax(index: Int,sum: Int){

    if(index == n){
        max = max(max,sum)
        return
    }
    if(cal[0] == 0 && cal[2]==0 && index < n){
        return
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
fun dfsMin(index: Int,sum: Int){

    if(index == n){
        min = min(min,sum)
        return
    }
    if(cal[1] == 0 && cal[3]==0 && index < n){
        return
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