data class Action(val name: String, val text: String) {
    fun toLatex(): String {
        return StringBuilder().apply {
            appendln("""\begin{monsteraction}[$name]""")
            appendln(text)
            appendln("""\end{monsteraction}""")
        }.toString()
    }
}

fun meleeAttackAction(
    name: String,
    toHit: String,
    reach: String,
    damage: String,
    damageType: String,
    target: String = "",
    bonusDamage: String = "",
    bonusDamageType: String = ""
): Action {
    val text = StringBuilder().apply {
        append("""\textit{Melee Weapon Attack}:""")
        append("$toHit to hit")
        append(", reach $reach")
        if (target.isNotBlank()) append(", $target")
        append(""".""")

        append("""\textit{Hit}: \dice{$damage} $damageType damage""")
        if (bonusDamage.isNotBlank() and bonusDamageType.isNotBlank())
            append(""" plus \dice{$bonusDamage} $bonusDamageType damage""")
        appendln(".")
    }.toString()

    return Action(name, text)
}

fun rangedAttackAction(
    name: String,
    toHit: String,
    range: String,
    damage: String,
    damageType: String,
    target: String = "",
    bonusDamage: String = "",
    bonusDamageType: String = ""
): Action {
    val text = StringBuilder().apply {
        append("""\textit{Ranged Weapon Attack}:""")
        append("$toHit to hit")
        append(", range $range")
        if (target.isNotBlank()) append(", $target")
        append(""".""")

        append("""\textit{Hit}: \dice{$damage} $damageType damage""")
        if (bonusDamage.isNotBlank() and bonusDamageType.isNotBlank())
            append(""" plus \dice{$bonusDamage} $bonusDamageType damage""")
        appendln(".")
    }.toString()

    return Action(name, text)
}