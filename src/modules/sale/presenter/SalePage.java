package modules.sale.presenter;

import di.InjectionDependency;
import modules.home.domain.errors.IHomeException;
import modules.home.presenter.HomeController;
import modules.sale.domain.errors.ISaleException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SalePage {
    Scanner scanner = new Scanner(System.in);
    SaleControler controller = (SaleControler) InjectionDependency.getInstance().get("SaleController");

    public void buyPage(){
        int saleID = -1;

        do {
            try {
                System.out.println("Please enter product code: ");
                System.out.println("'exit' to exit");
                String code = scanner.next();

                if (!code.startsWith("exit")){
                    controller.setAnnouncementCode(code);
                    saleID = controller.sale.getId();
                } else {
                    saleID = -2;
                }

                System.out.print("\033[H\033[2J");
                System.out.flush();
            } catch (InputMismatchException | IHomeException inputMismatchException) {
                System.err.printf("%nException: %s%n", inputMismatchException);
                scanner.nextLine(); // discard input so user can try again
                System.out.printf("You must only numbers. Please try again.%n%n");
            } catch (ISaleException e) {
                e.printStackTrace();
            }
        } while (saleID == -1);

        if (saleID != -2){
            System.out.println("Purchase succeful:");
            System.out.println("brief:");
            System.out.println("Purchase Id:" + controller.sale.getId());
            System.out.println("Announcement Id:" + controller.sale.getAnnouncementId());
            System.out.println("Price:" + controller.sale.getPurchasePrice());
        }



    }

}
