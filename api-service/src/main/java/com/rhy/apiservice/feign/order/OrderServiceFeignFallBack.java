package com.rhy.apiservice.feign.order;

import com.rhy.commonservice.entity.vo.order.OrderVO;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Herion Lemon
 * @date: 2021年01月28日 16:45:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 订单服务Feign API ，fallback失败回调
 */
@Component
@Data
@Accessors(chain = true)
@Slf4j
public class OrderServiceFeignFallBack implements OrderServiceFeign{
    private ThreadLocal<String> errormsg;
    /**
     * fallback失败时执行的方法
     * @param memId
     * @return
     */
    @Override
    public List<OrderVO> listOrder(Integer memId) {
        //打印一下错误信息，实际业务中应该做对应的处理
        log.error(errormsg.get());
        return null;
    }
}
