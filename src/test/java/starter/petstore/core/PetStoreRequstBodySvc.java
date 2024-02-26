package starter.petstore.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.model.Pet;

public class PetStoreRequstBodySvc {

/*     public static String generateCreateNewPetBodyWithCategoryNameAndTagNameAs(String categoryName, String petName, String tagName) throws JsonProcessingException {

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

    }*/

    public static String generateFullPetJsonBody() throws JsonProcessingException {
/*        Tag tag1 = new Tag();
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
        pet.status(Pet.StatusEnum.AVAILABLE);*/

        // Create a new Pet object using the builder pattern
        Pet pet = Pet.builder()
                .id(123L) // Set the ID of the pet
                .name("Rex") // Set the name of the pet
                .status(Pet.StatusEnum.AVAILABLE) // Set the status of the pet
                .build();

        // Convert the Pet object to JSON
        String jsonPayload = toJson(pet);

        // Print the JSON payload
        System.out.println(jsonPayload);

//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println("DEBUG:" +  objectMapper.writeValueAsString(pet));
//        return objectMapper.writeValueAsString(pet);

        return jsonPayload;
    }

    // Convert an object to JSON using Jackson ObjectMapper
    private static String toJson(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public  Pet generateBasicPet(){
        //Crate the actual object
        Pet pet = new Pet();
        pet.name("akash12345");

        return pet;
    }

//    public Pet addTagsToPetAndReturn(){
//        Pet pet  = generateBasicPet();
//        Tag tag1 = new Tag();
//        tag1.name("tag1");
//        pet.addTagsItem(tag1);
//        return pet;

//        Builder.buildPet().withTags(Arrays.asList(tag1)).build();
//    }
}
