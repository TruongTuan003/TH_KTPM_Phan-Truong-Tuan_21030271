package fit.singleton.pattern;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class main {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException  {
		//chạy early initialization singleton
		System.out.println("Early initialization singleton:");
		//g�?i thực hiện hàm EagerInitializedSingleton
		EagerInitializedSingleton instance = EagerInitializedSingleton.getInstance();
		System.out.println(instance.hashCode());
		
		//chạy lần 2
		EagerInitializedSingleton instance2 = EagerInitializedSingleton.getInstance();
		System.out.println(instance2.hashCode());
		
		//chạy static block initialization singleton
		System.out.println("\n Static block initialization:");
		//g�?i thực hiện hàm StaticBlockSingleton
		StaticBlockSingleton instance3 = StaticBlockSingleton.getInstance();
		System.out.println(instance3.hashCode());
		
		//chạy lần 2
		StaticBlockSingleton instance4 = StaticBlockSingleton.getInstance();
		System.out.println(instance4.hashCode());
		
		
//		System.out.println("\n Lazy initialization:");
//		new Thread(() -> {
//			// g�?i thực hiện hàm LazyInitializedSingleton
//			LazyInitializedSingleton instance5 = LazyInitializedSingleton.getInstance();
//			System.out.println(instance5.hashCode());
//		}).start();
//		
//		
//		new Thread(() -> {
//			// g�?i thực hiện hàm LazyInitializedSingleton
//			LazyInitializedSingleton instance5 = LazyInitializedSingleton.getInstance();
//			System.out.println(instance5.hashCode());
//		}).start();
		
		
//		System.out.println("\n Thread safe initialization:");
//		new Thread(() -> {
//			// g�?i thực hiện hàm ThreadSafeSingleton
//			ThreadSafeSingleton instance6 = ThreadSafeSingleton.getInstance();
//			System.out.println(instance6.hashCode());
//		}).start();
//		
//		new	Thread(() -> {
//            // g�?i thực hiện hàm ThreadSafeSingleton
//            ThreadSafeSingleton instance6 = ThreadSafeSingleton.getInstance();
//            System.out.println(instance6.hashCode());
//            }).start();
		
		System.out.println("\n Bill Pugh Singleton implementation:");
		//g�?i thực hiện hàm BillPughSingleton
		BillPughSingleton instance7 = BillPughSingleton.getInstance();
		System.out.println(instance7.hashCode());
		
		//chạy lần 2
		BillPughSingleton instance8 = BillPughSingleton.getInstance();
		System.out.println(instance8.hashCode());
		
		//reflection
		System.out.println("\n Reflection Singleton Test:");	
		ReflectionSingletonTest.main(args);
		

		

			 
			 
		
		
		

		
		
	}

}
