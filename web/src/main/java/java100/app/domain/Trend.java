package java100.app.domain;

public class Trend {
    protected int tr_no;
    protected String op_tag;
    protected String photo;




    @Override
    public String toString() {
        return "Trend [tr_no=" + tr_no + ", op_tag=" + op_tag + ", photo=" + photo + "]";
    }


    public int getTr_no() {
        return tr_no;
    }


    public void setTr_no(int tr_no) {
        this.tr_no = tr_no;
    }

    public String getOp_tag() {
        return op_tag;
    }

    public void setOp_tag(String op_tag) {
        this.op_tag = op_tag;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
