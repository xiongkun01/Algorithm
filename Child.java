class Person {

	private String name = "Person";
	int age = 0;

}

class Chinese{
		private static Chinese objref =new Chinese();
		private Chinese(){}
		public static Chinese getInstance() { return objref; }
}

interface IAction {
	void fly();
}

class ActionImpl implements IAction {
	
	public void fly() {}

}

public class Child extends Person {
	public String grade;

	public static void add(Byte b) {
		b = b ++;
	}

	
	
	/**
	public static synchronized void main(String[] a){
         Thread t = new Thread(){
             public void run(){ 
				 Sogou();
			}
		 };
		 t.run();
		 System.out.print("Hello");
     }

    static synchronized void Sogou(){
		System.out.print("Sogou");
    }*/

	public static void main(String[] args){
		Chinese obj1 = Chinese.getInstance();
		Chinese obj2 = Chinese.getInstance();
		System.out.println(obj1 == obj2); //true

		System.out.println("is" + 100 + 5); //is1005
		System.out.println(100 + 5 + "is"); //105is
		System.out.println("is "+ (100 + 5));//is105
	}

	/**
	public static void main(String[] args) {
		//Person p = new Child();

		
		Byte a = 127;
		Byte b = 127;

		add(++a);
		System.out.println(a + " ");
		add(b);
		System.out.println(b + " ");
		

		Object a = true;
		System.out.println(a);
	}*/
	

}
