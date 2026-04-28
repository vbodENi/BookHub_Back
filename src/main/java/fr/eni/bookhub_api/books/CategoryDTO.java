package fr.eni.bookhub_api.books;


import fr.eni.bookhub_api.common.bo.Category;
import lombok.Getter;

@Getter
public class CategoryDTO {
    
    private Integer id;
      private String label;

      public CategoryDTO(Category category) {
          this.id = category.getId();
          this.label = category.getLabel();
      }
}
