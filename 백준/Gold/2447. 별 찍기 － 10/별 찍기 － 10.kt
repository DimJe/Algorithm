val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()){
    val n = readln().toInt()

    for(i in 0 until n){
        for (j in 0 until n){
            printStar(i,j,n)
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}
fun printStar(i: Int,j:Int,num: Int){

    if(num == 1) bw.write("*")
    else if((i/(num/3)) % 3 == 1 && (j/(num/3)) % 3 == 1) bw.write(" ")
    else printStar(i,j,num/3)
}