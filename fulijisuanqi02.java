package fulijisuanqi02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class fulijisuanqi02 {
     static Scanner scanner = new Scanner(System.in);
        static DecimalFormat df = new DecimalFormat("####0.0000");

        public static void main(String[] args) {
            //TODO Auto-generated method stub

            System.out.println("1.�������㣻");
            System.out.println("2.�������㣻");
            System.out.println("3.������㣻");
            System.out.println("4.���޼��㡣");
            System.out.println("5.�����ʼ��㣺");
            System.out.println("6.�ۼ��ʲ���ֵ���㣺");
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
                break;
            case 5:
                baochoulvjisuan();
                break;
            case 6:
                leijizichanjisuan();
                break;
            default:
                break;
            }
        }

        private static void leijizichanjisuan() {
            // TODO Auto-generated method stub
            System.out.println("�����뱾��");
            double P = scanner.nextDouble();
            System.out.println("������ÿ���Ͷ�ʽ�");
            double T = scanner.nextDouble();
            System.out.println("������Ͷ�����ޣ�");
            int n = scanner.nextInt();
            System.out.println("������Ͷ�����ʣ�");
            double i = scanner.nextDouble();
            for(int j = 0;j < n;j++){
                P = P * (1 + i);
                P = P + T;
            }
            double F = P - T;
            String f = df.format(F);
            System.out.println("�ʲ���ֵ�ǣ�"+f);

        }

        private static void baochoulvjisuan() {
            // TODO Auto-generated method stub
            System.out.println("�����뱾��");
            double P = scanner.nextDouble();
            System.out.println("�����븴����ֵ��");
            double F = scanner.nextDouble();
            System.out.println("���������ޣ�");
            int n = scanner.nextInt();
            double i = Math.pow((F / P), (1.0 / n)) - 1;
            String f = df.format(i);
            System.out.println("�����ǣ�"+f);

        }

        private static void nianxianjisuan() {
            //TODO Auto-generated method stub
            System.out.println("�����뱾��");
            double P = scanner.nextDouble();
            System.out.println("���������ʣ�");
            double i = scanner.nextDouble();
            System.out.println("�����븴����ֵ��");
            double F = scanner.nextDouble();
            int n = (int) (Math.log(F / P) / Math.log(1 + i));
            System.out.println("�����ǣ�" + n);
        }

        private static void benjinjisuan() {
            //TODO Auto-generated method stub
            System.out.println("�����븴����ֵ��");
            double F = scanner.nextDouble();
            System.out.println("���������ʣ�");
            double i = scanner.nextDouble();
            System.out.println("���������ޣ�");
            int n = scanner.nextInt();
            double P;
            P = F / Math.pow(1 + i, n);
            String p = df.format(P);
            System.out.println("�����ǣ�" + p);
        }

        private static void danlijisuan() {
            //TODO Auto-generated method stub
            System.out.println("�����뱾��");
            double P = scanner.nextDouble();
            System.out.println("���������ʣ�");
            double i = scanner.nextDouble();
            System.out.println("���������ޣ�");
            int n = scanner.nextInt();
            double F;
            F = P * (1 + i * n);
            String f = df.format(F);
            System.out.println("������ֵ�ǣ�" + f);
        }

        private static void fulijisuan() {
            System.out.println("�����뱾��");
            double P = scanner.nextDouble();
            System.out.println("���������ʣ�");
            double i = scanner.nextDouble();
            System.out.println("���������ޣ�");
            int n = scanner.nextInt();
            double F;
            F = P * Math.pow(1 + i, n);
            String f = df.format(F);
            System.out.println("������ֵ�ǣ�" + f);
        }

}