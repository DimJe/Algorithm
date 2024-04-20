import java.util.PriorityQueue

val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()){

    val n = readln().toInt()
    var ans = 0
    val room = MutableList(n) { 0 }
    var roomInfo = mutableListOf<Triple<Int,Int,Int>>()
    val pq = PriorityQueue<Pair<Int,Int>> { a, b ->
        if(a.first == b.first){
            a.second - b.second
        }
        else a.first - b.first
    }
    for(i in 0 until n){
        val (x,y,z) = readln().split(" ").map { it.toInt() }
        roomInfo.add((Triple(x,y,z)))
    }
    roomInfo = roomInfo.sortedWith(compareBy ({it.second},{it.third} )).toMutableList()
    roomInfo.forEach {
        if(pq.isEmpty()){
            ans++
            room[it.first-1] = ans
            pq.offer(Pair(it.third,it.first))
        }
        else{
            if(pq.peek()!!.first <= it.second){
                room[it.first-1] = room[pq.poll()!!.second-1]
                pq.offer(Pair(it.third,it.first))
            }
            else{
                ans++
                room[it.first-1] = ans
                pq.offer(Pair(it.third,it.first))
            }
        }
    }
    bw.write("${pq.size}\n")
    room.forEach {
        bw.write("$it\n")
    }
    bw.flush()
    bw.close()
}