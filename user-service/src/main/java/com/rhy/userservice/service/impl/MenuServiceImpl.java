package com.rhy.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhy.mapperservice.entity.Menu;
import com.rhy.mapperservice.mapper.MenuDao;
import com.rhy.userservice.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {

}
