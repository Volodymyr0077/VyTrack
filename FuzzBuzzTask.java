public class{
	public static void main(String[] args) {
		for(int i=1;i<=15;i++){
			if(i%3==0){
				System.out.println("Fuzz")
				continue;
			}
			else if(i%5==0){
				System.out.println("Buzz")
				continue;
			}
			System.out.println(i);
		}
	}
}