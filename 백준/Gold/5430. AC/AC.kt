

val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()){

    val n = readln().toInt()

    for (i in 1..n){
        val str = readln()
        val size = readln().toInt()
        val regex = Regex("[0-9]+")
        val inputString = readln()
        val numbers = regex.findAll(inputString).map { it.value.toInt() }.toList()
        var type = true
        var error = false
        val dq = ArrayDeque<Int>()
        numbers.forEach {
            dq.add(it)
        }
        for (it in str) {
            if(it == 'R'){
                type = !type
            }
            else{
                if(dq.isEmpty()){
                    bw.write("error\n")
                    error = true
                    break
                }
                if(type){
                    dq.removeFirst()
                }
                else{
                    dq.removeLast()
                }
            }
        }
        if(!error){
            if(type){
                bw.write(dq.joinToString(",","[","]"))
            }
            else{
                dq.reverse()
                bw.write(dq.joinToString(",","[","]"))
            }
            bw.write("\n")
        }
    }
    bw.flush()
}