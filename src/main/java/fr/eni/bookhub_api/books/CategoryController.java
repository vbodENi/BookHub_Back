package fr.eni.bookhub_api.books;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoryController {
    
      private ICategoryBLL iCategoryBLL;

    public CategoryController(ICategoryBLL iCategoryBLL) {
        this.iCategoryBLL = iCategoryBLL;
    }

    @GetMapping
        public List<CategoryDTO> getAllCategories(){
            return iCategoryBLL.getAllCategories();
        }
}
