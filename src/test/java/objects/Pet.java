package objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pet {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetCategory getCategory() {
        return category;
    }

    public void setCategory(PetCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<PetTags> getTags() {
        return tags;
    }

    public void setTags(List<PetTags> tags) {
        this.tags = tags;
    }

    public PetStatus getStatus() {
        return status;
    }

    public void setStatus(PetStatus status) {
        this.status = status;
    }

    private long id;
    private PetCategory category;
    private String name;
    private List<String> photoUrls;
    private List<PetTags> tags;
    private PetStatus status;
}
