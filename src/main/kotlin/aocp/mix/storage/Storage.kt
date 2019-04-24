package aocp.mix.storage

@ExperimentalUnsignedTypes
class Storage {

    val rA = Disk(6)
    val rX = Disk(6)

    val rI1 = Disk(3)
    val rI2 = Disk(3)
    val rI3 = Disk(3)
    val rI4 = Disk(3)
    val rI5 = Disk(3)
    val rI6 = Disk(3)
    val rJ = Disk(2)

    val memory = Array<Disk>(4000) { Disk(6) }
}