import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()){

    val (x, y) = readln().split(" ").map{ it.toInt() }
    val data = readln().split(" ").map { it.toInt() }
    val multiTab = HashSet<Int>()
    var ans = 0
    loop@ for (i in 0 until y){
        if(multiTab.size<x){
            multiTab.add(data[i])
            continue
        }
        if(data[i] !in multiTab){
            var index = 0
            val next = data.slice(i+1..data.lastIndex)
            for (item in multiTab){
                if(item !in next){
                    multiTab.remove(item)
                    multiTab.add(data[i])
                    ans++
                    continue@loop
                }
                index = max(index,next.indexOf(item))
            }
            multiTab.remove(next[index])
            multiTab.add(data[i])
            ans++
        }
    }
    println(ans)
}