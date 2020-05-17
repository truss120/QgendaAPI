package edu.bcm.rds.api.sap.entity;

public class Content {

    Attrs attrs;
    private String _type;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attrs getAttrs() {
        return attrs;
    }

    public String get_type() {
        return _type;
    }

    public void setAttrs(Attrs attrsObject) {
        this.attrs = attrsObject;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    @Override
    public String toString() {
        return "Content{" +
                "attrs=" + attrs +
                ", _type='" + _type + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

