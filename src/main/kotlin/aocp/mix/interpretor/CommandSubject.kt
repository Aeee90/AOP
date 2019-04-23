package aocp.mix.interpretor

import aocp.mix.data.Command

class CommandSubject: Subject<Observer<Command>, Command> {

    override val observers: ArrayList<Observer<Command>> = ArrayList()

    override fun attach(observer: Observer<Command>) {
        observers.add(observer)
    }

    override fun detach(observer: Observer<Command>) {
        observers.remove(observer)
    }

    override fun notify(data: Command) {
        observers.forEach { observer -> observer.notify(data) }
    }
}