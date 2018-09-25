package kr.pravusid.dto;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

public class PaginationTest {

    @Test
    public void 페이지계산_결과를_확인한다() {
        List<String> data = Arrays.asList("고길동", "둘리", "도우너", "희동이", "피카츄", "라이츄", "망나뇽");
        Page<String> page = new PageImpl<>(data, new PageRequest(5, 1), data.size());
        Pagination pagination = new Pagination();
        pagination.calcPage(page, 5);
        Assert.assertEquals(pagination.getCurrPage(), 5);
        Assert.assertEquals(pagination.getTotalPages(), 6);
        Assert.assertEquals(pagination.getFirstBlock(), 5);
        Assert.assertEquals(pagination.getLastBlock(), 6);
        Assert.assertEquals(pagination.getPrev(), 4);
        Assert.assertEquals(pagination.getNext(), 6);

        page = new PageImpl<>(data, new PageRequest(2, 1), data.size());
        pagination = new Pagination();
        pagination.calcPage(page, 5);
        Assert.assertEquals(pagination.getCurrPage(), 2);
        Assert.assertEquals(pagination.getTotalPages(), 6);
        Assert.assertEquals(pagination.getFirstBlock(), 0);
        Assert.assertEquals(pagination.getLastBlock(), 4);
        Assert.assertEquals(pagination.getPrev(), 0);
        Assert.assertEquals(pagination.getNext(), 5);

        data = Arrays.asList("고길동", "둘리", "도우너", "희동이", "피카츄");
        page = new PageImpl<>(data, new PageRequest(4, 1), data.size());
        pagination = new Pagination();
        pagination.calcPage(page, 5);
        Assert.assertEquals(pagination.getCurrPage(), 4);
        Assert.assertEquals(pagination.getTotalPages(), 4);
        Assert.assertEquals(pagination.getFirstBlock(), 0);
        Assert.assertEquals(pagination.getLastBlock(), 4);
        Assert.assertEquals(pagination.getPrev(), 0);
        Assert.assertEquals(pagination.getNext(), 4);
    }

}
