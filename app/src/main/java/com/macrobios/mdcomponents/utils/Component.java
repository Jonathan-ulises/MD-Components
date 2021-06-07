package com.macrobios.mdcomponents.utils;

import java.util.Objects;

public class Component {
    private String name;
    private int fotoRes;
    private int type;

    public Component() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFotoRes() {
        return fotoRes;
    }

    public void setFotoRes(int fotoRes) {
        this.fotoRes = fotoRes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return fotoRes == component.fotoRes &&
                type == component.type &&
                Objects.equals(name, component.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fotoRes, type);
    }
}
