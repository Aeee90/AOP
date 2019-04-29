package mix

import aocp.mix.data.Command
import org.junit.Test

@ExperimentalUnsignedTypes
class CommandTest {

    @Test
    fun makeCommand(){

        val c = Command.getCommand("LDA",0, 0, 3, 2000, 2.toUByte())

        assert(true) {
            c.toString() == "8 2000, 2(11)"
        }

        assert(true){
            Command.getCommand("LDA",0, 1, 3, 2000, 2.toUByte()) == Command.getCommand("LDA",0, 1, 3, 2000, 2.toUByte())
        }
    }
}