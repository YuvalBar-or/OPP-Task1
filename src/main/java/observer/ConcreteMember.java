package observer;
public class ConcreteMember implements Member{
    /**
     * a constructor
     */
    private UndoableStringBuilder usbShallowCopy;
    public ConcreteMember(){
        this.usbShallowCopy = null;
    }

    /**
     *this method updates the UndoableStringBuilder
     * @param usb the new UndoableStringBuilder obj
     */
   @Override
    public void update(UndoableStringBuilder usb) {
        this.usbShallowCopy=usb;
        System.out.println("the UndoableStringBuilder now is "+usbShallowCopy.toString());
    }

    /**
     * a to string method
     * @return the current string that's stored.
     */
    @Override
    public String toString() {
        return usbShallowCopy.toString();
    }
}

