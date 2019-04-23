package aocp.mix.interpretor

import aocp.mix.data.Command

@ExperimentalUnsignedTypes
class StringParser: Parser<Command> {

    //OP ADDRESS, I(F)
    private var str: String = ""

    fun setStr(str: String){
        this.str = str
    }

    fun parser(str: String): Command {
        setStr(str)
        return parse()
    }

    override fun parse(): Command {
        val str = this.str
        if(str.isEmpty()) error("Set String using interpretor(str: String) method")
        else{
            var op = ""
            var adress = -1
            var i = 0
            var l = 0
            var r = 0
            for(c in str){

            }

            return Command.getCommnad(op, l, r, adress, i.toUByte())
        }
    }
}