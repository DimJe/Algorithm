import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()){
    val bw = System.`out`.bufferedWriter()
    val n = readln().toInt()
    val type = readln().split(" ").map { it.toInt() }
    val init = readln().split(" ").map { it.toInt() }.toMutableList()
    val m = readln().toInt()
    val input = readln().split(" ").map { it.toInt() }
    val list = init.filterIndexed { index, i ->
        type[index] == 0
    }
    val queue = LinkedList(list)
    input.forEach {
        queue.addFirst(it)
    }
    for (i in 1..m){
        bw.write("${queue.removeLast()} ")
    }
    bw.flush()
    bw.close()
}