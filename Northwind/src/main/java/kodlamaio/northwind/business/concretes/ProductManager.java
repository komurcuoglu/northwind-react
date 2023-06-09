package kodlamaio.northwind.business.concretes;

import java.util.List;

import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

import javax.xml.transform.Result;

@Service
public class ProductManager implements ProductService{
    private ProductDao productDao;


    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Ürünler Listelendi.");
    }


    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Ürünler Listelendi.");
    }


    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Ürünler Listelendi.");
    }


    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Ürünler Listelendi.");
    }


    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories), "Ürünler Listelendi.");
    }


    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Ürünler Listelendi.");
    }


    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "Ürünler Listelendi.");
    }


    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId), "Ürünler Listelendi.");
    }


    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent(), "Sayfalama başarılı!");	}


    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC, "productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Sıralama başarılı!");

    }

    @Override
    public Result add(Product product) {
        return null;
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return new SuccessDataResult<List<ProductWithCategoryDto>>
                (this.productDao.getProductWithDetails(),"Data Listelendi");
    }



}
