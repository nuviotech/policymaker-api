package HelperClasses;

import java.util.Random;

public class Helper {
	static Random random =new Random(99999);
	public static int getRandomNumber() {
		int num=random.nextInt();
		if(num<0)
			num=-num;
		return num;
	}
}
