package aocp.mix.interpretor


@ExperimentalUnsignedTypes
class Interpretor {
    //facade pattern
    private val parser = StringParser()
    private val commandSubject = CommandSubject()

    fun parser(str: String){
        commandSubject.notify(parser.parser(str))
    }

}