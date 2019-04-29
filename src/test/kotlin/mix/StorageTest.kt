package mix

import aocp.mix.data.Command
import aocp.mix.storage.StorageManager
import org.junit.Test

@ExperimentalUnsignedTypes
class StorageTest {

    private val storageManager = StorageManager()

    @Test
    fun ldaCommandTest(){

        storageManager.storage.rA.load(0, 5, ubyteArrayOf(0.toUByte(),0.toUByte(),0.toUByte(),0.toUByte(),10.toUByte(),10.toUByte()))
        println(storageManager.storage.rA)

        storageManager.storage.memory[2000].load(0, 5, ubyteArrayOf(1.toUByte(),0.toUByte(),80.toUByte(),3.toUByte(),5.toUByte(),4.toUByte()))
        println(storageManager.storage.memory[2000])

        storageManager.notify(Command.getCommand("LDA",0, 3, 4, 2000, 0.toUByte()))
        println(storageManager.storage.rA)

        storageManager.notify(Command.getCommand("LDA",0, 0, 5, 2000, 0.toUByte()))
        println(storageManager.storage.rA)
    }
}