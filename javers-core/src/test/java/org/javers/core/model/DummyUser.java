package org.javers.core.model;

import org.javers.core.metamodel.annotation.DiffIgnore;
import org.joda.time.LocalDateTime;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.*;

/**
 * @author bartosz walacik
 */
public class DummyUser extends AbstractDummyUser {

    public enum Sex {FEMALE, MALE, OCCASIONALLY}

    private transient int someTransientField;

    @Transient
    private int propertyWithTransientAnn;

    @DiffIgnore
    private int propertyWithDiffIgnoreAnn;

    //primitives and primitive boxes
    private boolean flag;
    private Boolean bigFlag;
    private int age;
    private char _char;
    private String surname;

    //enum
    private Sex sex;

    @Id
    private String name;
    private Integer largeInt;

    //collections
    private Set<String> stringSet;
    private List<Integer> integerList;
    private Map<String, LocalDateTime> primitiveMap;
    private Map<String, LocalDateTime> valueMap;
    private Map<String, DummyUserDetails> objectMap; //not supported

    //arrays
    private int[] intArray;
    private LocalDateTime[] dateTimes;

     //reference
    private DummyUser supervisor;
    private DummyUserDetails dummyUserDetails;
    private List<DummyUserDetails> dummyUserDetailsList;
    private List<DummyUser> employeesList;

    public DummyUser() {
    }

    public DummyUser(String name) {
        this.name = name;
    }

    public DummyUser(String name, String surname) {
        this(name);
        this.surname = surname;
    }

    public void addEmployee(DummyUser dummyUser) {
        if (employeesList == null) {
            employeesList = new ArrayList<>();
        }
        employeesList.add(dummyUser);
    }

    public Map<String, LocalDateTime> getValueMap() {
        return valueMap;
    }

    public int getSomeTransientField() {
        return someTransientField;
    }

    public DummyUser getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(DummyUser supervisor) {
        this.supervisor = supervisor;
    }

    public Boolean getBigFlag() {
        return bigFlag;
    }

    public void setBigFlag(Boolean bigFlag) {
        this.bigFlag = bigFlag;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Id
    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getLargeInt() {
        return largeInt;
    }

    public void setLargeInt(Integer largeInt) {
        this.largeInt = largeInt;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public void setSomeTransientField(int someTransientField) {
        this.someTransientField = someTransientField;
    }

    public Map<String, DummyUserDetails> getObjectMap() {
        return objectMap;
    }

    public DummyUserDetails getDummyUserDetails() {
        return dummyUserDetails;
    }

    public void setDummyUserDetails(DummyUserDetails dummyUserDetails) {
        this.dummyUserDetails = dummyUserDetails;
    }

    public List<DummyUserDetails> getDummyUserDetailsList() {
        return dummyUserDetailsList;
    }

    public void setDummyUserDetailsList(List<DummyUserDetails> dummyUserDetailsList) {
        this.dummyUserDetailsList = dummyUserDetailsList;
    }

    public List<DummyUser> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(DummyUser... employeesList) {
        this.employeesList = Arrays.asList(employeesList);
    }

    public void setValueMap(Map<String, LocalDateTime> valueMap) {
        this.valueMap = valueMap;
    }

    public void setObjectMap(Map<String, DummyUserDetails> objectMap) {
        this.objectMap = objectMap;
    }

    public void setEmployeesList(List<DummyUser> employeesList) {
        this.employeesList = employeesList;
    }


    public void setPrimitiveMap(Map<String, LocalDateTime> primitiveMap) {
        this.primitiveMap = primitiveMap;
    }

    public Map<String, LocalDateTime> getPrimitiveMap() {
        return primitiveMap;
    }

    public char getChar() {
        return _char;
    }

    public void setChar(char _char) {
        this._char = _char;
    }

    public LocalDateTime[] getDateTimes() {
        return dateTimes;
    }

    public void setDateTimes(LocalDateTime[] dateTimes) {
        this.dateTimes = dateTimes;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Transient
    public int getPropertyWithTransientAnn() {
        return propertyWithTransientAnn;
    }

    public void setPropertyWithTransientAnn(int propertyWithTransientAnn) {
        this.propertyWithTransientAnn = propertyWithTransientAnn;
    }

    @DiffIgnore
    public int getPropertyWithDiffIgnoreAnn() {
        return propertyWithDiffIgnoreAnn;
    }

    public void setPropertyWithDiffIgnoreAnn(int propertyWithDiffIgnoreAnn) {
        this.propertyWithDiffIgnoreAnn = propertyWithDiffIgnoreAnn;
    }
}
