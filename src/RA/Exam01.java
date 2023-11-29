package RA;

import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrNumber = new int[100];
        int choice = 0;
        int number = 0;
        int sum;
        int tbc;
        do {
            System.out.println("**********************MENU************************");
            System.out.println("1. Nhập giá trị n phần từ của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử có giá trị bằng k trong mảng");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng k tỏng mảng");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xep mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Tính số lượng cac phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần" +
                    ", các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, các phần tử ở đầu mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m và mảng(sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");
            System.out.println("Nhập lựa chon của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập số phần tử của mảng: ");
                    number = sc.nextInt();
                    break;
                case 2:
                    for (int i = 0; i < number; i++) {
                        System.out.println("Nhập giá trị thứ [" + i + "]:");
                        arrNumber[i] = sc.nextInt();
                    }
                    System.out.println("Mảng là: ");
                    for (int i = 0; i < number; i++) {
                        System.out.printf("%d\t", arrNumber[i]);
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    sum = 0;
                    tbc = 0;
                    for (int i = 0; i < number; i++) {
                        if (arrNumber[i] > 0) {
                            sum += arrNumber[i];
                            tbc = sum / arrNumber[i];
                        }
                    }
                    System.out.println("Trung bình cộng các phần tử dương có giá tri là: " + tbc);
                    break;
                case 4:
                    System.out.println("Nhập giá trị cần in: ");
                    int k = sc.nextInt();
                    System.out.println("Vị trí các phần tử co giá tị bằng " + k + " là:");
                    for (int i = 0; i < number; i++) {
                        if (k == arrNumber[i]) {
                            System.out.printf("%d\t", i);
                        }
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    int temp = 0;
                    for (int i = 0; i < number - 1; i++) {
                        for (int j = 0; j < number - i - 1; j++) {
                            if (arrNumber[j] < arrNumber[j-1]){
                                temp = arrNumber[j];
                                arrNumber[j] = arrNumber[j-1];
                                arrNumber[j-1] = temp;
                            }
                        }
                    }
                    System.out.println("Mảng đã sắp xếp");
                    break;
                case 6:
                    System.out.println("Các phần tử là so nguyên tố là: ");
                    for (int i = 0; i < number; i++) {
                        boolean isPrime = true;
                        if (arrNumber[i] >= 2) {
                            for (int j = 2; j <= Math.sqrt(arrNumber[i]); j++) {
                                if (arrNumber[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                        } else {
                            isPrime = false;
                        }
                        if (isPrime){
                            System.out.printf("%d\t", arrNumber[i]);
                        }
                    }
                    break;
                case 7:
                    int dau = 0, giua = 0, cuoi = 0;
                    int vitridoi = 0;
                    for (int i = 0; i < number; i++) {
                        if (arrNumber[i] % 3 == 0){
                            dau = arrNumber[vitridoi];
                            for (int j = vitridoi; j > 0 ; j++) {
                                arrNumber[j] = arrNumber[j-1];
                            }
                            arrNumber[0] = dau;
                        } else if (arrNumber[i] %2 !=0 && arrNumber[i] %3==0 ) {
                            cuoi = arrNumber[vitridoi];
                            for (int j = vitridoi; j > 0 ; j++) {
                                arrNumber[j] = arrNumber[j-1];
                            }
                            arrNumber[0] = cuoi;
                        }else {
                            giua = arrNumber[vitridoi];
                            for (int j = vitridoi; j > 0 ; j++) {
                                arrNumber[j] = arrNumber[j-1];
                            }
                            arrNumber[0] = giua;
                        }
                    }
                    System.out.printf("Mảng được sắp xếp: %d%d%d", dau, giua, cuoi);
                    System.out.println("\n");
                    break;
                case 8:
                    temp = 0;
                    System.out.println("\nNhập giá trị chèn: ");
                    int addValue = sc.nextInt();
                    System.out.println("Nhập chỉ số cần chèn: ");
                    int addIndex = sc.nextInt();
                    for(int i = 0; i < number - 1; i++){
                        for(int j = i + 1; j < number; j++){
                            if(arrNumber[i] < arrNumber[j]){
                                temp = arrNumber[i];
                                arrNumber[i] = arrNumber[j];
                                arrNumber[j] = temp;
                            }
                        }
                    }
                    int[] newArrNumber = new int[number+1];
                    for (int i = 0, j =0; i < newArrNumber.length; i++) {
                        if (i==addIndex){
                            newArrNumber[i] = addValue;
                        }else {
                            newArrNumber[i] = arrNumber[j];
                            j++;
                        }
                    }
                    System.out.println("Mảng sau khi chèn: ");
                    for (int i = 0; i < newArrNumber.length; i++) {
                        System.out.printf("%d\t", newArrNumber[i]);
                    }
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Mời bạn chọn từ 1-9!");
            }
        } while (choice != 9);
    }

}
