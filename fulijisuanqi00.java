package fulijisuanqi00;

import java.text.DecimalFormat;
import java.util.Scanner;
public class fulijisuanqi00 {
	public static void main(String[] args) {
		double F;
		DecimalFormat df = new DecimalFormat("####0.00");
		Scanner scanner = new Scanner(System.in);
		System.out.println("����");
		double P = scanner.nextDouble();
		System.out.println("�����ʣ�");
		double k = scanner.nextDouble();
		System.out.println("�洢���ޣ�");
		int n = scanner.nextInt();
		double i = k/100;
		F = P * Math.pow(1+i, n);
		String f = df.format(F);
		System.out.println("������ֵ��"+f);
	}

}
