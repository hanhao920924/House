package cn.han.house.util;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/14
 * @Description:
 * 分页工具类
 */
public class PageUtil {
    private Integer page=1;       //当前页码
    private Integer rows=3;      //页大小

    public PageUtil() {
    }

    public PageUtil(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
