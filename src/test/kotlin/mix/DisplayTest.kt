package mix

import org.junit.Test
import java.awt.FlowLayout
import javax.swing.*


class DisplayTest {

    @Test
    fun display(){
        SwingUtilities.invokeLater {
            JFrame("Hello, !").apply {
                defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
                layout = FlowLayout()
                add(JLabel("Hello, world!"))
                add(JButton("Press me!"))
                pack()
                isVisible = true
            }
        }
    }
}