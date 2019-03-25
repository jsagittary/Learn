package com.learn.architect.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhouJie
 * @date: Create in 2019-02-20 11:44
 * @description:
 * @modified By:
 */
public class InterfaceExecute {

    public Map<Integer, PartySupplyHandler> partySupplyHandlerMap = new HashMap<>();

    {
        registerSupplyHandler(1, (supplyType, params) -> System.out.println(1));
        registerSupplyHandler(2, (supplyType, params) -> System.out.println(2));
        registerSupplyHandler(3, (supplyType, params) -> System.out.println(3));
        registerSupplyHandler(4, (supplyType, params) -> System.out.println(4));
        registerSupplyHandler(5, (supplyType, params) -> System.out.println(5));
    }

    private void registerSupplyHandler(int supplyType, PartySupplyHandler handler) {
        partySupplyHandlerMap.put(supplyType, handler);
    }

    private interface PartySupplyHandler {
        void execute(int supplyType, int... param);
    }

    public static void main(String[] args) {
        /*InterfaceExecute interfaceExecute = new InterfaceExecute();
        interfaceExecute.partySupplyHandlerMap.get(1).execute(1, 1);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).forEach(System.out::println);

        List<Person> arr = Arrays
                .asList(new Person("John", "Smith"), new Person("Anna", "Martinez"), new Person("Paul", "Watson "));

        System.out.println(arr.stream().map(Person::toString).collect(Collectors.joining(",")));
        Optional<Object> o = Optional.ofNullable(new Object());
        Optional<Object> o1 = Optional.ofNullable(1);
        System.out.println(o);
        System.out.println(o.isPresent());
        System.out.println(o1);
        System.out.println(o1.isPresent());*/

        // System.out.println(isTrue(1));
        // System.out.println(isTrue(2));
        // System.out.println(isTrue(0));
        // Date date = new Date(new Long(0) * 1000L);
        // Date date1 = new Date();
        // System.out.println(dayiy(date, date1));
        HashMap<Integer, Map<Integer, Integer>> map1 = new HashMap<>();
        map1.remove(0);
        HashMap<Integer, Integer> mapmap = new HashMap<>();
    }

    /**
     * 第几天,同一天为第一天
     *
     * @param origin
     * @param now
     * @return
     */
    static public int dayiy(Date origin, Date now) {
        Calendar orignC = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        orignC.setTime(origin);
        orignC.set(Calendar.HOUR_OF_DAY, 0);
        orignC.set(Calendar.MINUTE, 0);
        orignC.set(Calendar.SECOND, 0);
        orignC.set(Calendar.MILLISECOND, 0);

        calendar.setTime(now);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return (int) ((calendar.getTimeInMillis() - orignC.getTimeInMillis()) / (24 * 3600 * 1000)) + 1;
    }

    public static boolean isTrue(int i) {
        return i == 1 || i == 2;
    }
}
