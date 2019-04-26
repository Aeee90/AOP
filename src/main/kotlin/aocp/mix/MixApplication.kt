package aocp.mix

import java.awt.*
import javax.swing.*
import javax.swing.table.DefaultTableCellRenderer
import java.awt.Dimension



fun main(args: Array<String>){
    SwingUtilities.invokeLater {
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
                add(
                    JTable(arrayOf(arrayOf("+", "0", "0", "0", "0", "0")), arrayOf("±", "A1", "A2", "A3", "A4", "A5")).apply {
                        (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                    }, c
                )

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
                add(
                    JTable(arrayOf(arrayOf("+", "0", "0", "0", "0", "0")), arrayOf("±", "X1", "X2", "X3", "X4", "X5")).apply {
                        (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                    }, c
                )
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

                    for(i in 0..4) {
                        add(JLabel("Register I${i+1}: "))

                        add(JTable(arrayOf(arrayOf("+", "0", "0")), arrayOf("±", "i4", "i5")).apply {
                            (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                        })
                    }

                    add(JLabel("Register J: "))

                    add(JTable(arrayOf(arrayOf("", "0", "0")), arrayOf("", "J4", "J5")).apply {
                        (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                    })
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
                add(
                    JTable(
                        Array(7) { i -> arrayOf("M$i", "0", "0", "0", "0", "0", "0") }
                        , arrayOf("M1", "M2", "M3", "M4", "M5", "M6")
                    ).apply {
                        (getDefaultRenderer(String::class.java) as DefaultTableCellRenderer).horizontalAlignment = SwingConstants.CENTER
                    }, c
                )

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
}