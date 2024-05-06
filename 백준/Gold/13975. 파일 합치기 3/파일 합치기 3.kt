import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()){

    val n = readln().toInt()
    for (i in 1..n){
        val size = readln().toInt()
        val pq = PriorityQueue<Long>()
        readln().split(" ").map {
            pq.offer(it.toLong())
        }
        var cost = 0L
        while (pq.size != 1){
            val x = pq.poll()
            val y = pq.poll()
            cost += x+y
            pq.offer(x+y)
        }
        println(cost)
    }

}