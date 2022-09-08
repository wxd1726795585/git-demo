package com.example;

/*
 * 多态性应用举例
 */
public class AnimalTest {
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		Dog d=(Dog)animal;
		d.a();

	}

	public void func(Animal animal){	//Animal animal = new Dog();
		animal.eat();
		animal.shout();
	}
	
	//如果没有多态性，就会写很多如下的方法，去调用
	public void func(Dog dog){
		dog.eat();
		dog.shout();
	}
	
	public void func(Cat cat){
		cat.eat();
		cat.shout();
	}


}

class Animal{
	
	public void eat(){
		System.out.println("动物，进食");
	}
	
	public void shout(){
		System.out.println("动物：叫");
	}
}

class Dog extends Animal{
	@Override
	public void eat(){
		System.out.println("狗吃骨头");
	}
	
	@Override
	public void shout() {
		System.out.println("汪！汪！汪！");
	}public void a(){};
}

class Cat extends Animal{
	public void a(){};
	@Override
	public void eat(){
		System.out.println("猫吃鱼");
	}
	
	@Override
	public void shout() {
		System.out.println("喵！喵！喵！");
	}
}
