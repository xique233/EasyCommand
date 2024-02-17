package life.magpies.registry.commands

object ModCommands {
    fun registerCommands() {
        CommandWeather.register()
        CommandKit.register()
        CommandThis.register()
        CommandDay.register()
        CommandTpa.register()
        CommandTpAccept.register()
        CommandList.register()
    }
}