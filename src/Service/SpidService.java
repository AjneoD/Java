package Service;

import Entities.Spid;
import Entities.Status;
import Entities.User;
import Utilities.array;

import java.util.*;

public class SpidService {
    private List<Spid> data = new ArrayList<Spid>();
    private array arr = new array();

    public Spid getSpid(long id) throws Exception {
        for (int i = 0; i < data.size(); ++i) {
            if (data.get(i).getId() == id) {
                return data.get(i);
            }
        }
        throw new Exception(String.format("Spid with an id:'%d' does not exists!", id));
    }
    public Spid createSpid(User user) {
        long id = arr.iota();
        Spid spid = new Spid(id, new Date(), user);
        user.setSpid(spid);
        data.add(spid);
        System.out.println(String.format("Spid %d created successfully!", id));
        return spid;
    }
    public void modifySpid(long id, Status status) throws Exception {
        getSpid(id).setStatus(status);
    }
    public void aproveSpid(long id) throws Exception {
        getSpid(id).setStatus(Status.APPROVED);
    }
    public void showList() {
        System.out.println("\nList of SPIDs: ");
        data.forEach(el -> System.out.println("\t" + el));
    }
}