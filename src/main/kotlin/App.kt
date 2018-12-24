import com.beust.klaxon.Klaxon

fun main(args: Array<String>) {
    val abilities = listOf(Action("Amphibious", "The FooBar can breath air and water."))

    val actions = listOf(
        meleeAttackAction("Bite", "+15", "15ft.", "2d10 + 6", "piercing", "one target", "1d8", "acid"),
        rangedAttackAction("Heavy Crossbow", "+2", "100/400 ft", "1d10", "piercing")
    )
    val monster = Monster(abilities = abilities, actions = actions)
    println(monster.toLatex())

    val json = Klaxon().toJsonString(monster)
    println(json)

    val deserialized = Klaxon().parse<Monster>(json)

    println(deserialized)
}