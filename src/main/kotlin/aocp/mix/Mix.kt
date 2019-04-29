package aocp.mix

import aocp.mix.data.Command
import aocp.mix.interpretor.Interpreter
import aocp.mix.storage.StorageManager
import java.util.*
import kotlin.concurrent.thread

@ExperimentalUnsignedTypes
object Mix: Runnable {

    private lateinit var interpreter: Interpreter
    private lateinit var storageManager: StorageManager

    override fun run() {
        start()
    }

    private fun start(){
        interpreter = Interpreter()
        storageManager =  StorageManager()

        interpreter.attach(storageManager)

        Thread(Input()).start()
    }

    class Input: Runnable {

        private val scanner = Scanner(System.`in`)

        override fun run() {
            while(true){
                println("명령어를 입력해주세요.")
                interpreter.parser(scanner.nextLine())
            }
        }
    }
}