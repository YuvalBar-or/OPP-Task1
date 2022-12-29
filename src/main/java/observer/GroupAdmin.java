package observer;
import java.util.ArrayList;
import java.util.List;
public class GroupAdmin implements Sender{

    private UndoableStringBuilder usb;
    List<Member> members;

    /**
     * a constructor for a new GroupAdmin
     * with default values
     */
    public GroupAdmin() {
        this.usb= new UndoableStringBuilder();
        this.members= new ArrayList<>();
    }

    /**
     * this function adds a new member to the group
     * @param obj the new member that we want to add
     */
    public void register(Member obj) {
        if (members.contains(obj))
        {
            System.out.println("member already exists");
        }
        else {
            members.add(obj);
        }
    }

    /**
     * this function removes an existing member out of  the group
     * @param obj the member we want to remove
     */
    public void unregister(Member obj){
        if (members.contains(obj)){
            members.remove(obj);
        }
        else{
            System.out.println("member doesnt exist");
        }

    }

    /**
     * this function inserts the string into this character sequence.
     * @param offset the offset
     * @param obj the object
     */
   @Override
    public void insert(int offset, String obj){
        this.usb.insert(offset,obj);
        this.notifyObservers();
    }

    /**
     * this function ppends the specified string to this character sequence.
     * @param obj the string to append
     */
    @Override
    public void append(String obj) {
       this.usb.append(obj);
       this.notifyObservers();
    }

    /**
     * this function removes the substring in between the given range
     * @param start starting point
     * @param end ending point
     */
    @Override
    public void delete(int start, int end){
        this.usb.delete(start, end);
        this.notifyObservers();
    }

    /**
     * this function undoes the last action
     */
    @Override
    public void undo(){
        this.usb.undo();
        this.notifyObservers();
    }

    /**
     * this function tuns through all members and updates them
     */
    public void notifyObservers() {
        for (Member m : members){
            m.update(usb);
        }
    }

    /**
     * this function gets the members in the list
     * @return a list of members
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * a tostring method
     * @return the current string that's stored
     */
    @Override
    public String toString() {
        return usb.toString();
    }
}
