fun main() = with(System.`in`.bufferedReader()){

    val n = readln().toInt()
    for (i in 1..n){
        var speak = readln().split(" ")
        while (true){
            val str = readln()
            if(str == "what does the fox say?") {
                val ans = speak.filter { it != "" }
                println(ans.joinToString(" "))
                break
            }
            else{
                val strList = str.split(" ")
                speak = speak.map {
                    if(it == strList[2]){
                        ""
                    }
                    else it
                }
            }
        }
    }
}