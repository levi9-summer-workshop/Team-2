package rs.levi9.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.CategoryOption;
import rs.levi9.survey.repository.CategoryOptionRepository;

import java.util.List;

@Service
public class CategoryOptionService {

    private CategoryOptionRepository categoryOptionRepository;

    @Autowired
    public CategoryOptionService(CategoryOptionRepository categoryOptionRepository) {
        this.categoryOptionRepository = categoryOptionRepository;
    }

    public CategoryOption findOne(Long id){
        return categoryOptionRepository.findOne(id);
    }

    public List<CategoryOption> findAll() {
        return categoryOptionRepository.findAll();
    }

    public CategoryOption save(CategoryOption categoryOption) {
        return categoryOptionRepository.save(categoryOption);
    }

    public void delete(Long id) {
        categoryOptionRepository.delete(id);
    }

}
