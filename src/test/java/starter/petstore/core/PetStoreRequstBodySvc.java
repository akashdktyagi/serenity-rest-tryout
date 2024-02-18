package starter.petstore.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import starter.petstore.client.openapi.model.Category;
import starter.petstore.client.openapi.model.Pet;
import starter.petstore.client.openapi.model.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetStoreRequstBodySvc {

    public static String generateCreateNewPetBodyWithCategoryNameAndTagNameAs(String categoryName, String petName, String tagName) throws JsonProcessingException {

        Category category = new Category();
        category.name(categoryName);

        Tag tag = new Tag();
        tag.name(tagName);

        Pet pet = new Pet();
        pet.setCategory(category);
        pet.setName(petName);
        pet.tags(Arrays.asList(tag));

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("DEBUG:" +  objectMapper.writeValueAsString(pet));
        return objectMapper.writeValueAsString(pet);

    }

    public static String generateFullPetJsonBody() throws JsonProcessingException {
        Tag tag1 = new Tag();
        tag1.name("tag1");

        Tag tag2 = new Tag();
        tag2.name("tag2");

        List<Tag> listOfTags = new ArrayList<>();
        listOfTags.add(tag1);
        listOfTags.add(tag2);

        Category category = new Category();
        category.name("fish");
        category.id(342L);

        //Crate the actual object
        Pet pet = new Pet();
        pet.name("akash12345");
        pet.category(category);
        pet.tags(listOfTags);
        pet.addPhotoUrlsItem("url1");
        pet.addPhotoUrlsItem("url2");
        pet.status(Pet.StatusEnum.AVAILABLE);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("DEBUG:" +  objectMapper.writeValueAsString(pet));
        return objectMapper.writeValueAsString(pet);
    }

    public  Pet generateBasicPet(){
        //Crate the actual object
        Pet pet = new Pet();
        pet.name("akash12345");

        return pet;
    }

    public Pet addTagsToPetAndReturn(){
        Pet pet  = generateBasicPet();
        Tag tag1 = new Tag();
        tag1.name("tag1");
        pet.addTagsItem(tag1);
        return pet;

//        Builder.buildPet().withTags(Arrays.asList(tag1)).build();
    }
}
