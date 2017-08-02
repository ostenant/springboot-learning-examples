package org.ostenant.springboot.learning.examples;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ostenant.springboot.learning.examples.page.mapper.InstituteMapper;
import org.ostenant.springboot.learning.examples.page.model.Institute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationTests.class);

    private InstituteMapper instituteMapper;

    @Autowired
    public void setInstituteMapper(InstituteMapper instituteMapper) {
        this.instituteMapper = instituteMapper;
    }

    /**
     * pageNum代表当前查询的页码, pageSize代表每一页的最大记录数。
     */
    @Test
    public void testStartPage() throws Exception {
        PageHelper.startPage(1, 10);
        instituteMapper.findAll().stream().forEach(System.out::println);
    }

    /**
     * offSet代表当前数据库表记录的偏移量, pageSize代表每一页的最大记录数。
     */
    @Test
    public void testOffsetPage() throws Exception {
        PageHelper.offsetPage(10, 10);
        instituteMapper.findAll().stream().forEach(System.out::println);
    }

    /**
     * 获取Page对象 - JDK6, 7
     *
     * @throws Exception
     */
    @Test
    public void testDoSelectPageInJDK7() throws Exception {
        Page<Institute> page = PageHelper.startPage(2, 20).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                instituteMapper.findAll();
            }
        });

        LOGGER.info("当前页码为: {}", page.getPageNum());
        LOGGER.info("每页最大记录数为: {}", page.getPageSize());
        LOGGER.info("总页数为: {}", page.getPages());
        LOGGER.info("总记录数为: {}", page.getTotal());
        LOGGER.info("当前页起始行为: {}", page.getStartRow());
        LOGGER.info("当前页结束行为: {}", page.getEndRow());

        page.getResult().stream().forEach(item -> LOGGER.info("{}", item));
    }

    /**
     * 获取Page对象 - JDK8
     *
     * @throws Exception
     */
    @Test
    public void testDoSelectPageInJDK8() throws Exception {
        Page<Institute> page = PageHelper.startPage(2, 20)
                .doSelectPage(() -> instituteMapper.findAll());

        LOGGER.info("当前页码为: {}", page.getPageNum());
        LOGGER.info("每页最大记录数为: {}", page.getPageSize());
        LOGGER.info("总页数为: {}", page.getPages());
        LOGGER.info("总记录数为: {}", page.getTotal());
        LOGGER.info("当前页起始行为: {}", page.getStartRow());
        LOGGER.info("当前页结束行为: {}", page.getEndRow());

        page.getResult().stream().forEach(item -> LOGGER.info("{}", item));

    }

    /**
     * 获取PageInfo对象 - JDK6, 7
     *
     * @throws Exception
     */
    @Test
    public void testDoSelectPageInfoInJDK7() throws Exception {
        PageInfo<Institute> pageInfo = PageHelper.startPage(2, 20).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                instituteMapper.findAll();
            }
        });

        LOGGER.info("当前页码为: {}", pageInfo.getPageNum());
        LOGGER.info("每页最大记录数为: {}", pageInfo.getPageSize());
        LOGGER.info("总页数为: {}", pageInfo.getPages());
        LOGGER.info("总记录数为: {}", pageInfo.getTotal());

        LOGGER.info("当前页起始行为: {}", pageInfo.getStartRow());
        LOGGER.info("当前页结束行为: {}", pageInfo.getEndRow());

        LOGGER.info("是否为第一页: {}", pageInfo.isIsFirstPage());
        LOGGER.info("是否有上一页: {}", pageInfo.isHasPreviousPage());
        LOGGER.info("是否有下一页: {}", pageInfo.isHasNextPage());
        LOGGER.info("是否为最后一页: {}", pageInfo.isIsLastPage());

        LOGGER.info("第一页为: {}", pageInfo.getFirstPage());
        LOGGER.info("上一页为: {}", pageInfo.getPrePage());
        LOGGER.info("下一页为: {}", pageInfo.getNextPage());
        LOGGER.info("最后一页为: {}", pageInfo.getLastPage());

        pageInfo.getList().stream().forEach(item -> LOGGER.info("{}", item));
    }

    /**
     * 获取PageInfo对象 - JDK8
     *
     * @throws Exception
     */
    @Test
    public void testDoSelectPageInfoJDK8() throws Exception {
        PageInfo<Institute> pageInfo = PageHelper.startPage(2, 20).doSelectPageInfo(() -> instituteMapper.findAll());

        LOGGER.info("当前页码为: {}", pageInfo.getPageNum());
        LOGGER.info("每页最大记录数为: {}", pageInfo.getPageSize());
        LOGGER.info("总页数为: {}", pageInfo.getPages());
        LOGGER.info("总记录数为: {}", pageInfo.getTotal());

        LOGGER.info("当前页起始行为: {}", pageInfo.getStartRow());
        LOGGER.info("当前页结束行为: {}", pageInfo.getEndRow());

        LOGGER.info("是否为第一页: {}", pageInfo.isIsFirstPage());
        LOGGER.info("是否有上一页: {}", pageInfo.isHasPreviousPage());
        LOGGER.info("是否有下一页: {}", pageInfo.isHasNextPage());
        LOGGER.info("是否为最后一页: {}", pageInfo.isIsLastPage());

        LOGGER.info("第一页为: {}", pageInfo.getFirstPage());
        LOGGER.info("上一页为: {}", pageInfo.getPrePage());
        LOGGER.info("下一页为: {}", pageInfo.getNextPage());
        LOGGER.info("最后一页为: {}", pageInfo.getLastPage());

        pageInfo.getList().stream().forEach(item -> LOGGER.info("{}", item));
    }

    /**
     * 获取符合条件的记录数 - JDK8
     *
     * @throws Exception
     */
    @Test
    public void testDoCount() throws Exception {
        long totalCount = PageHelper.count(() -> instituteMapper.findAll());
        LOGGER.info("满足条件的总记录数: {}", totalCount);
    }

}
