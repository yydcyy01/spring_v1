package com.yydcyy.service;

/**
 *
 * 账户的业务层接口
 * 3 个具有代表性的 : ① 无参无返回值 ② 有参无返回值 ③ 无参有返回值  (其他类型组合即可)
 * @author YYDCYY
 * @create 2019-09-27
 */
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * @return
     */
    int  deleteAccount();
}
