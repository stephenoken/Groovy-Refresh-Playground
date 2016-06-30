package com

/**
 * Created by stephenokennedy on 28/06/2016.
 */

class Square implements Shape{

    @Override
    void draw() {
        println("Drawing Square")
    }
}

class Circle implements Shape{

    @Override
    void draw() {
        println("Drawing Circle")
    }
}



Shape s1 = new Square()
Shape s2 = new Circle()

s1.draw()
s2.draw()