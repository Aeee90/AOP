package aocp.mix.interpretor

import aocp.mix.data.Command
import aocp.mix.interpretor.parser.StringParser


@ExperimentalUnsignedTypes
class Interpreter {
    //facade pattern
    private val parser = StringParser()
    private val commandSubject = CommandSubject()

    fun parser(str: String){
        commandSubject.notify(parser.parser(str))
    }

    fun attach(observer: Observer<Command>) = commandSubject.attach(observer)
    fun detach(observer: Observer<Command>) = commandSubject.detach(observer)

}