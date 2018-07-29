package com.seatech.controller;


import com.seatech.entity.Group;
import com.seatech.entity.Product;
import com.seatech.service.group_service.GroupService;
import com.seatech.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    GroupService groupService;
    @Autowired
    Environment env;

    @RequestMapping(value = "/allProduct")
    public String getAll(ModelMap modelMap) {
        modelMap.addAttribute("products", productService.getAll());
        return "index";
    }

    @RequestMapping(value = "/removeProduct/{id}")
    public String getAll(@PathVariable("id") String id) {
        productService.delete(id);
        return "redirect:/product/allProduct";
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam("key_word") String keyWord, ModelMap modelMap) {
        List<Product> products = productService.findByName(keyWord);
        modelMap.addAttribute("products", products);
        return "index";
    }

    @RequestMapping(value = "/find/{id}")
    public String findProductById(@PathVariable("id") String id, ModelMap modelMap) {
        Product product = productService.findById(id);
        if(product!=null){
            product.setGroup(groupService.findByProduct(product));
            List<Group> groups = groupService.getAll();
            modelMap.addAttribute("product", product);
            modelMap.addAttribute("groups", groups);
            return "edit-page";
        }
        return "error-page";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateProduct(@RequestParam("productId") String productId, @RequestParam("productName") String productName,
                                @RequestParam("price") float price, @RequestParam("description") String description,
                                @RequestParam("group") String group_param, ModelMap modelMap, HttpServletResponse response) throws IOException {
        if(productId!=null && productName!=null && group_param!=null && description!=null){
            try {
                Group group = groupService.findById(group_param);
                Product product = productService.findById(productId);
                product.setProductName(productName);
                product.setPrice(price);
                product.setDescription(description);
                product.setGroup(group);
                productService.update(product);
                response.getWriter().println(env.getProperty("success.product.update"));
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println(env.getProperty("fail.product.update"));
            }
        }else {
            response.getWriter().println(env.getProperty("form.input.empty"));
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProduct(@RequestParam("productId") String productId, @RequestParam("productName") String productName,
                             @RequestParam("price") float price, @RequestParam("description") String description,
                             @RequestParam("group") String group_param, ModelMap modelMap, HttpServletResponse response) throws IOException {
        if(productId!=null && productName!=null && group_param!=null && description!=null){
            try {
                if (!productService.existId(productId)) {
                    Group group = groupService.findById(group_param);
                    Product product = new Product();
                    product.setProductId(productId);
                    product.setProductName(productName);
                    product.setPrice(price);
                    product.setDescription(description);
                    product.setGroup(group);
                    product.setDeleted('N');
                    productService.add(product);
                    response.getWriter().println(env.getProperty("success.product.add"));
                } else {
                    response.getWriter().println(env.getProperty("fail.product.add"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println(env.getProperty("fail.product.duplicate.id"));
            }
        }else {
            response.getWriter().println(env.getProperty("form.input.empty"));
        }
    }

}
