class Monster(
    val name: String = "Foobar",
    val size: String = "Medium",
    val type: String = "humanoid (any race)",
    val alignment: String = "any alignment",
    val armorClass: String = "10",
    val hitPoints: String = "1d6",
    val speed: String = "30 ft",
    val strength: Int = 10,
    val dexterity: Int = 10,
    val constitution: Int = 10,
    val intelligence: Int = 10,
    val wisdom: Int = 10,
    val charisma: Int = 10,
    val skills: String = "",
    val senses: String = "passive Perception 10",
    val languages: String = "any one language (usually Common)",
    val challenge: String = "1/4",
    val abilities: List<String> = listOf(), // TODO: new "Ability" class
    val actions: List<String> = listOf(),
    val legendaryActions: List<String> = listOf()
) {
    fun toLatex(): String {
        // TODO: I think a Stringbuilder would be cleaner here...
        val latex = StringBuilder().apply {
            appendln("""\begin{monsterboxnobg}{$name}""")
            appendln("""\begin{hangingpar}""")
            appendln("""\textit{$size $type, $alignment}""")
            appendln("""\end{hangingpar}""")
            appendln("""\dndline""")
            appendln("""\basics[armorclass=$armorClass,hitpoints=\dice{$hitPoints},speed=$speed]""")
            appendln("""\dndline""")
            appendln("""\stats[""")
            appendln("""STR=\stat{$strength},""")
            appendln("""DEX=\stat{$dexterity},""")
            appendln("""CON=\stat{$constitution},""")
            appendln("""INT=\stat{$intelligence},""")
            appendln("""WIS=\stat{$wisdom},""")
            appendln("""CHA=\stat{$charisma}""")
            appendln("""]""")
            appendln("""\dndline""")
            appendln("""\details[""")
            appendln("""skills={$skills},""")
            appendln("""senses={$senses},""")
            appendln("""languages={$languages},""")
            appendln("""challenge=$challenge""")
            appendln("""]""")
            if(abilities.isNotEmpty()) {
                appendln("""\dndline""")
                abilities.forEach {
                    appendln("""\begin{monsteraction}[TODO]""")
                    appendln(it)
                    appendln("""\end{monsteraction}""")
                }
            }
            if(actions.isNotEmpty()) {
                appendln("""\dndline""")
                appendln("""\monstersection{Actions}""")
                actions.forEach {
                    appendln("""\begin{monsteraction}[TODO]""")
                    appendln(it)
                    appendln("""\end{monsteraction}""")
                }
            }
            if(legendaryActions.isNotEmpty()) {
                appendln("""\dndline""")
                appendln("""\monstersection{Legendary Actions}""")
                actions.forEach {
                    appendln("""\begin{monsteraction}[TODO]""")
                    appendln(it)
                    appendln("""\end{monsteraction}""")
                }
            }
            appendln("""\end{monsterboxnobg}""")
        }.toString()
        return latex
    }
}