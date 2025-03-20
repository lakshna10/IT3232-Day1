import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        int mid = n / 2;
        int j=1;
        for (int i = 1; i <= n; i++) {
            if (i <= mid) {
                System.out.print((mid - i + 1) + " ");
            } else if (i == mid + 1) {
                System.out.print(mid + 1 + " ");
            } else {
                System.out.print(mid + i -j+" ");
                j=j+2;
            }
        }
    }
}
