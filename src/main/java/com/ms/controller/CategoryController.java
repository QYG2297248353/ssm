package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.pojo.Category;
import com.ms.service.CategoryService;
import com.ms.util.Page;

@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page) {
		System.out.println("输出开始1："+page.getStart());
//		显示判断->避免负数
		int starpage=page.getStart();
		ModelAndView mav = new ModelAndView();
//		首页->上一页
		if (page.getStart()<0) {
			page.setStart(0);
		}
		
		PageHelper.offsetPage(page.getStart(), 5);
		List<Category> cs = categoryService.list();
		int total=(int) new PageInfo<>(cs).getTotal();
		page.caculateLast(total);
		
//		末页->下一页
		if (page.getStart()>=page.getLast()) {
			page.setStart(page.getLast()-5);
		}
//		首页->上一页->解决地址栏负数->?start=-5
//		<=0会影响到首页->但是首页给定固定值无影响
		if (starpage<=0) {
			page.setStart(5);
		}
		System.out.println("输出开始2："+page.getStart());
		mav.addObject("cs", cs);
		mav.setViewName("listCategory");
		return mav;

	}
}
