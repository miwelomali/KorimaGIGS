package com.example.exa2_restaurantes;

public class Rest {
    private int img;
    private String name;
    private String loc;
    private String desc;
    private Float rating;

    public Rest(){
        img = R.drawable.placeholder;
        name = "Taller del chef";
        loc = "Colonia Centro";
        desc = "Comida";
        rating = Float.valueOf(3);
    }

    public Rest(int img, String name, String loc, String desc, Float rating) {
        this.img = img;
        this.name = name;
        this.loc = loc;
        this.desc = desc;
        this.rating = rating;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
