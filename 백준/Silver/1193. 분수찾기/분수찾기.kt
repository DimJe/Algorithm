fun main(){
    var index = readln().toInt()
    cal(index)
}
fun cal(index: Int){
    var index = index
    var line = 1
    var sum = 1
    while (true){
        if(index - line <= 0){
            break
        }
        index -= line
        line += 1
    }
    if(line % 2 ==0){
        println("${index}/${line-index+1}")
    }
    else{
        println("${line-index+1}/${index}")
    }
}