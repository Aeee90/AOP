package aocp.mix

import aocp.mix.data.Command
import aocp.mix.interpretor.Interpretor
import aocp.mix.storage.StorageManager

@ExperimentalUnsignedTypes
object Mix: Runnable {

    private lateinit var interpretor: Interpretor

    override fun run() {
        start()
    }

    private fun start(){
        interpretor = Interpretor()
        val storageManager =  StorageManager()
        interpretor.attach(storageManager)

        storageManager.storage.rA.load(0, 5, ubyteArrayOf(0.toUByte(),0.toUByte(),0.toUByte(),0.toUByte(),10.toUByte(),10.toUByte()))
        storageManager.storage.memory[2000].load(0, 5, ubyteArrayOf(1.toUByte(),0.toUByte(),80.toUByte(),3.toUByte(),5.toUByte(),4.toUByte()))

        storageManager.notify(Command.getCommand("LDA",3, 4, 2000, 0.toUByte()))
        //storageManager.notify(Command.getCommand("LDA",0, 5, 2000, 0.toUByte()))
    }
}