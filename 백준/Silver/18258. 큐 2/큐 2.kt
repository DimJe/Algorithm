import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()){
    val bw = System.`out`.bufferedWriter()
    val n = readln().toInt()
    val deque : Queue<Int> = LinkedList()
    for (i in 1..n){
        val str = readln()
        when(str){
            "pop" -> {
                if(deque.isEmpty()) bw.appendLine("-1")
                else bw.appendLine("${deque.remove()}")
            }
            "size" -> {
                bw.appendLine("${deque.size}")
            }
            "empty" -> {
                if(deque.isEmpty()) bw.appendLine("1")
                else bw.appendLine("0")
            }
            "front" -> {
                if(deque.isEmpty()) bw.appendLine("-1")
                else bw.appendLine("${deque.element()}")
            }
            "back" -> {
                if(deque.isEmpty()) bw.appendLine("-1")
                else bw.appendLine("${deque.last()}")
            }
            else -> {
                val (_,num) = str.split(" ")
                deque.add(num.toInt())
            }
        }

    }
    bw.flush()
    bw.close()
}