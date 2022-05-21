package cargomanage;

public class Cargo {
    private int id;
    private String name;
    private String price;
    private int nums;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getNums() {
        return nums;
    }
    public void setNums(int nums) {
        this.nums = nums;
    }
}
