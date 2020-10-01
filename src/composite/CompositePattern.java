package composite;

import java.util.*;

interface Component {
    public String toString();
    public ArrayList < Component > getChildren();
    public boolean addComponent(Component c);
    public boolean removeComponent(Component c);
}

class Composite implements Component {
    private String id;
    private ArrayList < Component > components = new ArrayList < Component > ();

    public Composite(String identification) {
        id = identification;
    }

    public String toString() {
        String s = " (" + id + ":";
        for (Component child: this.getChildren())
            s += " " + child.toString();
        return s + ") ";
    }

    public ArrayList < Component > getChildren() {
        return components;
    }
    public boolean addComponent(Component c) {
        return components.add(c);
    }
    public boolean removeComponent(Component c) {
        return components.remove(c);
    }
}

class Leaf implements Component {
    private String id;

    public Leaf(String identification) {
        id = identification;
    }

    public String toString() {
        return id;
    }
    public ArrayList < Component > getChildren() {
        return null;
    }
    public boolean addComponent(Component c) {
        return false;
    }
    public boolean removeComponent(Component c) {
        return false;
    }
}

class CompositePattern {
    public static void main(String[] args) {
        Composite cityHCM = new Composite("TP.HCM");
        Leaf district1 = new Leaf("Quận 1");
        Leaf districtThuDuc = new Leaf("Quận Thủ Đức");
        cityHCM.addComponent(district1);
        cityHCM.addComponent(districtThuDuc);
        cityHCM.removeComponent(district1);

        Composite cityHaNoi = new Composite("Hà Nội");
        cityHaNoi.addComponent(new Leaf("Quận Hồ Tây"));

        Composite countryVN = new Composite("Việt Nam");
        countryVN.addComponent(cityHaNoi);
        countryVN.addComponent(cityHCM);

        System.out.println(countryVN.toString());
    }
}