package com.endava.internship.collections;

import java.util.*;

public class StudentMap implements Map<Student, Integer> {

    private int size = 1;

    private StudentNode[] table;

    public StudentMap(int size) {
        table = new StudentNode[size];
        this.size = size;
    }

    public StudentMap() {
        table = new StudentNode[size];
    }

    private StudentMap(StudentMap sourceMap, StudentMap secondMap) {
        int commonSize = sourceMap.size() + secondMap.size();
        this.table = new StudentNode[commonSize];
        this.size = sourceMap.size() + secondMap.size();
    }

    private void setTable(StudentNode[] table) {
        this.table = table;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        int currentSize = table.length;
        return currentSize == 0;
    }

    @Override
    public Integer put(Student student, Integer value) {

        int hash = student.hashCode() % size;
        StudentNode temp = table[hash];
        String key = student.getStudentKey();

        if (table[hash] == null) {
            table[hash] = new StudentNode(student, value, null);
        } else {
            while (temp.getNext() != null) {
                if (temp.key.getStudentKey().equals(key)) {
                    temp.setValue(value);
                    return temp.value;
                }
                temp = temp.getNext();
            }

            if (temp.key.getStudentKey().equals(key)) {
                temp.setValue(value);
                return temp.value;
            }

            temp.setNext(new StudentNode(student, value, null));
        }
        return value;
    }

    @Override
    public Integer get(Object o) {
        Student student = (Student) o;
        String key = student.getStudentKey();
        int hash = student.hashCode() % size;

        StudentNode temp = table[hash];

        if (temp == null) {
            return null;
        }
        while (temp.getNext() != null) {
            if (temp.key.getStudentKey().equals(key)) {
                return temp.value;
            }
            temp = temp.getNext();
        }

        temp.key.getStudentKey();

        return temp.value;
    }

    @Override
    public Integer remove(Object o) {
        Student student = (Student) o;
        String key = student.getStudentKey();
        int hash = student.hashCode() % size;
        StudentNode temp = table[hash];

        if (temp.getKey().getStudentKey().equals(key)) {
            table[hash] = temp.getNext();
            return null;
        }

        while (temp.getNext() != null) {
            if (temp.getNext().getKey().getStudentKey().equals(key)) {
                temp.setNext(temp.getNext().getNext());
                return temp.value;
            }
            temp = temp.getNext();
        }

        return null;
    }

    @Override
    public boolean containsKey(Object o) {
        return get(o) != null;
    }

    @Override
    public boolean containsValue(Object o) {
        Integer value = (Integer) o;
        StudentNode[] studentNodes;
        if ((studentNodes = table) != null && size > 0) {
            for (StudentNode node : studentNodes) {
                for (; node != null; node = node.getNext()) {
                    if (value.equals(node.value)) {
                        System.out.println(value);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void putAll(Map<? extends Student, ? extends Integer> map) {

        StudentMap studentMap = new StudentMap(this, ((StudentMap) map));

        for (StudentNode student : ((StudentMap) map).table) {
            for (; student != null; student = student.getNext()) {
                studentMap.put(student.key, student.value);
            }
        }

        for (StudentNode cell : table) {
            for (; cell != null; cell = cell.getNext()) {
                studentMap.put(cell.key, cell.value);
            }
        }
        setTable(studentMap.table);
    }

    @Override
    public void clear() {
        table = null;
    }

    @Override
    public Set<Student> keySet() {
        Set<Student> studentsSet = new HashSet<>();
        for (StudentNode cell : table) {
            for (; cell != null; cell = cell.getNext()) {
                studentsSet.add(cell.getKey());
            }
        }
        return studentsSet;
    }

    @Override
    public Collection<Integer> values() {
        Collection<Integer> studentCollection = new ArrayList<>();
        for (StudentNode cell : table) {
            for (; cell != null; cell = cell.getNext()) {
                studentCollection.add(cell.getValue());
            }
        }
        return studentCollection;
    }

    @Override
    public Set<Entry<Student, Integer>> entrySet() {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {

        StudentNode[] studentNodes = table;
        int i = 0;

        if (studentNodes != null) {
            for (StudentNode node : studentNodes) {
                if (node != null) {
                    System.out.print(i + " ");
                    while (node.getNext() != null) {
                        System.out.print(" " + node.getKey().getName() + " -> " + node.value);
                        node = node.getNext();
                    }
                    System.out.print(" " + node.getKey().getName() + " -> " + node.value);
                    System.out.println();
                }
                i++;
            }
        } else {
            return null;
        }
        return "";
    }

    public static class StudentNode implements Map.Entry<Student, Integer> {

        private final Student key;
        private Integer value;
        private StudentNode next;

        StudentNode(Student key, Integer value, StudentNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Student getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public Integer setValue(Integer value) {
            Integer oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public void setNext(StudentNode next) {
            this.next = next;
        }

        public StudentNode getNext() {
            return next;
        }

        @Override
        public String toString() {
            return key + ", ";
        }
    }
}

