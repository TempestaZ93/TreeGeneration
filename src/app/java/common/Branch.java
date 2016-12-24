package app.java.common;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Philipp Gagel
 */
public class Branch {
    
    public enum Angle{
        STRAIGHT (0),
        RIGHT_NARROW (45),
        RIGHT (90),
        RIGHT_WIDE (135),
        LEFT_WIDE (225),
        LEFT (270),
        LEFT_NARROW (315);
        
        private final float angle;
        
        Angle(float angle){
            this.angle = angle;
        }

        public float getAngle() {
            return angle;
        }
        
    }
    
    private int length;
    private Angle angle;
    private List<Branch> children;

    private final Branch father;
    
    public Branch(Branch father, Angle angle) {
        this.father = father;
        this.angle = angle;
        this.children = new LinkedList<>();
    }
    
    public Branch(int length, Branch father, Angle angle) {
        this(father, angle);
        this.length = length;
    }

    public Branch(int length, Branch father, List<Branch> children, Angle angle) {
        this(length, father, angle);
        this.children = children;
    }

    public int getLength() {
        return length;
    }

    public Branch getFather() {
        return father;
    }

    public List<Branch> getChildren() {
        return children;
    }

    public Angle getAngle() {
        return angle;
    }
    
    public void addBranch(Angle angle){
        this.children.add(new Branch(this, angle));
    }
    
    public void addBranch(){
        Random random = new Random(new Date().getTime());
        int randId = random.nextInt(Angle.values().length);
        
        this.addBranch(Angle.values()[randId]);
    }
    
}
