package com.pwc.sdc.babycare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pwc.sdc.babycare.domain.User;
import com.pwc.sdc.babycare.service.UserService;
import com.pwc.sdc.babycare.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Xinhua X Yang
* @description 针对表【BC_USER(用户信息表)】的数据库操作Service实现
* @createDate 2024-04-03 10:38:02
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




