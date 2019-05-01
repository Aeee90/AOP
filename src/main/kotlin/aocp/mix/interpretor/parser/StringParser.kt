package aocp.mix.interpretor.parser

import aocp.mix.data.Command
import aocp.mix.util.Util
import kotlin.math.absoluteValue

@ExperimentalUnsignedTypes
class StringParser: Parser<Command> {

    companion object{
        private const val SPACING = ' '
        private const val REST  = ','
        private const val BRACKET_LEFT = '('
        private const val BRACKET_RIGHT = ')'
        private const val COLON = ':'
    }

    //OP ADDRESS, I(F)
    private var str: String = ""

    fun setStr(str: String){
        this.str = str.toUpperCase()
    }

    fun parser(str: String): Command {
        setStr(str)
        return parse()
    }

    //tokenize
    override fun parse(): Command {
        val str = this.str
        if(str.isEmpty()) {
            Util.error("Set String using interpreter(str: String) method")
            return Command.EMPTY_COMMNAD
        }
        else{
            var op = ""
            var s = 0
            var address = -1
            var i = 0
            var l = 0
            var r = 8
            val sb = StringBuilder("")
            for(c in str){
                when(c){
                    SPACING -> {
                        op = sb.toString()
                        sb.setLength(0)
                    }
                    REST -> {
                        address = sb.toString().toInt()
                        s = if(address < 0) -1 else 1
                        sb.setLength(0)
                    }
                    BRACKET_LEFT -> {
                        if(address < 0) {
                            address = sb.toString().toInt()
                            s = if(address < 0) -1 else 1
                        }
                        else i = sb.toString().toInt()
                        sb.setLength(0)
                    }
                    BRACKET_RIGHT -> {
                        val F = sb.toString()
                        if(COLON in F){
                            val fs = F.split(COLON)
                            l = fs[0].toInt()
                            r = fs[1].toInt()
                        }else{
                            l = F.toInt()
                            r = F.toInt()
                        }
                        sb.setLength(0)
                    }
                    else ->{
                        sb.append(c)
                    }
                }
            }

            if(s == 0){
                address = sb.toString().toInt()
                s = if(address < 0) -1 else 1
                sb.setLength(0)
            }

            return Command.getCommand(op, s, l, r, address.absoluteValue, i.toUByte())
        }
    }
}