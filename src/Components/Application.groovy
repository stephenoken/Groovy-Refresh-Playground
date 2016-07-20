package Components

/**
 * Created by stephenokennedy on 20/07/2016.
 */
class  RobotDog implements Barker, Driver{
    private def state
    RobotDog(state){
        this.state = state
    }
}

def dog1 = new RobotDog(["name":"Sniffles","speed":120.0]);
println(dog1.bark())
println(dog1.drive())
