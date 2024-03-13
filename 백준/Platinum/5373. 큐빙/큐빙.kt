import java.util.StringTokenizer

fun main(){

    val UP = arrayOf(
        arrayOf("w","w","w"),
        arrayOf("w","w","w"),
        arrayOf("w","w","w")
    )
    val DOWN = arrayOf(
        arrayOf("y","y","y"),
        arrayOf("y","y","y"),
        arrayOf("y","y","y")
    )
    val FRONT = arrayOf(
        arrayOf("r","r","r"),
        arrayOf("r","r","r"),
        arrayOf("r","r","r")
    )
    val BACK = arrayOf(
        arrayOf("o","o","o"),
        arrayOf("o","o","o"),
        arrayOf("o","o","o")
    )
    val LEFT = arrayOf(
        arrayOf("g","g","g"),
        arrayOf("g","g","g"),
        arrayOf("g","g","g")
    )
    val RIGHT = arrayOf(
        arrayOf("b","b","b"),
        arrayOf("b","b","b"),
        arrayOf("b","b","b")
    )

    val index = readln().toInt()
    for (i in 1..index){
        val count = readln().toInt()
        val rotate = ArrayList<String>()
        val st = StringTokenizer(readln())
        while (st.hasMoreTokens()){
            val token = st.nextToken()
            rotate.add(token)
        }
        var tempU = Array(UP.size){idx -> UP[idx].copyOf()}
        var tempD = Array(DOWN.size){idx -> DOWN[idx].copyOf()}
        var tempF = Array(FRONT.size){idx -> FRONT[idx].copyOf()}
        var tempB = Array(BACK.size){idx -> BACK[idx].copyOf()}
        var tempL = Array(LEFT.size){idx -> LEFT[idx].copyOf()}
        var tempR = Array(RIGHT.size){idx -> RIGHT[idx].copyOf()}
        rotate.forEach {
            when(it.first()){
                'U' -> {
                    tempU = rotation(tempU,it.last())
                    if(it.last() == '-'){
                        var tempArray1 = tempL[0]
                        var tempArray2 = tempF[0]
                        tempL[0] = tempB[0] // b->l
                        tempF[0] = tempArray1 // l->f
                        tempArray1 = tempR[0]
                        tempR[0] = tempArray2 // f->r
                        tempB[0] = tempArray1
                    }
                    else {
                        var tempArray1 = tempB[0]
                        var tempArray2 = tempR[0]
                        tempB[0] = tempL[0]   //l->b
                        tempR[0] = tempArray1 //b->r
                        tempArray1 = tempF[0]
                        tempF[0] = tempArray2 // r->f
                        tempL[0] = tempArray1 // f->l
                    }
                }
                'D' -> {
                    if(it.last() == '-'){
                        tempD = rotation(tempD,'+')
                        var tempArray1 = tempB[2]
                        var tempArray2 = tempR[2]
                        tempB[2] = tempL[2] // l->b
                        tempR[2] = tempArray1 //b->r
                        tempArray1 = tempF[2]
                        tempF[2] = tempArray2 //r->f
                        tempL[2] = tempArray1 //f->l
                    }
                    else {
                        tempD = rotation(tempD,'-')
                        var tempArray1 = tempL[2]
                        var tempArray2 = tempF[2]
                        tempL[2] = tempB[2]  //b->l
                        tempF[2] = tempArray1 //l->f
                        tempArray1 = tempR[2]
                        tempR[2] = tempArray2  //f->r
                        tempB[2] = tempArray1

                    }
                }
                'F' -> {
                    tempF = rotation(tempF,it.last())
                    if(it.last() == '-'){
                        var tempArray1 = arrayOf(tempL[0][2],tempL[1][2],tempL[2][2])
                        var tempArray2 = arrayOf(tempD[2][0],tempD[2][1],tempD[2][2])
                        tempL[0][2] = tempU[2][2] //u->l
                        tempL[1][2] = tempU[2][1]
                        tempL[2][2] = tempU[2][0]
                        tempD[2][0] = tempArray1[0] //l->d
                        tempD[2][1] = tempArray1[1]
                        tempD[2][2] = tempArray1[2]
                        tempArray1 = arrayOf(tempR[0][0],tempR[1][0],tempR[2][0])
                        tempR[0][0] = tempArray2[2] // d->r
                        tempR[1][0] = tempArray2[1]
                        tempR[2][0] = tempArray2[0]
                        tempU[2][2] = tempArray1[2] // r->u
                        tempU[2][1] = tempArray1[1]
                        tempU[2][0] = tempArray1[0]
                    }
                    else {
                        var tempArray1 = arrayOf(tempU[2][0],tempU[2][1],tempU[2][2])
                        var tempArray2 = arrayOf(tempR[0][0],tempR[1][0],tempR[2][0])
                        tempU[2][0] = tempL[2][2] // l->u
                        tempU[2][1] = tempL[1][2]
                        tempU[2][2] = tempL[0][2]
                        tempR[0][0] = tempArray1[0] // u->r
                        tempR[1][0] = tempArray1[1]
                        tempR[2][0] = tempArray1[2]
                        tempArray1 = arrayOf(tempD[2][0],tempD[2][1],tempD[2][2])
                        tempD[2][0] = tempArray2[2]
                        tempD[2][1] = tempArray2[1]
                        tempD[2][2] = tempArray2[0]
                        tempL[2][2] = tempArray1[2]
                        tempL[1][2] = tempArray1[1]
                        tempL[0][2] = tempArray1[0]
                    }
                }
                'B' -> {
                    tempB = rotation(tempB,it.last())
                    if(it.last() == '-'){
                        var tempArray1 = arrayOf(tempU[0][0],tempU[0][1],tempU[0][2])
                        var tempArray2 = arrayOf(tempR[0][2],tempR[1][2],tempR[2][2])
                        tempU[0][0] = tempL[2][0] //l->u
                        tempU[0][1] = tempL[1][0]
                        tempU[0][2] = tempL[0][0]
                        tempR[0][2] = tempArray1[0] //i->r
                        tempR[1][2] = tempArray1[1]
                        tempR[2][2] = tempArray1[2]
                        tempArray1 = arrayOf(tempD[0][0],tempD[0][1],tempD[0][2])
                        tempD[0][0] = tempArray2[2] //r->d
                        tempD[0][1] = tempArray2[1]
                        tempD[0][2] = tempArray2[0]
                        tempL[2][0] = tempArray1[2] //d->l
                        tempL[1][0] = tempArray1[1]
                        tempL[0][0] = tempArray1[0]
                    }
                    else {
                        var tempArray1 = arrayOf(tempL[0][0],tempL[1][0],tempL[2][0])
                        var tempArray2 = arrayOf(tempD[0][0],tempD[0][1],tempD[0][2])
                        tempL[0][0] = tempU[0][2] //u->l
                        tempL[1][0] = tempU[0][1]
                        tempL[2][0] = tempU[0][0]
                        tempD[0][0] = tempArray1[0] //l->d
                        tempD[0][1] = tempArray1[1]
                        tempD[0][2] = tempArray1[2]
                        tempArray1 = arrayOf(tempR[0][2],tempR[1][2],tempR[2][2])
                        tempR[0][2] = tempArray2[2] // d->r
                        tempR[1][2] = tempArray2[1]
                        tempR[2][2] = tempArray2[0]
                        tempU[0][2] = tempArray1[2] //r->u
                        tempU[0][1] = tempArray1[1]
                        tempU[0][0] = tempArray1[0]
                    }
                }
                'L' -> {
                    tempL = rotation(tempL,it.last())
                    if(it.last() == '-'){
                        var tempArray1 = arrayOf(tempB[0][2],tempB[1][2],tempB[2][2])
                        var tempArray2 = arrayOf(tempD[0][0],tempD[1][0],tempD[2][0])
                        tempB[0][2] = tempU[2][0] //u->b
                        tempB[1][2] = tempU[1][0]
                        tempB[2][2] = tempU[0][0]
                        tempD[0][0] = tempArray1[0] //b->d
                        tempD[1][0] = tempArray1[1]
                        tempD[2][0] = tempArray1[2]
                        tempArray1 = arrayOf(tempF[0][0],tempF[1][0],tempF[2][0])
                        tempF[0][0] = tempArray2[2] //d->f
                        tempF[1][0] = tempArray2[1]
                        tempF[2][0] = tempArray2[0]
                        tempU[0][0] = tempArray1[0]
                        tempU[1][0] = tempArray1[1]
                        tempU[2][0] = tempArray1[2]
                    }
                    else {
                        var tempArray1 = arrayOf(tempF[0][0],tempF[1][0],tempF[2][0])
                        var tempArray2 = arrayOf(tempD[0][0],tempD[1][0],tempD[2][0])
                        tempF[0][0] = tempU[0][0] //u->f
                        tempF[1][0] = tempU[1][0]
                        tempF[2][0] = tempU[2][0]
                        tempD[0][0] = tempArray1[2] //f->d
                        tempD[1][0] = tempArray1[1]
                        tempD[2][0] = tempArray1[0]
                        tempArray1 = arrayOf(tempB[0][2],tempB[1][2],tempB[2][2])
                        tempB[0][2] = tempArray2[0] // d->b
                        tempB[1][2] = tempArray2[1]
                        tempB[2][2] = tempArray2[2]
                        tempU[0][0] = tempArray1[2] // d->u
                        tempU[1][0] = tempArray1[1]
                        tempU[2][0] = tempArray1[0]
                    }
                }
                'R' -> {
                    tempR = rotation(tempR,it.last())
                    if(it.last() == '-'){
                        var tempArray1 = arrayOf(tempF[0][2],tempF[1][2],tempF[2][2])
                        var tempArray2 = arrayOf(tempD[0][2],tempD[1][2],tempD[2][2])
                        tempF[0][2] = tempU[0][2] //u->f
                        tempF[1][2] = tempU[1][2]
                        tempF[2][2] = tempU[2][2]
                        tempD[0][2] = tempArray1[2] //f->d
                        tempD[1][2] = tempArray1[1]
                        tempD[2][2] = tempArray1[0]
                        tempArray1 = arrayOf(tempB[0][0],tempB[1][0],tempB[2][0])
                        tempB[0][0] = tempArray2[0] //d->b
                        tempB[1][0] = tempArray2[1]
                        tempB[2][0] = tempArray2[2]
                        tempU[0][2] = tempArray1[2] //b->u
                        tempU[1][2] = tempArray1[1]
                        tempU[2][2] = tempArray1[0]

                    }
                    else {
                        var tempArray1 = arrayOf(tempB[0][0],tempB[1][0],tempB[2][0])
                        var tempArray2 = arrayOf(tempD[0][2],tempD[1][2],tempD[2][2])
                        tempB[0][0] = tempU[2][2] //u->b
                        tempB[1][0] = tempU[1][2]
                        tempB[2][0] = tempU[0][2]
                        tempD[0][2] = tempArray1[0] //b->d
                        tempD[1][2] = tempArray1[1]
                        tempD[2][2] = tempArray1[2]
                        tempArray1 = arrayOf(tempF[0][2],tempF[1][2],tempF[2][2])
                        tempF[0][2] = tempArray2[2] //d->f
                        tempF[1][2] = tempArray2[1]
                        tempF[2][2] = tempArray2[0]
                        tempU[2][2] = tempArray1[2] //f->u
                        tempU[1][2] = tempArray1[1]
                        tempU[0][2] = tempArray1[0]
                    }
                }
            }
        }
        printArray(tempU)
    }
}
fun rotation(array: Array<Array<String>>,type: Char) : Array<Array<String>>{

    val rotationArray = Array(3){Array<String>(3){""} }

    if(type == '-'){
        for (row in 0..2){
            for(col in 0..2){
                rotationArray[col][row] = array[row][3-1-col]
            }
        }
    }
    else{
        for (row in 0..2){
            for(col in 0..2){
                rotationArray[col][row] = array[3-1-row][col]
            }
        }
    }
    return rotationArray
}
fun printArray(array: Array<Array<String>>){

    for (j in 0..2){
        for (k in 0..2){
            print(array[j][k])
        }
        println()
    }
}