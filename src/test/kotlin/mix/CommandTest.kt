package mix

import aocp.mix.data.Command
import org.junit.Test

class CommandTest {

    @Test
    fun makeCommand(){

        val c = Command.LDA(11.toUByte(), 2000, 2.toUByte())

        assert(true) {
            c.toString() == "8 2000, 2(11)"
        }

        assert(true){
            Command.LDA(11.toUByte(), 2000, 2.toUByte()) == Command.LDA(11.toUByte(), 2000, 2.toUByte())
        }
    }
}