import java.util.ArrayList;


/**ADT ที่เก็บ integer แบบไม่ซ้ำกันและเรียงลำดับ
 */
public class IntegerSet {
    ArrayList<Integer> Numbers;//Rep

    // Rep Invariant (RI):
    //  - Numbersไม่เป็นnull
    //  - Numbers must not contain duplicate integers.
    //  - integers in Numbers must be sorted in ascending order.
    //
    // Abstraction Function (AF):
    //  - AF(Numbers) = the set of integers in ArrayList.

    /**
     * Constructor เริ่มต้น สร้างเซตว่าง
     */
    public IntegerSet(){
        Numbers = new ArrayList<>();
        checkRep();
    }

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    //เขียนทีหลังสุด
    private void checkRep() {
        if(Numbers==null){
            throw new RuntimeException("Rep invariant violated!");
        }
        for (int i = 0; i < Numbers.size() - 1; i++) {
            if (Numbers.get(i) >= Numbers.get(i+1)) {
                throw new RuntimeException("Rep invariant violated!");
            }
        }
    }

    /**
     * เพิ่มตัวเลขเข้าเซต
     * @param x ตัวเลขที่ต้องการเพิ่ม
     */
    public void add(Integer x){
        /*if(x==null){
            throw new RuntimeException("Rep invariant violated!");
        }*/
        if(!Numbers.contains(x)){
            int i=0;
            while (i<Numbers.size() && Numbers.get(i)<x){
                i++;
            }
            Numbers.add(i, x); //แทรกxที่ตำแหน่งi
        }
        checkRep();
    }

    /**
     * ลบตัวเลขออกจากเซต
     * @param x ตัวเลขที่ต้องการลบ
     */
    public boolean remove(Integer x){
        boolean removed = Numbers.remove(x);
        checkRep();
        return removed;
    }

    /**
     * ตรวจสอบว่ามีตัวเลขนี้อยู่ในเซตหรือไม่
     * @param x ตัวเลขที่ต้องการตรวจสอบ
     * @return true หากมี x อยู่ในเซต, false หากไม่มี
     */
    public boolean contains(Integer x){
        return Numbers.contains(x);
    }

    /**
     * คืนค่าขนาดของเซต
     * @return จำนวนสมาชิกในเซต
     */
    public int size() {
        return Numbers.size();
    }

    public String toString(){
        if(Numbers.isEmpty()){
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < Numbers.size(); i++) {
            sb.append(Numbers.get(i));
            if (i < Numbers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
