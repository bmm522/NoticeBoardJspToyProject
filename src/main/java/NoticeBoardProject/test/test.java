package NoticeBoardProject.test;

import java.util.HashMap;
import java.util.Map;

enum Number {
	  ONE(1),
	  TWO(2),
	  THREE(3);
	 

	    private int number;
//	    private static Map<Object, Object> map = new HashMap<>();

	    Number(int number) {
	        this.number = number;
	    }

//	    static {
//	        for (Number n : Number.values()) {
//	            map.put(n.number, n);
//	        }
//	    }
//
//	    public static Number valueOf(int number) {
//	        return (Number) map.get(number);
//	    }

}


public class test {

	public static void main(String[] args) {
		int putNumber_ = 2;
		String putNumber = Integer.toString(putNumber_);
		
		Number num =Number.valueOf(putNumber);
		
		
				switch(num) {
			case ONE:
				System.out.println("1");
				break;
			case TWO:
				System.out.println("2");
				break;
			case THREE:
				System.out.println("3");
				break;	
		}
		

	}

}
