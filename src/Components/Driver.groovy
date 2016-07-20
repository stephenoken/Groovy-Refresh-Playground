package Components

/**
 * Created by stephenokennedy on 20/07/2016.
 */
trait Driver {

    def drive(){
        return "Max speed is ${state.speed} km/h"
    }
}
