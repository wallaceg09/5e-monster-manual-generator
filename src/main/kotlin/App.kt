import com.beust.klaxon.Klaxon

fun main(args: Array<String>) {
    val abilities = listOf(Action("Amphibious", "The FooBar can breath air and water."))
    val actions = listOf(Action("Bite", """\emph{Melee Weapon Attack}: +15 to hit, reach 15ft., one target.\newline
        |\emph{Hit}: \dice{2d10 + 6} piercing damage plus \dice{1d8} acid damage.""".trimMargin()))
    val monster = Monster(abilities = abilities, actions = actions)
    println(monster.toLatex())
//    val json = Klaxon().toJsonString(Monster())
//    println(json)
}