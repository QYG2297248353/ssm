package com.ms.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
//	@Autowired
//	private CategoryMapper categoryMapper;
//
//	@Test
//	public void testAdd() {
//		for (int i = 1; i < 333; i++) {
//			Category category = new Category();
//			category.setName("�¶���"+i);
//			categoryMapper.add(category);
//		}
//
//	}
//
//	@Test
//	public void testCount() {
//		int count = categoryMapper.total();
//		System.out.println(count);
//	}
//
//	@Test
//	public void testList() {
//		Page p = new Page();
//		p.setStart(6);
//		p.setCount(11);
//		List<Category> cs = categoryMapper.list(p);
//		for (Category c : cs) {
//			System.out.println(c.getName());
//		}
//	}
}
