package fulijisuanqi03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class fulijisuanqi03 {
     static Scanner scanner = new Scanner(System.in);
        static DecimalFormat df = new DecimalFormat("####0.0000");

        public static void main(String[] args) {
            //TODO Auto-generated method stub

            System.out.println("1.复利计算；");
            System.out.println("2.单利计算；");
            System.out.println("3.本金计算；");
            System.out.println("4.年限计算；");
            System.out.println("5.报酬率计算；");
            System.out.println("6.累计资产总值计算；");
            System.out.println("7.月还款额计算。");
            System.out.println("请选择：");

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
                break;
            case 5:
                baochoulvjisuan();
                break;
            case 6:
                leijizichanjisuan();
                break;
            case 7:
            	yinhangdaikuanjisuan();
            	break;
            default:
                break;
            }
        }

        private static void yinhangdaikuanjisuan() {
			// TODO Auto-generated method stub
            System.out.println("请输入贷款金额：");
            double P = scanner.nextDouble();
            System.out.println("请输入年利率：");
            double i = scanner.nextDouble();
            System.out.println("请输入还款期限：");
            int n = scanner.nextInt();
            double F = P * (i/12) * Math.pow( 1 + i/12 ,12 * n)/(Math.pow(1 + i/12, 12 * n)-1);
            String f = df.format(F);
            System.out.println("月还款额："+f);
		}

		private static void leijizichanjisuan() {
            // TODO Auto-generated method stub
            System.out.println("请输入本金：");
            double P = scanner.nextDouble();
            System.out.println("请输入每年的投资金额：");
            double T = scanner.nextDouble();
            System.out.println("请输入投资年限：");
            int n = scanner.nextInt();
            System.out.println("请输入投资利率：");
            double i = scanner.nextDouble();
            for(int j = 0;j < n;j++){
                P = P * (1 + i);
                P = P + T;
            }
            double F = P - T;
            String f = df.format(F);
            System.out.println("资产总值是："+f);

        }

        private static void baochoulvjisuan() {
            // TODO Auto-generated method stub
            System.out.println("请输入本金：");
            double P = scanner.nextDouble();
            System.out.println("请输入复利终值：");
            double F = scanner.nextDouble();
            System.out.println("请输入年限：");
            int n = scanner.nextInt();
            double i = Math.pow((F / P), (1.0 / n)) - 1;
            String f = df.format(i);
            System.out.println("利率是："+f);

        }

        private static void nianxianjisuan() {
            //TODO Auto-generated method stub
            System.out.println("请输入本金：");
            double P = scanner.nextDouble();
            System.out.println("请输入利率：");
            double i = scanner.nextDouble();
            System.out.println("请输入复利终值：");
            double F = scanner.nextDouble();
            int n = (int) (Math.log(F / P) / Math.log(1 + i));
            System.out.println("年限是：" + n);
        }

        private static void benjinjisuan() {
            //TODO Auto-generated method stub
            System.out.println("请输入复利终值：");
            double F = scanner.nextDouble();
            System.out.println("请输入利率：");
            double i = scanner.nextDouble();
            System.out.println("请输入年限：");
            int n = scanner.nextInt();
            double P;
            P = F / Math.pow(1 + i, n);
            String p = df.format(P);
            System.out.println("本金是：" + p);
        }

        private static void danlijisuan() {
            //TODO Auto-generated method stub
            System.out.println("请输入本金：");
            double P = scanner.nextDouble();
            System.out.println("请输入利率：");
            double i = scanner.nextDouble();
            System.out.println("请输入年限：");
            int n = scanner.nextInt();
            double F;
            F = P * (1 + i * n);
            String f = df.format(F);
            System.out.println("单利终值是：" + f);
        }

        private static void fulijisuan() {
            System.out.println("请输入本金：");
            double P = scanner.nextDouble();
            System.out.println("请输入利率：");
            double i = scanner.nextDouble();
            System.out.println("请输入年限：");
            int n = scanner.nextInt();
            double F;
            F = P * Math.pow(1 + i, n);
            String f = df.format(F);
            System.out.println("复利终值是：" + f);
        }

}