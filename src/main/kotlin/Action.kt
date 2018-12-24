open class Action(val name: String, val text: String) {
    open fun toLatex(): String {
        return StringBuilder().apply {
            appendln("""\begin{monsteraction}[$name]""")
            appendln(text)
            appendln("""\end{monsteraction}""")
        }.toString()
    }
}