package com.example.apptaplayoutandbottomnavigation;

public class items {
    private String ten;
    private String tieude;
    private String anh;
    private boolean mua;

    public boolean isMua() {
        return mua;
    }

    public void setMua(boolean mua) {
        this.mua = mua;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public items() {
    }

    public items(String ten, String tieude, String anh, boolean mua) {
        this.ten = ten;
        this.tieude = tieude;
        this.anh = anh;
        this.mua = mua;
    }
}
