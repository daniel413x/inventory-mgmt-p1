package com.cragsupplyco.backend.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cragsupplyco.backend.models.Category;
import com.cragsupplyco.backend.repositories.CategoryRepository;


public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private Category category1;

    @Mock
    private Category category2;

    @Mock
    private Category category3;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        this.category1 = new Category();
        this.category1.setId(1);
        this.category1.setName("Crampons");

        this.category2 = new Category();
        this.category2.setId(2);
        this.category2.setName("Helmets");

        this.category3 = new Category();
        this.category3.setId(3);
        this.category3.setName("Climbing Shoes");
    }

    @Test
    public void testFindAll() {
        List<Category> categories = Arrays.asList(category1, category2, category3);
        when(categoryRepository.findAll()).thenReturn(categories);

        Iterable<Category> result = categoryService.findAll();

        int count = 0;
        for (Category category : result) {
            count++;
        }

        assertTrue(count == categories.size());
    }

    @Test
    public void testFindByName() {
        when(categoryRepository.findByName(category1.getName())).thenReturn(Optional.of(category1));
        Optional<Category> result = categoryService.findByName(category1.getName());
        assertTrue(result.isPresent());
    }

    @Test
    public void testFindCategoryByExistingId() {
        when(categoryRepository.findById(category1.getId())).thenReturn(Optional.of(category1));
        Optional<Category> result = categoryService.findById(category1.getId());
        System.out.println(category1.getId());
        assertTrue(result.isPresent());
    }

    @Test
    public void testFindCategoryByNonExistentId() {
        Optional<Category> result = categoryService.findById(1);
        assertTrue(result.isEmpty());
    }

}
