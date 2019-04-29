package aocp.mix.storage

@ExperimentalUnsignedTypes
class Disk(size: Int) {

    companion object {
        private val PLUS = 1.toUByte()
        private val MINUS = 0.toUByte()
    }

    private val section: UByteArray = UByteArray(size) { 0.toUByte() }

    fun load(from: Int, to:Int, data: UByteArray){
        for(i in from..to) section[i] = data[i]
    }

    fun load(idx: Int, data: UByteArray){
        load(idx, idx, data)
    }

    fun loadN(from: Int, to:Int, data: UByteArray){
        load(from, to, data)
        section[0] = if(section[0] == PLUS) MINUS else PLUS
    }

    fun loadN(idx: Int, data: UByteArray){
        loadN(idx, idx, data)
    }

    fun getData() = section.copyOf()

    override fun toString(): String {
        val sb = StringBuffer("")
        for(i in 1 until section.size) sb.append(", ").append(section[i])
        return "[${if(section[0] == PLUS) "+" else "-"}$sb]"
    }
}