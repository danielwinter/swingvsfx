package de.saxsys.swingvsfx.model;

import javafx.beans.property.SimpleIntegerProperty;

public class TableRowData {

    SimpleIntegerProperty firstProp;
    SimpleIntegerProperty secondProp;
    SimpleIntegerProperty thridProp;
    SimpleIntegerProperty fourthProp;
    SimpleIntegerProperty fifthProp;
    SimpleIntegerProperty sixthProp;
    SimpleIntegerProperty seventhProp;
    SimpleIntegerProperty eighthProp;
    SimpleIntegerProperty ninethProp;
    SimpleIntegerProperty tenthProp;
    
    public TableRowData(SimpleIntegerProperty firstProp, SimpleIntegerProperty secondProp,
            SimpleIntegerProperty thridProp, SimpleIntegerProperty fourthProp, SimpleIntegerProperty fifhthProp,
            SimpleIntegerProperty sixProp, SimpleIntegerProperty seventhProp, SimpleIntegerProperty eigthProp,
            SimpleIntegerProperty ninethProp, SimpleIntegerProperty tenthProp) {
        super();
        this.firstProp = firstProp;
        this.secondProp = secondProp;
        this.thridProp = thridProp;
        this.fourthProp = fourthProp;
        this.fifthProp = fifhthProp;
        this.sixthProp = sixProp;
        this.seventhProp = seventhProp;
        this.eighthProp = eigthProp;
        this.ninethProp = ninethProp;
        this.tenthProp = tenthProp;
    }

    public TableRowData(int firstProp, int secondProp,
            int thridProp, int fourthProp, int fifthProp,
            int sixProp, int seventhProp, int eigthProp,
            int ninethProp, int tenthProp) {
        super();
        this.firstProp = new SimpleIntegerProperty(firstProp);
        this.secondProp = new SimpleIntegerProperty(secondProp);
        this.thridProp = new SimpleIntegerProperty(thridProp);
        this.fourthProp = new SimpleIntegerProperty(fourthProp);
        this.fifthProp = new SimpleIntegerProperty(fifthProp);
        this.sixthProp = new SimpleIntegerProperty(sixProp);
        this.seventhProp = new SimpleIntegerProperty(seventhProp);
        this.eighthProp = new SimpleIntegerProperty(eigthProp);
        this.ninethProp = new SimpleIntegerProperty(ninethProp);
        this.tenthProp = new SimpleIntegerProperty(tenthProp);
    }
    
    public SimpleIntegerProperty firstProp() {
        return firstProp;
    }

    public void setFirstProp(SimpleIntegerProperty firstProp) {
        this.firstProp = firstProp;
    }

    public SimpleIntegerProperty secondProp() {
        return secondProp;
    }

    public void setSecondProp(SimpleIntegerProperty secondProp) {
        this.secondProp = secondProp;
    }

    public SimpleIntegerProperty thridProp() {
        return thridProp;
    }

    public void setThridProp(SimpleIntegerProperty thridProp) {
        this.thridProp = thridProp;
    }

    public SimpleIntegerProperty fourthProp() {
        return fourthProp;
    }

    public void setFourthProp(SimpleIntegerProperty fourthProp) {
        this.fourthProp = fourthProp;
    }

    public SimpleIntegerProperty fifhthProp() {
        return fifthProp;
    }

    public void setFifhthProp(SimpleIntegerProperty fifhthProp) {
        this.fifthProp = fifhthProp;
    }

    public SimpleIntegerProperty sixProp() {
        return sixthProp;
    }

    public void setSixProp(SimpleIntegerProperty sixProp) {
        this.sixthProp = sixProp;
    }

    public SimpleIntegerProperty seventhProp() {
        return seventhProp;
    }

    public void setSeventhProp(SimpleIntegerProperty seventhProp) {
        this.seventhProp = seventhProp;
    }

    public SimpleIntegerProperty eigthProp() {
        return eighthProp;
    }

    public void setEigthProp(SimpleIntegerProperty eigthProp) {
        this.eighthProp = eigthProp;
    }

    public SimpleIntegerProperty ninethProp() {
        return ninethProp;
    }

    public void setNinethProp(SimpleIntegerProperty ninethProp) {
        this.ninethProp = ninethProp;
    }

    public SimpleIntegerProperty tenthProp() {
        return tenthProp;
    }

    public void setTenthProp(SimpleIntegerProperty tenthProp) {
        this.tenthProp = tenthProp;
    }
    
    public int getFirstProp() {
        return this.firstProp.get();
    }
    
    public int getSecondProp() {
        return this.secondProp.get();
    }
    
    public int getThirdProp() {
        return this.thridProp.get();
    }
    
    public int getFourthProp() {
        return this.fourthProp.get();
    }
    
    public int getFifthProp() {
        return this.fifthProp.get();
    }
    
    public int getSixthProp() {
        return this.sixthProp.get();
    }
    
    public int getSeventhProp() {
        return this.seventhProp.get();
    }
    
    public int getEighthProp() {
        return this.eighthProp.get();
    }
    
    public int getNinethProp() {
        return this.ninethProp.get();
    }
    
    public int getTenthProp() {
        return this.tenthProp.get();
    }    
}
