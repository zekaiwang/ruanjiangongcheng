package fulijisuanqi01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class fulijisuanqi01 {
	static Scanner scanner = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("####0.0000");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("1.�������㣻");
		System.out.println("2.�������㣻");
		System.out.println("3.������㣻");
		System.out.println("4.���޼��㡣");
		System.out.println("��ѡ��");
		int k = scanner.nextInt();
		switch (k) {
		case 1:
			fulijisuan();
			break;
		case 2:
			danlijisuan();
			break;
		case 3:
			benjinjisuan();
			break;
		case 4:
			nianxianjisuan();
		default:
			break;
		}
	}

	private static void nianxianjisuan() {
		// TODO Auto-generated method stub
		System.out.println("�����ǣ�");
		double P = scanner.nextDouble();
		System.out.println("�����ǣ�");
		double i = scanner.nextDouble();
		System.out.println("������ֵ�ǣ�");
		double F = scanner.nextDouble();
		int n = (int) (Math.log(F / P) / Math.log(1 + i));
		System.out.println("�����ǣ�" + n);
	}

	private static void benjinjisuan() {
		// TODO Auto-generated method stub
		System.out.println("������ֵ�ǣ�");
		double F = scanner.nextDouble();
		System.out.println("�����ǣ�");
		double i = scanner.nextDouble();
		System.out.println("�����ǣ�");
		int n = scanner.nextInt();
		double P;
		P = F / Math.pow(1 + i, n);
		String p = df.format(P);
		System.out.println("�����ǣ�" + p);
	}

	private static void danlijisuan() {
		// TODO Auto-generated method stub
		System.out.println("�����ǣ�");
		double P = scanner.nextDouble();
		System.out.println("�����ǣ�");
		double i = scanner.nextDouble();
		System.out.println("�����ǣ�");
		int n = scanner.nextInt();
		double F;
		F = P * (1 + i * n);
		String f = df.format(F);
		System.out.println("������ֵ�ǣ�" + f);
	}

	private static void fulijisuan() {
		System.out.println("�����ǣ�");
		double P = scanner.nextDouble();
		System.out.println("�����ǣ�");
		double i = scanner.nextDouble();
		System.out.println("�����ǣ�");
		int n = scanner.nextInt();
		double F;
		F = P * Math.pow(1 + i, n);
		String f = df.format(F);
		System.out.println("������ֵ�ǣ�" + f);
	}

}
