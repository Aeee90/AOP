package aocp.mix.interpretor

interface Subject<T, D> {

    val observers: ArrayList<T>

    fun attach(observer: T)
    fun detach(observer: T)
    fun notify(data: D)
}