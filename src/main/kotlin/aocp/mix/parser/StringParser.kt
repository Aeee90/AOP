package aocp.mix.parser

import aocp.mix.data.Command

class StringParser: Parser<Command> {

    //OP ADDRESS, I(F)
    var str: String = ""

    fun parser(str: String): Command {
        this.str =  str
        return parse()
    }

    override fun parse(): Command {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }
}