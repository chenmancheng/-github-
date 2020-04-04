package soft.pojo;

import org.springframework.web.multipart.MultipartFile;

public class Product {
    private Integer id;

    private String name;

    private String categories;

    private MultipartFile logoImage;



    private String picture;

    private String detail;

    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public MultipartFile getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(MultipartFile logoImage) {
        this.logoImage = logoImage;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categories='" + categories + '\'' +
                ", picture='" + picture + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(Integer id, String name, String categories,  String picture, String detail, Integer price) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.picture = picture;
        this.detail = detail;
        this.price = price;
    }

    public Product() {
    }
}