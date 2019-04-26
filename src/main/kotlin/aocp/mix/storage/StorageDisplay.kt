package aocp.mix.storage

import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.WindowConstants

class StorageDisplay(private val storage: Storage) {

    fun init(){
        JFrame("Hello, !").apply {
            defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            layout = GridLayout(4, 2)
            add(JLabel("Hello, world!"))
            add(JButton("Press me!"))
            pack()
            isVisible = true
        }
    }

    fun render(){
    }
}