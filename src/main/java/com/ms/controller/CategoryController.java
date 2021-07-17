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
		System.out.println("�����ʼ1��"+page.getStart());
//		��ʾ�ж�->���⸺��
		int starpage=page.getStart();
		ModelAndView mav = new ModelAndView();
//		��ҳ->��һҳ
		if (page.getStart()<0) {
			page.setStart(0);
		}
		
		PageHelper.offsetPage(page.getStart(), 5);
		List<Category> cs = categoryService.list();
		int total=(int) new PageInfo<>(cs).getTotal();
		page.caculateLast(total);
		
//		ĩҳ->��һҳ
		if (page.getStart()>=page.getLast()) {
			page.setStart(page.getLast()-5);
		}
//		��ҳ->��һҳ->�����ַ������->?start=-5
//		<=0��Ӱ�쵽��ҳ->������ҳ�����̶�ֵ��Ӱ��
		if (starpage<=0) {
			page.setStart(5);
		}
		System.out.println("�����ʼ2��"+page.getStart());
		mav.addObject("cs", cs);
		mav.setViewName("listCategory");
		return mav;

	}
}
