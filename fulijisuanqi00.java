package fulijisuanqi00;

import java.text.DecimalFormat;
import java.util.Scanner;
public class fulijisuanqi00 {
	public static void main(String[] args) {
		double F;
		DecimalFormat df = new DecimalFormat("####0.00");
		Scanner scanner = new Scanner(System.in);
		System.out.println("本金：");
		double P = scanner.nextDouble();
		System.out.println("年利率：");
		double k = scanner.nextDouble();
		System.out.println("存储年限：");
		int n = scanner.nextInt();
		double i = k/100;
		F = P * Math.pow(1+i, n);
		String f = df.format(F);
		System.out.println("复利终值："+f);
	}

}
