package mix

import aocp.mix.data.Command
import org.junit.Test

class CommandTest {

    @Test
    fun makeCommand(){

        val c = Command.getCommnad("LDA",0, 3, 2000, 2.toUByte())

        assert(true) {
            c.toString() == "8 2000, 2(11)"
        }

        assert(true){
            Command.getCommnad("LDA",1, 3, 2000, 2.toUByte()) == Command.getCommnad("LDA",1, 3, 2000, 2.toUByte())
        }
    }
}