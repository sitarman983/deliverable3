package ca.sheridancollege.project;

public class WarCard extends Card {
   
    private String suite;
    private int value;

    public WarCard(String suite, int value) {
        
        this.suite = suite;
        
        this.value = value;
    }

    public String getSuite() {
        
        return suite;
    }

    public void setSuite(String suite) {
        
        this.suite = suite;
    }

    public int getValue() {
       
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
       
        return "WarCard{" + "suite=" + suite + ", value=" + value + '}';
    }
}
