class LegendaryAction(val prolog: String = "", name: String, text: String) : Action(name, text) {
    override fun toLatex(): String {
        return StringBuilder().apply {
            appendln(prolog)
            appendln(super.toLatex())
        }.toString()
    }
}