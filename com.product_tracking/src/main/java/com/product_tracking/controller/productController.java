package com.product_tracking.controller;


import com.product_tracking.entity.Product;
import com.product_tracking.entity.Users;
import com.product_tracking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.product_tracking.repository.productRepository;

import java.util.List;

@Controller
public class productController {

    @Autowired
    exportProductList exportProductList;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    productRepository productRepository;
    @GetMapping("/allproducts")
    public String showallproducts(@RequestParam(value = "searchValue",required = false) String searchValue,
            Model model) {
        List<Product> products;
        if (searchValue != null && !searchValue.isEmpty()) {
            List<Product> productsbysearch = productRepository.findbysearch(searchValue);
            model.addAttribute("allproducts", productsbysearch);
        } else {
        products = productRepository.findAll();
        model.addAttribute("allproducts", products);
        }
        return "products";
    }
        @GetMapping("/add_product")
        public String addproductform (Model model){

            Product newproduct = new Product();
            model.addAttribute(newproduct);
            List<Users> usersList = usersRepository.findAll();
            model.addAttribute("userList", usersList);

        return "add_product";
        }
    @PostMapping("/add_product")
    public String saveNewProduct (@ModelAttribute("product") Product newproduct){
     productRepository.save(newproduct);
     return "redirect:/allproducts?success";
    }


    @GetMapping("allproducts/{id}")
    public String updateForm(@PathVariable(name = "id") Long id,Model model) {
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);

        List<Users> usersList = usersRepository.findAll();
        model.addAttribute("userList", usersList);

        return "update_product";
    }

    @PostMapping("updateproduct")
    public String updateProduct(@ModelAttribute("product") Product updateProduct,Model model) {

        Product existingproduct = productRepository.findById(updateProduct.getId()).orElse(null);
        if (existingproduct != null) {
            existingproduct.setProductCode(updateProduct.getProductCode());
            existingproduct.setSerialNumber(updateProduct.getSerialNumber());
            existingproduct.setDescription(updateProduct.getDescription());
            existingproduct.setLocation(updateProduct.getLocation());
            existingproduct.setComments(updateProduct.getComments());
            existingproduct.setOwner(updateProduct.getOwner());
            existingproduct.setDemo(updateProduct.getDemo());
            existingproduct.setReservedby(updateProduct.getReservedby());
        productRepository.save(existingproduct);
        }
        return "redirect:/allproducts?success2";
    }


    @GetMapping("delete/{id}")
    public String deleteproduct(@PathVariable(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/allproducts";

    }
    @GetMapping("exportproducts")
    public String exportproducts() {
        exportProductList.exportproductstofile_txt();
        return "redirect:/allproducts";
    }

    @GetMapping("exportproductsonlyblack")
    public String exportproductsonlyblack() {
        exportProductList.exportproductstofileonlyblack_txt();
        return "redirect:/allproducts";
    }


    @GetMapping("exportproductsonly3dparty")
    public String exportproductsonly3dparty() {
        exportProductList.exportproductstofileonly3dparty_txt();
        return "redirect:/allproducts";
    }




    @GetMapping("add_user")
    public String adduserform (Model model){
        Users newuser = new Users();
        model.addAttribute(newuser);
        List<Users> allusers = usersRepository.findAll();
        model.addAttribute("allusers", allusers);
        return "add_user";
    }
    @PostMapping("add_user")
    public String saveuser(@ModelAttribute(name = "users") Users newuser) {
        usersRepository.save(newuser);
        return "redirect:/add_user?success";
    }



}
