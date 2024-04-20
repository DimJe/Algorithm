import java.util.Stack

val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()){

    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val look = Array(n) { arrayOf(0,-100000) }
    var st = Stack<Int>()

    arr.forEachIndexed { index, i ->
        while (!st.empty() && arr[st.peek()] <= i) st.pop()
        look[index][0] = st.size
        if(look[index][0] > 0) look[index][1] = st.peek()
        st.push(index)
    }

    st = Stack<Int>()
    for (index in arr.size-1 downTo  0){
        while (!st.empty() && arr[st.peek()] <= arr[index]) st.pop()
        val size = st.size
        look[index][0] += size
        if(size > 0) {
            if(index - look[index][1] > st.peek() - index) look[index][1] = st.peek()
        }
        st.push(index)
    }
    look.forEach {
        if(it[0] == 0){
            bw.write("0\n")
        }
        else bw.write("${it[0]} ${it[1]+1}\n")
    }
    bw.flush()
    bw.close()
}