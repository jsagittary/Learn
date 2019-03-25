package com.learn.architect.callbyval;

/**
 * @author: ZhouJie
 * @date: Create in 2018-11-20 16:34
 * @description:
 * @modified By:
 */
public class ExampleThree {

    public static void main(String[] args) {
        // Force f1 = new Force(1, 1);
        // Force f2 = new Force(1, 1);
        // Force f3 = new Force(2, 2);
        // Force f4 = new Force(2, 2);
        // List<Force> forces = new ArrayList<>();
        // forces.add(f1);
        // forces.add(f2);
        // forces.add(f3);
        // forces.add(f4);
        //
        // Map<Long, Integer> map = forces.stream().collect(
        //         Collectors.toMap(f -> f.getRoleId(), f -> f.getCnt(), (existVal, newVal) -> existVal + newVal));
        // System.out.println(map);

        int[] arr = {1,2,3,4,5};

        change(arr);

        System.out.println(arr[0]);
    }

    public static void change(int[] array) {
        array = new int[1];

        System.out.println(array[0]);
    }


    public static void swap(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }

    static class Student {

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    static class Force {

        private long roleId;
        private int cnt;

        public Force(long roleId, int cnt) {
            this.roleId = roleId;
            this.cnt = cnt;
        }

        public long getRoleId() {
            return roleId;
        }

        public int getCnt() {
            return cnt;
        }
    }

}
