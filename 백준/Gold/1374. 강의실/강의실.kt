import java.util.PriorityQueue

val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()){

    val n = readln().toInt()
    var roomInfo = mutableListOf<Pair<Int,Int>>()
    val pq = PriorityQueue<Int>()
    for(i in 0 until n){
        val (x,y,z) = readln().split(" ").map { it.toInt() }
        roomInfo.add((Pair(y,z)))
    }
    roomInfo = roomInfo.sortedWith(compareBy ({it.first},{it.second} )).toMutableList()
    roomInfo.forEach {
        if(pq.isEmpty()){
            pq.offer(it.second)
        }
        else{
            if(pq.peek()!! <= it.first){
                pq.poll()
                pq.offer(it.second)
            }
            else{
                pq.offer(it.second)
            }
        }
    }
    bw.write("${pq.size}")
    bw.flush()
    bw.close()
}