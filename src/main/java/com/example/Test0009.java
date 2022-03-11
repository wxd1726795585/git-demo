package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/3
 * \* Description:
 * \* @author 王祥栋
 */
@SpringBootTest
public class Test0009 {
    public static void main(String[] args) {
        String str="a";
        int a = str.lastIndexOf('a');
        System.out.println(a);
    }
    @Test
    public void test001(){
            //老板需要等待15个员工会议室开会
            final CountDownLatch latch = new CountDownLatch(15);
            for (int i = 0; i < 15; i++) {
                Random random = new Random();
                final int timer = random.nextInt(1000);
                new Thread(() -> {
                    try {
                        System.out.println("子线程" + Thread.currentThread().getName() + "正在赶路");
                        //模仿每个员工走自己线程需要的时间
                        Thread.sleep(20000 + timer);
                        //调用latch的countDown方法使计数器-1；一共15个
                        latch.countDown();
                        System.out.println("子线程" + Thread.currentThread().getName() + "到会议室了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            try {
                System.out.println("领导等待员工会议室开会...");
                //主线程阻塞等待计数器归零
                latch.await();
                System.out.println("员工都来了,会议开始");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
    @Test
    public void demo003(){
        List list = test0088();
        Teacher o = (Teacher)list.get(0);
        System.out.println(o);
        String o1 = (String)list.get(1);
        System.out.println(o1);
    }
    private List test0088(){
        Teacher teacher = new Teacher("赵六", 14);
        ArrayList<Object> list = new ArrayList<>();
        list.add(teacher);
        list.add("a");
        return list;
    }
    private void test002(Teacher teacher){
        teacher.setAge(15);
        teacher.setName("张三");
    }
    private void test003(Teacher teacher){
        teacher.setAge(16);
        teacher.setName("李四");
    }
    private void test004(Teacher teacher){
        teacher.setAge(17);
        teacher.setName("王五");
    }
    @Test
    public void demo006(){
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("张三",10));
        teachers.add(new Teacher("王五",11));
        teachers.add(new Teacher("李四",11));
        teachers.add(new Teacher("赵六",13));
        teachers.add(new Teacher("七七",3));
        //sort排序  正序就是 o1-o2 倒序则是o2-o1
        teachers.sort(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o2.getAge()- o1.getAge();
            }
        });
        //1.8流新特性(map 将list中的所有元素都套用这个函数)
        List<Integer> aaaaa = teachers.stream().map(Teacher::getAge).collect(Collectors.toList());
        //过滤 返回true则保留 false则返回(注意这里的x->{}  {}是一句搞不定逻辑可以在大括号中写,一句能搞定则可以不用大括号)

        //分组收集(根据年龄分组,值为年龄的集合)
        Map<Integer, List<Teacher>> collect1 = teachers.stream().collect(Collectors.groupingBy(x -> x.getAge()));
        System.out.println(collect1);
        //转为map(这里指的意思就是key为age value为name  后面的表达式,指key重复的时候取第一个还是第二个,如果不写的话,key重复则报错)
        Map<Integer, String> collect2 = teachers.stream().collect(Collectors.toMap(x -> x.getAge(), x -> x.getName(), (v1, v2) -> v1));
        System.out.println(collect2);


    }
    @Test
    public void test55(){
        String str="a,d,sa,a";
        String[] split = str.split(",");
        List<String> strings = Arrays.asList(split);

    }



}
@Data
@AllArgsConstructor
@ToString
class Teacher{
    private String name;
    private Integer age;

}