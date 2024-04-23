import java.util.LinkedList
import java.util.Queue
import kotlin.math.min


val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()){

    val (n,m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n){List(m){0} }
    for (i in 0 until n){
        graph[i] = readln().split(" ").map { it.toInt() }
    }
    var ans = 100 * 100 * 4
    val nDir = listOf(Pair(0,1),Pair(0,-1),Pair(1,0),Pair(-1,0))
    val turnR = mapOf(0 to 2,1 to 3,2 to 1,3 to 0)
    val turnL = mapOf(0 to 3,1 to 2,2 to 0,3 to 1)
    val visited = Array(n){ Array(m) { BooleanArray(4){ false } } }
    val start = readln().split(" ").map { it.toInt().minus(1) }
    val end = readln().split(" ").map { it.toInt().minus(1) }
    val queue: Queue<Node> = LinkedList()
    queue.offer(Node(start[0],start[1],start[2],0))
    visited[start[0]][start[1]][start[2]] = true
    while(!queue.isEmpty()){
        val node = queue.poll()!!
        if(node.x == end[0] && node.y == end[1] && node.direction == end[2]){
            ans = min(ans,node.count)
        }
        else{
            for (i in 1..3){
                val newX = node.x + nDir[node.direction].first * i
                val newY = node.y + nDir[node.direction].second * i

                if( newX < 0 || newX >= n || newY < 0 || newY >= m) break
                if(graph[newX][newY] == 1) break
                if(!visited[newX][newY][node.direction]){

                    val newNode = Node(newX,newY,node.direction,node.count+1)
                    visited[newX][newY][node.direction] = true
                    queue.offer(newNode)
                }
            }
            if(!visited[node.x][node.y][turnL[node.direction]!!]){
                visited[node.x][node.y][turnL[node.direction]!!] = true
                queue.offer(Node(node.x,node.y,turnL[node.direction]!!,node.count+1))
            }
            if(!visited[node.x][node.y][turnR[node.direction]!!]){
                visited[node.x][node.y][turnR[node.direction]!!] = true
                queue.offer(Node(node.x,node.y,turnR[node.direction]!!,node.count+1))
            }
        }
    }
    bw.write("$ans")
    bw.flush()
    bw.close()
}
data class Node(
    var x : Int,
    var y : Int,
    var direction: Int,
    var count : Int
)