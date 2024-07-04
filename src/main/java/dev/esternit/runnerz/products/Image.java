package dev.esternit.runnerz.products;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("images")
public class Image {
    @Id
    private UUID id;
    private String url;
    private UUID productId;
    private Integer width;
    private Integer height;
    private String slug;

    @Version
    private Integer version;

    public Image() {
    }

    public Image(UUID id, String url, UUID productId, Integer width, Integer height, String slug, Integer version) {
        this.id = id;
        this.url = url;
        this.productId = productId;
        this.width = width;
        this.height = height;
        this.slug = slug;
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}