import java.time.LocalDateTime;
import java.util.ArrayList;

public class Classes {

    private LocalDateTime slot;
    private String type;
    private int limit;
    private int currentSlots;
    private ArrayList<String> users;
    private ArrayList<String> queue;

    public Classes(String type, int limit, LocalDateTime slot){
        this.type = type;
        this.slot = slot;
        this.limit = limit;
        this.currentSlots = 0;
        this.users = new ArrayList<>();
        this.queue = new ArrayList<>();
    }


    public ArrayList<String> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<String> queue) {
        this.queue = queue;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public int getCurrentSlots() {
        return currentSlots;
    }

    public void setCurrentSlots(int currentSlots) {
        this.currentSlots = currentSlots;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public LocalDateTime getSlot() {
        return slot;
    }

    public void setSlot(LocalDateTime slot) {
        this.slot = slot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isAdmissible(){
        if (currentSlots <= limit && LocalDateTime.now().isBefore(slot)) {
            currentSlots++;
            return true;
        }
        return false;
    }

    public Boolean isCancellable(String user){
        return users.contains(user) && LocalDateTime.now().plusMinutes(30).isBefore(slot);
    }

    public void addUserToClass(String user){
        currentSlots++;
        users.add(user);
    }

    public void addUserToQueue(String name){
        queue.add(name);
    }

    public void removeUser(String user) {
        users.remove(user);
        users.add(queue.get(0));
        queue.remove(0);
    }
}
