package mix

import aocp.mix.interpretor.parser.StringParser
import org.junit.Test

@ExperimentalUnsignedTypes
class ParserTest{

    @Test
    fun regexTest(){
        val parser = StringParser()

        println(parser.parser("LDA 2000,2(0:3)").toString())
        println(parser.parser("LDA 2000,2(1:3)").toString())
        println(parser.parser("LDA 2000(1:3)").toString())
        println(parser.parser("LDA 2000").toString())
        println(parser.parser("LDO -2000,4").toString())
    }

}


