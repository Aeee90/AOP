package aocp.mix.storage

import aocp.mix.Mix
import aocp.mix.data.Command
import aocp.mix.display.Display
import aocp.mix.display.StorageDisplay
import aocp.mix.interpretor.Observer

@ExperimentalUnsignedTypes
class StorageManager: Observer<Command> {

    val storage = Storage()
    private val storageDisplay: Display

    init {
        initMemory()

        storageDisplay = StorageDisplay(storage)
        storageDisplay.init()
    }

    private fun initMemory(){
        storage.memory[1].load(0, 5, ubyteArrayOf(1.toUByte(),0.toUByte(),80.toUByte(),3.toUByte(),5.toUByte(),4.toUByte()))
    }

    override fun notify(data: Command) {
        when(data.idx){
            Command.LDA ->{
                storage.rA.load(data.getF() / data.getC(), data.getF() % data.getC(), storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LDX ->{
                storage.rX.load(data.getF() / data.getC(), data.getF() % data.getC(), storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD1 ->{
                storage.rI1.load(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD2 ->{
                storage.rI2.load(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD3 ->{
                storage.rI3.load(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD4 ->{
                storage.rI4.load(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD5 ->{
                storage.rI5.load(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD6 ->{
                storage.rI6.load(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LDAN ->{
                storage.rA.load(data.getF() / data.getC(), data.getF() % data.getC(), storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LDXN ->{
                storage.rX.load(data.getF() / data.getC(), data.getF() % data.getC(), storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD1N ->{
                storage.rI1.loadN(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD2N ->{
                storage.rI2.loadN(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD3N ->{
                storage.rI3.loadN(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD4N ->{
                storage.rI4.loadN(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD5N ->{
                storage.rI5.loadN(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            Command.LD6N ->{
                storage.rI6.loadN(4, 5, storage.memory[data.getADDRESS() + data.getI()].getData())
            }
            else -> error("Not defined Command.")
        }

        storageDisplay.render()
    }
}