import java.util.LinkedList

val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {

    var str = ""
    val q = LinkedList<String>()
    val m = HashMap<String,Int>()
    val dx = listOf(0,1,0,-1)
    val dy = listOf(1,0,-1,0)
    repeat(3){
        readLine().split(" ").map {
            str = str.plus(it)
        }
    }
    m[str] = 0
    q.offer(str)
    while(q.isNotEmpty()){
        val now = q.poll()!!
        val zeroIndex = now.indexOf("0")
        val x = zeroIndex % 3
        val y = zeroIndex / 3
        for (i in 0..3){
            val nx = x + dx[i]
            val ny = y + dy[i]
            if(nx in 0..2 && ny in 0..2){
                val nextIndex = ny.times(3) + nx
                val temp = now[nextIndex]
                var newStr = now
                newStr = newStr.replace('0','*')
                newStr = newStr.replace(now[nextIndex],'0')
                newStr = newStr.replace('*',now[nextIndex])
                if(!m.containsKey(newStr)){
                    m[newStr] = m[now]!!+1
                    q.offer(newStr)
                }
            }
        }
    }
    if(m.containsKey("123456780")){
        println(m["123456780"])
    }
    else println(-1)
}
