package com.tsvico.blog.web;

import com.tsvico.blog.Controller404;
import com.tsvico.blog.po.Type;
import com.tsvico.blog.service.BlogService;
import com.tsvico.blog.service.TypeService;
import com.tsvico.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author tsvico
 * @email tsxygwj@gmail.com
 * @time 2019/8/22 22:01
 * 功能//定义控制器
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 10, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable String id, Model model) {
        //只要足够大，就能查全表
        List<Type> types = typeService.listTypeTop(300);
        Long newId;
        try {
           newId = Long.parseLong(id);
        }catch (Exception e){
            throw new Controller404();
        }
        if (newId == -1) {
            newId= types.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(newId);
        model.addAttribute("types", types);
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        model.addAttribute("activeTypeid", newId);
        return "types";
    }
}
