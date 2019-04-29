package aocp.mix.display

import aocp.mix.storage.Storage
import java.awt.*
import javax.swing.*
import javax.swing.table.DefaultTableCellRenderer

@ExperimentalUnsignedTypes
class StorageDisplay(private val storage: Storage): Display {

    private lateinit var rA: JTable
    private lateinit var rX: JTable
    private var rI: Array<JTable?> = Array(6) { null }
    private lateinit var rJ: JTable
    private lateinit var memory: JTable

    override fun init(){
        JFrame("MIX").apply {
            defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            layout = GridBagLayout()
            val c = GridBagConstraints().apply {
                fill = GridBagConstraints.BOTH
                weightx = 1.0
                weighty = 1.0
            }

            c.gridx = 0
            c.gridy = 0
            c.gridwidth = 1
            add(JPanel().apply {
                layout = GridBagLayout()
                val c = GridBagConstraints().apply {
                    fill = GridBagConstraints.BOTH
                    weightx = 1.0
                    weighty = 1.0
                }

                //Register A
                c.gridx = 0
                c.gridy = 0
                c.gridwidth = 1
                add(JLabel("Register A: ", SwingConstants.LEFT), c)
                c.gridx = 1
                c.gridy = 0
                c.gridwidth = 6

                rA = JTable(arrayOf(arrayOf("+", "0", "0", "0", "0", "0")), arrayOf("±", "A1", "A2", "A3", "A4", "A5")).apply {
                    (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                }
                add(rA, c)

                c.gridx = 7
                c.gridy = 0
                c.gridwidth = 1
                add(JLabel(" ").apply { preferredSize = Dimension(50, 20) }, c)

                //Register X
                c.gridx = 8
                c.gridy = 0
                c.gridwidth = 1
                add(JLabel("Register X: ", SwingConstants.LEFT), c)
                c.gridx = 9
                c.gridy = 0
                c.gridwidth = 6
                rX = JTable(arrayOf(arrayOf("+", "0", "0", "0", "0", "0")), arrayOf("±", "X1", "X2", "X3", "X4", "X5")).apply {
                    (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                }
                add(rX, c)
            }, c)

            c.gridx = 0
            c.gridy = 1
            c.gridwidth = 1
            c.gridheight = 6
            add(JPanel().apply {
                layout = GridBagLayout()
                val c = GridBagConstraints().apply {
                    fill = GridBagConstraints.BOTH
                    weightx = 1.0
                    weighty = 1.0
                }
                c.gridx = 0
                c.gridy = 0
                c.gridwidth = 1
                c.gridheight = 6
                add(JPanel().apply {
                    layout = GridLayout(6, 2)
                    preferredSize = Dimension(150, 100)

                    for(i in 0..4) {
                        add(JLabel("Register I${i+1}: "))

                        rI[i] = JTable(arrayOf(arrayOf("+", "0", "0")), arrayOf("±", "i4", "i5")).apply {
                            (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                        }
                        add(rI[i])
                    }

                    add(JLabel("Register J: "))

                    rJ = JTable(arrayOf(arrayOf("", "0", "0")), arrayOf("", "J4", "J5")).apply {
                        (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                    }
                    add(rJ)
                }, c)

                c.gridx = 2
                c.gridy = 0
                c.gridwidth = 1
                c.gridheight = 6
                add(JLabel(" ").apply { preferredSize = Dimension(150, 20) }, c)

                c.gridx = 3
                c.gridy = 0
                c.gridwidth = 11
                c.gridheight = 6

                memory = JTable(
                    Array(4000) { i -> arrayOf("M$i", "0", "0", "0", "0", "0", "0") }
                    , arrayOf("Index", "M0", "M1", "M2", "M3", "M4", "M5")
                ).apply {
                    (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                }
                add(JScrollPane(memory), c)

                c.gridx = 14
                c.gridy = 0
                c.gridwidth = 1
                c.gridheight = 6
                add(JLabel(" ").apply { preferredSize = Dimension(150, 20) }, c)

            }, c)

            pack()
            isVisible = true
        }
    }

    override fun render(){
        val sRA = storage.rA.getData()
        for(i in 0 until rA.columnCount) rA.setValueAt( sRA[i].toString(), 0, i)

        val sRX = storage.rX.getData()
        for(i in 0 until rX.columnCount) rX.setValueAt( sRX[i].toString(), 0, i)

        val sRI1 = storage.rI1.getData()
        val rI1 = rI[0]!!
        for(i in 0 until rI1.columnCount) rI1.setValueAt( sRI1[i].toString(), 0, i)

        val sRI2 = storage.rI2.getData()
        val rI2 = rI[1]!!
        for(i in 0 until rI2.columnCount) rI2.setValueAt( sRI2[i].toString(), 0, i)

        val sRI3 = storage.rI3.getData()
        val rI3 = rI[2]!!
        for(i in 0 until rI3.columnCount) rI3.setValueAt( sRI3[i].toString(), 0, i)

        val sRI4 = storage.rI4.getData()
        val rI4 = rI[3]!!
        for(i in 0 until rI4.columnCount) rI4.setValueAt( sRI4[i].toString(), 0, i)

        val sRI5 = storage.rI5.getData()
        val rI5 = rI[4]!!
        for(i in 0 until rI5.columnCount) rI5.setValueAt( sRI5[i].toString(), 0, i)

        val sRJ = storage.rJ.getData()
        for(i in 1 until rJ.columnCount) rJ.setValueAt(sRJ[i-1].toString(), 0, i)

        val sMemory = storage.memory
        for(i in 0 until memory.rowCount){
            val sm = sMemory[i].getData()
            for(j in 1 until memory.columnCount){
                memory.setValueAt(sm[j-1].toString(), i, j)
            }
        }
    }
}