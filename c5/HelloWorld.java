public class HelloWorld {
	public static void main (String [] args) {
		System.out.println("Hello World!");
		int sum = 0, k = 0;
		for(int i = 0; i < 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		int[] arr = new int [10];
		for(int i = 0; i < 10; i++) {
			for(; ; k++) {
				if(k%2 == 1){
					break;
				}
			}
			arr[i] = k;
			k++;
		}
		for(int x:arr) {
			System.out.println(x);
		}
	
	}
	
}
