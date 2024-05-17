import kotlin.math.abs

val bw = System.`out`.bufferedWriter()


fun main() = with(System.`in`.bufferedReader()) {

    val n = readln().toInt()
    val arr = arrayListOf<Pair<Int,Int>>()
    var ans = 0
    for (i in 0 until n){
        val (x,y) = readln().split(" ").map { it.toInt() }
        arr.add(x to y)
    }
    arr.sortBy { it.first }
    var start = arr.first().first
    var end = arr.first().second
    for(i in 1 until arr.size){
        if (arr[i].first <= end){
            if(end < arr[i].second) end = arr[i].second
        }
        else{

            ans += if (start < 0 && end >= 0){
                end + abs(start)
            } else {
                end - start
            }
            start = arr[i].first
            end = arr[i].second
        }
    }
    ans += if (start < 0 && end >= 0){
        end + abs(start)
    } else {
        end - start
    }
    println(ans)
}
