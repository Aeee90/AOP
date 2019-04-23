package aocp.mix.interpretor

interface Observer<D> {
    fun notify(data: D)
}