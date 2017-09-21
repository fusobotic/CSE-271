/**
 * 
 */

/**
 * @author Kristofferson
 *
 */
public class Doge {
	private String name;
	private String breed;
	private int age;
	private int size;
	private boolean sitting;
	private boolean walking;
	private boolean running;
	
	public Doge(){
		//initialize the instance variables here:
		
	}
	

	public void sit(){ sitting = true; }
	public void stand(){ sitting = false; }
	public void walk(){ 
		walking = true; 
		running = false;
	}
	public void run(){ }
	public void stop(){}
	public void bark(){}
	
	
	@Override
	public String toString() {
		return "Doge [name=" + name + ", breed=" + breed + ", age=" + age + ", size=" + size + "]";
	}
	
	
	
	
}
