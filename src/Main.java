import Entities.Spid;
import Entities.Status;
import Entities.User;
import Service.SpidService;
import Service.UserService;

public class Main {
    public static void main(String[] argv) {
        SpidService spidManager = new SpidService();
        UserService userManager = new UserService();

        try {
            User newUser = userManager.createUser("Ajneo", "Dalipi", "AjneoD");
            System.out.println(newUser);

            Spid newSpid = spidManager.createSpid(newUser);
            System.out.println(newSpid);

            spidManager.aproveSpid(1);

            spidManager.showList();

            System.out.println(userManager.showSpidOf("AjneoD"));

            System.out.println("Modifying user with the user of 'AjneoD'");
            userManager.modifyUser("AjneoD", "hello","Dalipi");

            System.out.println("Modify the SPID with the id of 1 ");
            spidManager.modifySpid(1, Status.READY_FOR_REVIEW);
            System.out.println(newSpid);
        } catch (Exception err) {
            System.out.println("There was an error!");
        }
    }

}