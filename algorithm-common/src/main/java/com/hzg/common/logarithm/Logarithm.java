package com.hzg.common.logarithm;

/**
 * 对数器接口
 * InType: 算法的输入类型
 * OutType: 算法的输出类型
 * @author zhengguohuang
 */
public interface Logarithm<InType, OutType> {
    /**
     * 绝对正确的方法
     * 好实现的方法,不用管时间复杂度
     * @param i 待处理的对象 如数组
     */
    public OutType rightMethod(InType i);

    /**
     * 生成长度和值都是随机的数组
     * @param size 返回的数组长度小于对于size
     * @param value
     * @return 生成的随机数组
     */
    public InType generateRandom(int size, int value);

    /**
     * 拷贝
     */
    public InType copy(InType i);

    /**
     * 比较两个T对象是否相同
     * @param o1 第一个对象
     * @param o2 第二个对象
     * @return
     */
    public boolean isEqual(OutType o1, OutType o2);

    /**
     * 用于打印出错的case
     * @param i
     */
    public void print(InType i);

    public void judge();

}
