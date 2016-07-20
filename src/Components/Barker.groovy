package Components

/**
 * Created by stephenokennedy on 20/07/2016.
 */
trait Barker {
    def bark(){
        return "Woof, I am ${this.state.name}"
    }
}
