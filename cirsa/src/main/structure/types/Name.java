package main.structure.types;

public class Name {
    String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " \"name\":\"" + name + "\"" ;
    }
}
