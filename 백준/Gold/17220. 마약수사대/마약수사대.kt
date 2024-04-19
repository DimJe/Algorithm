val bw = System.`out`.bufferedWriter()
lateinit var graph : Array<BooleanArray>
lateinit var visited : BooleanArray
var ans = 0
fun main() = with(System.`in`.bufferedReader()){

    val (n,m) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { BooleanArray(n) { false } }
    visited = BooleanArray(n) { false }
    val startNode = BooleanArray(n){ true }
    for(i in 0 until m){
        val (x,y) = readln().split(" ")
        graph[x.first()-'A'][y.first()-'A'] = true
        startNode[y.first()-'A'] = false
    }
    val delete = readln().split(" ").drop(1)

    delete.forEach {
        visited[it.first()-'A'] = true
    }
    startNode.forEachIndexed { index, b ->
        if(b && !visited[index]){
            visited[index] = true
            dfs(index)
        }
    }
    bw.write("$ans")
    bw.flush()
    bw.close()
}
fun dfs(node: Int){

    for (i in 0 until graph[node].size){
        if(graph[node][i] && !visited[i]){
            visited[i] = true
            ans++
            dfs(i)
        }
    }
}