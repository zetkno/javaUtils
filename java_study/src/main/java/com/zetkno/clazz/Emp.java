package com.zetkno.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

class EmpDemo {
    public static void main(String[] args) {
        String value = "empno:1234|name:史密斯|job:programmer|salary:8000|hireDate:2019-10-10|" +
                        "dept.dname:财务部|dept.company.name:腾讯公司";
        Emp emp = ClassInstanceFactory.create(Emp.class, value);

        System.out.println("员工编号:"+ emp.getEmpno() + ", 姓名:" + emp.getName() + ", 职位:" + emp.getJob() + ", 薪资:" + emp.getSalary() + ", 入职日期:" + emp.getHireDate());
        System.out.println(emp.getDept());
        System.out.println("company:" + emp.getDept().getCompany());
    }
}

//按 | 分割
class BeanUtils {
    private BeanUtils() {}

    /**
     * 实现指定对象的属性设置
     * @param obj 要进行反射操作的实例化对象
     * @param value
     */
//    "empno:1234|name:史密斯|job:programmer|salary:8000|hireDate:2019-10-10|dept.dname:财务部|dept.company.name:腾讯公司";
    public static void setValue(Object obj, String value) throws Exception{
        String[] result = value.split("\\|");
        for (int x = 0; x < result.length; x++) {
            String[] attval = result[x].split(":");
                if (attval[0].contains(".")) {   //多级配置
                    String[] temp = attval[0].split("\\.");
                    Object currentObject = obj;
                    for (int y = 0; y < temp.length - 1; y++) {
                        System.out.println(temp[y]);
                        Method getMethod = currentObject.getClass().getDeclaredMethod("get" + StringUtils.initcap(temp[y]));
                        Object tempObject = getMethod.invoke(currentObject);
                        if (tempObject == null) {
                            Field field = currentObject.getClass().getDeclaredField(temp[y]);
                            Method method = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[y]), field.getType());
                            Object newObject = field.getType().getDeclaredConstructor().newInstance();
                            method.invoke(currentObject, newObject);
                            currentObject = newObject;
                            System.out.println("currentObject: " + currentObject.toString());
                        } else {
                            currentObject = tempObject;
                        }

                    }
                    Field field = currentObject.getClass().getDeclaredField(temp[temp.length - 1]);
                } else {
                    Field field = obj.getClass().getDeclaredField(attval[0]);
                    Method setMethod = obj.getClass().getDeclaredMethod("set" + StringUtils.initcap(attval[0]), field.getType());
                    Object convertValue = BeanUtils.convertAttributeValue(field.getType().getName(), attval[1]);
                    setMethod.invoke(obj, convertValue);
                }
        }
    }
    public static Object convertAttributeValue(String type, String value) {
        if ("long".equals(type) || "java.lang.Long".equals(type)) {
            return Long.parseLong(value);
        } else if ("int".equals(type) || "java.lang.int".equals(type)) {
            return Integer.parseInt(value);
        } else if ("double".equals(type) || "java.lang.double".equals(type)) {
            return Double.parseDouble(value);
        } else if ("java.util.Date".equals(type)) {
            SimpleDateFormat sdf = null;
            if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                return new Date();
            }
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
                return new Date();
            }
        }
        return value;
    }
}

class ClassInstanceFactory {
    private ClassInstanceFactory() {}

    /**
     * 实例化对象的创建方法，该对象可以根据传入的字符串结构 "属性：内容|属性：内容"
     *
     * @param clazz 要进行反射实例化的Class对象，有Class就可以反射实例化对象
     * @param value 要设置给的属性内容
     * @return 一个已经配置好的属性内容的Java类对象
     */
    public static <T> T create(Class<?> clazz, String value) {
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(obj, value);
            return (T) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

/**
 * 首字母大写
 */
class StringUtils {
    public static String initcap(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}

class Company {
    private String name;
    private Date createdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}

class Dept {
    private String dname;
    private String loc;
    private Company company;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        System.out.println("setCompany");
        this.company = company;
    }
}

public class Emp {
    private long empno;
    private String name;
    private String job;
    private double salary;
    private Date hireDate;
    private Dept dept;
    public Emp() {

    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
