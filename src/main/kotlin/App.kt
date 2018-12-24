import com.beust.klaxon.Klaxon

fun main(args: Array<String>) {
    val monster = Monster()
    println(monster.toLatex())
//    val json = Klaxon().toJsonString(Monster())
//    println(json)
}