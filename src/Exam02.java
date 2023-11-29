import java.util.Scanner;

public class Exam02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = sc.nextInt();
        System.out.println("Nhập m: ");
        int m = sc.nextInt();
        int[][] arrNumber = new int[n][m];
        int choice = 0;
        int sum;
        do {
            System.out.println("************************MENU**************************\n" +
                    "1. Nhập giá trị các phần tử của mảng\n" +
                    "2. In giá trị các phần tử trong mảng theo ma trận\n" +
                    "3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng \n" +
                    "4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ \n" +
                    "5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của mảng \n" +
                    "6. In ra các phần tử là số nguyên tố trong mảng\n" +
                    "7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính của mảng giảm dần\n" +
                    "8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng,thực hiện chèn vào mảng 2 chiều\n" +
                    "9. Thoát");
            System.out.println("Nhập lựa chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.println("Nhập giá trị phần tử: ");
                            arrNumber[i][j] = sc.nextInt();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ma trận: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%d\t", arrNumber[i][j]);
                        }
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (arrNumber[i][j] % 3 == 0 && arrNumber[i][j] % 2 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("Số lượng các phần tử chia hết cho 2 và 3 là: " + count);
                    break;
                case 4:
                    sum = 0;
                    System.out.println("Các phần tử nằm trên đường biên là: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || j == 0 || i == n - 1 || m == j - 1) {
                                System.out.printf("%d\t", arrNumber[i][j]);
                                sum += arrNumber[i][j];
                            }
                        }
                    }
                    System.out.println("Tổng các phần tử nằm trên đường biên là: " + sum);
                    if (n == m) {
                        System.out.println("Các phần tử nằm trên đường chéo chính là: ");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                if (i == j) {
                                    System.out.printf("%d\t", arrNumber[i][j]);
                                    sum += arrNumber[i][j];
                                }
                            }
                        }
                        System.out.println("\nTổng các phần tử nằm trên đường chéo chính là: " + sum);
                        System.out.println("Các phần tử nằm trên đường chéo phụ là: ");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                if (i + j == n - 1) {
                                    System.out.printf("%d\t", arrNumber[i][j]);
                                    sum += arrNumber[i][j];
                                }
                            }
                        }
                        System.out.println("\nTổng các phần tử nằm trên đường chéo phụ là: " + sum);
                    } else {
                        System.out.println("Không có đường chéo chính và phụ");
                    }
                    break;
                case 5:
                    for(int i = 0;i<n;i++){
                        for(int j = 0; j<m; j++){
                            for(int k = j+1; k<m; k++){
                                if(arrNumber[j][i] > arrNumber[k][i]){
                                    int temp = arrNumber[j][i];
                                    arrNumber[j][i] = arrNumber[k][i];
                                    arrNumber[k][i] = temp;
                                }
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong!");
                    break;
                case 6:
                    System.out.println("Các phần tử là số nguyên tố là: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            boolean isPrime = true;
                            if (arrNumber[i][j] >= 2) {
                                for (int k = 2; k <= Math.sqrt(arrNumber[i][j]); k++) {
                                    if (arrNumber[i][j] % k == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                            } else {
                                isPrime = false;
                            }
                            if (isPrime) {
                                System.out.printf("%d\t", arrNumber[i][j]);
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("Đã sắp xếp xong!");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            for (int k = i + 1; k < n; k++) {
                                for (int l = j + 1; l < m; l++) {
                                    if (arrNumber[i][j] < arrNumber[j][i]) {
                                        int temp = arrNumber[i][j];
                                        arrNumber[i][j] = arrNumber[j][i];
                                        arrNumber[j][i] = temp;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    int[] singleArr = new int[m];
                    for (int i = 0; i < m; i++) {
                        System.out.println("Nhập giá trị thứ [" + i + "]");
                        singleArr[i] = sc.nextInt();
                    }
                    System.out.println("Nhập chỉ số dòng muốn chèn: ");
                    int addIndex = sc.nextInt();
                    int[][] newArrNumber = new int[n][m];
                    for (int i = 0; i < n; i++) {
                        arrNumber[addIndex][i] = singleArr[i];
                    }
                    System.out.println("Mảng sau khi chèn là: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%d\t", newArrNumber[i][j]);
                        }
                    }
                    System.out.println("\n");
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Mời bạn chọn từ 1-9");
            }
        } while (choice != 9);
    }
}
